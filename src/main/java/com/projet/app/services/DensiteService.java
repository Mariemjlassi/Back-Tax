package com.projet.app.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.app.models.Densite;
import com.projet.app.repository.DensiteRepository;

@Service
public class DensiteService {
	@Autowired
	private DensiteRepository dr;
	
	public Densite create(Densite densite) {
		return dr.save(densite);
	}
	
	public List<Densite> read(){
		return dr.findAll();
	}
	
	public Densite findById(Long id) {
		return dr.findById(id).orElse(null);
	}

}
