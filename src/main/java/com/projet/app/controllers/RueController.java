package com.projet.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.app.models.Rue;

import com.projet.app.services.RueService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/rues")
public class RueController {
	
	@Autowired
	private RueService rs;
	
	@PostMapping("/{zone_id}")
	public Rue addRue(@PathVariable Long zone_id,@RequestBody Rue rue) {
		return rs.create(zone_id,rue);
	}
	
	@GetMapping
	public List<Rue> getAllRue(){
		return rs.read();
	}
	
	@GetMapping("/{id}")
	public Rue getRueById(@PathVariable("id") Long id) {
		return rs.readById(id);
	}
	
	@GetMapping("/zone/{zone_id}")
	public List<Rue> getRueByZone(@PathVariable Long zone_id){
		return rs.getRueByZone(zone_id);
	}
	
	@DeleteMapping("/{id}")
	public void deleterue(@PathVariable("id") Long id) {
		rs.delete(id);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Rue> update(@PathVariable("id") Long id,@RequestBody Rue rue){
		Rue r=rs.update(id, rue);
		if(r == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		return ResponseEntity.ok(r);
	}
	
	
	

}
