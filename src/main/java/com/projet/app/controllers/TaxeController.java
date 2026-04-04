package com.projet.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.app.dto.CalculTaxeDTO;
import com.projet.app.dto.ProprietaireEtTerrainDTO;
import com.projet.app.models.Proprietaire;
import com.projet.app.models.Terrain;
import com.projet.app.services.TaxeService;

@RestController
@RequestMapping("/taxe")
public class TaxeController {
	
	@Autowired
    private TaxeService taxeService;
	
	
	
	@PostMapping("/calcul")
	public ResponseEntity<Double> calculerTaxe(@RequestBody CalculTaxeDTO calculTaxeDTO) {
        Double taxeResult = taxeService.calculerTaxe(calculTaxeDTO);
        return ResponseEntity.ok(taxeResult);
    }
	
	@PostMapping("/enregistrerProprietaireEtTerrain")
    public ResponseEntity<String> enregistrerProprietaireEtTerrain(@RequestBody ProprietaireEtTerrainDTO dto) {
        
        Proprietaire proprietaire = new Proprietaire(dto.getNom(), dto.getPrenom(), dto.getCin(), dto.getAdresse(),dto.getEmail(),dto.getTel());
        Terrain terrain = new Terrain(dto.getSurface(), dto.getAdresse());
        
        
        taxeService.enregistrerProprietaireEtTerrain(proprietaire, terrain);
        
        return ResponseEntity.ok("Enregistrement réussi !");
    }

}
