package com.projet.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.app.dto.CalculTaxeDTO;
import com.projet.app.models.Densite;
import com.projet.app.models.Proprietaire;
import com.projet.app.models.Terrain;
import com.projet.app.repository.ProprietaireRepository;
import com.projet.app.repository.TerrainRepository;

import jakarta.transaction.Transactional;

@Service
public class TaxeService {
	@Autowired
	private ProprietaireRepository proprietaireRepository;
	
	@Autowired
    private TerrainRepository terrainRepository;
	
	public void enregistrerProprietaireEtTerrain(Proprietaire proprietaire, Terrain terrain) {
        Proprietaire savedProprietaire = proprietaireRepository.save(proprietaire);
        terrain.setProprietaire(savedProprietaire);
        terrainRepository.save(terrain);
    }
	
	@Autowired
	private DensiteService densiteService;
	@Transactional
	public Double calculerTaxe(CalculTaxeDTO calculTaxeDTO) {
		double surface = calculTaxeDTO.getSurface();
		
		if ("valeurVenale".equals(calculTaxeDTO.getMethodeCalcul())) {
			double valeurVenale = calculTaxeDTO.getValeurVenale();
			return  (valeurVenale * 3) / 1000;
		} else if ("densite".equals(calculTaxeDTO.getMethodeCalcul())) {
			 Long  densiteId =calculTaxeDTO.getDensiteId();
	            Densite densité = densiteService.findById(densiteId);
	            return densité.getPrix()* surface;
		}else {
			return -1.0;
		}
	}

}
