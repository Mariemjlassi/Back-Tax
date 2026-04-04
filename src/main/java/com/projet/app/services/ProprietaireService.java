package com.projet.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.app.models.Proprietaire;
import com.projet.app.repository.ProprietaireRepository;

@Service
public class ProprietaireService {

		@Autowired
		private ProprietaireRepository pr;
		
		public Proprietaire create(Proprietaire proprietaire) {
			Proprietaire existingProprietaire=pr.findByCin(proprietaire.getCin());
			if(existingProprietaire!=null) {
				existingProprietaire.setAdresse(proprietaire.getAdresse());
	            existingProprietaire.setCin(proprietaire.getCin());
	            existingProprietaire.setNom(proprietaire.getNom());
	            existingProprietaire.setPrenom(proprietaire.getPrenom());
	            existingProprietaire.setEmail(proprietaire.getEmail());
	            existingProprietaire.setTel(proprietaire.getTel());
	            return pr.save(existingProprietaire);
			}else {
				return pr.save(proprietaire);
				}
			
		}
		
		public List<Proprietaire> read(){
			return pr.findAll();
		}
		
		public Proprietaire readById(Long id) {
			Optional<Proprietaire> prop = pr.findById(id);
			if(prop.isPresent()) {
				return prop.get();
			}else {
				return null;
			}
		}
		
		public void deleteProp(final Long id) {
			pr.deleteById(id);
		}
		
		public Proprietaire update(Long id, Proprietaire proprietaire) {
			Optional<Proprietaire> prop = pr.findById(id);
			if(prop.isPresent()) {
				Proprietaire existingProprietaire = prop.get();
				existingProprietaire.setAdresse(proprietaire.getAdresse());
				existingProprietaire.setCin(proprietaire.getCin());
				existingProprietaire.setNom(proprietaire.getNom());
				existingProprietaire.setPrenom(proprietaire.getPrenom());
				existingProprietaire.setEmail(proprietaire.getEmail());
				existingProprietaire.setTel(proprietaire.getTel());
				return pr.save(existingProprietaire);
				
		}
			return null;
		}
		
		
}
