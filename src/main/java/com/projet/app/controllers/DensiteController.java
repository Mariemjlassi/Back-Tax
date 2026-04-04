package com.projet.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.app.models.Densite;
import com.projet.app.services.DensiteService;

@RestController
@RequestMapping("/densite")
public class DensiteController {
	
	@Autowired
	private DensiteService ds;
	
	@PostMapping
	public Densite addDensite(@RequestBody Densite densité) {
		return ds.create(densité);
	}
	@GetMapping
	public List<Densite> getAll(){
		return ds.read();
	}

}
