package com.projet.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.app.dto.ZoneRequest;
import com.projet.app.models.Zone;
import com.projet.app.services.ZoneService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/zones")
public class ZoneController {
	
	@Autowired
	private ZoneService zs;
	
	@PostMapping("/{arr_id}")
    public Zone addZone(@PathVariable Long arr_id,@RequestBody Zone zone) {
        return zs.create(arr_id, zone);
    }
	
	@GetMapping
	public List<Zone> getAllZone(){
		return zs.read();
	}
	
	@GetMapping("/{id}")
	public Zone getZoneById(@PathVariable ("id") Long id) {
		return zs.read(id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		zs.deleteZone(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Zone> update(@PathVariable("id") Long id,@RequestBody Zone zone){
		Zone zone2=zs.update(id, zone);
		if(zone2 == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		return ResponseEntity.ok(zone2);
	}
	
	@GetMapping("/arrondissement/{arrondissement_id}")
	public List<Zone> getZoneByArrondissement(@PathVariable Long arrondissement_id ){
		return zs.getZoneByArrondissement(arrondissement_id);
	}
	
	
}
