package com.projet.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.app.models.Zone;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Long>{
	List<Zone> findByArrondissementId(Long arrondissement_id);
}
