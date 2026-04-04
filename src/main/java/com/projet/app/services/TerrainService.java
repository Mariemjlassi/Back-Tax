package com.projet.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.app.models.Terrain;

import com.projet.app.repository.TerrainRepository;

@Service
public class TerrainService {
	
	@Autowired
	private TerrainRepository tr;
	
public Terrain create(Terrain terrain){
		Terrain exisTerrain=tr.findByAdresse(terrain.getAdresse());
		if(exisTerrain!=null) {
			exisTerrain.setAdresse(terrain.getAdresse());
			exisTerrain.setSurface(terrain.getSurface());
			exisTerrain.setProprietaire(terrain.getProprietaire());
			exisTerrain.setRue(terrain.getRue());
			return tr.save(exisTerrain);
		}else {
			return tr.save(terrain);
		}
		
	}
	
	public List<Terrain> read(){
		
		return tr.findAll();
	}
	
	public  Terrain read(Long id) {
		Optional<Terrain> terrain = tr.findById(id);
		if(terrain.isPresent()) {
			return terrain.get();
		}else {
			return null;
		}
	}
	
	public void deleteTerrain(Long id) {
		tr.deleteById(id);
	}
	
	public Terrain update(Long id, Terrain terrain) {
		Optional<Terrain> t= tr.findById(id);
		if(t.isPresent()) {
			Terrain existingTerrain=t.get();
			existingTerrain.setAdresse(terrain.getAdresse());
			existingTerrain.setSurface(terrain.getSurface());
			return tr.save(existingTerrain);
		}
		return null;
	}

}
