package com.projet.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.app.models.Proprietaire;
import com.projet.app.services.ProprietaireService;


@RestController
@RequestMapping("/proprietaire")
public class ProprietaireController {
	
	
	@Autowired
	private ProprietaireService ps;
	
	@PostMapping
	public Proprietaire addProp(@RequestBody Proprietaire proprietaire) {
		return ps.create(proprietaire);
	}
	
	@GetMapping
	public List<Proprietaire> getAllProp(){
		return ps.read();
	}
	
	@GetMapping("/{id}")
	public Proprietaire getPropById(@PathVariable ("id") Long id) {
		return ps.readById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProprietaire(@PathVariable("id") Long id) {
		ps.deleteProp(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Proprietaire> update(@PathVariable("id") Long id,@RequestBody Proprietaire proprietaire){
		Proprietaire p=ps.update(id, proprietaire);
		if(p == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		return ResponseEntity.ok(p);
	}
	
	 
}
