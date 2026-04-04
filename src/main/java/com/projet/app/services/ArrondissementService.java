package com.projet.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.projet.app.models.Arrondissement;

import com.projet.app.repository.ArrondissementRepository;

@Service
public class ArrondissementService {
	
	@Autowired
	private ArrondissementRepository ar;
	
	public Arrondissement create(Arrondissement arrondissement) {
		
		return ar.save(arrondissement);
		
	}
	
	public List<Arrondissement> read(){
		
		return ar.findAll();
	}
	
	public  Arrondissement read(Long id) {
		Optional<Arrondissement> arrondissement = ar.findById(id);
		if(arrondissement.isPresent()) {
			return arrondissement.get();
		}else {
			return null;
		}
	}
	
	public void deleteArrondissement(final Long id) {
		ar.deleteById(id);
		
	}
	
	public Arrondissement update(Long id, Arrondissement arrondissement) {
		Optional<Arrondissement> arr = ar.findById(id);
		if(arr.isPresent()) {
			Arrondissement existingArrondissement = arr.get();
			existingArrondissement.setNom(arrondissement.getNom());
			return ar.save(existingArrondissement);
			
			
	}
		return null;
	}
}
