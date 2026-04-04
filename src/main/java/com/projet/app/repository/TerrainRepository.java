package com.projet.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.app.models.Terrain;



@Repository
public interface TerrainRepository extends JpaRepository<Terrain, Long>{
	Terrain findByAdresse(String adresse);
}
