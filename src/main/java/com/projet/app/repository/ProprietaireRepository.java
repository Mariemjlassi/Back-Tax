package com.projet.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.app.models.Proprietaire;


@Repository
public interface ProprietaireRepository extends JpaRepository<Proprietaire, Long>{
	Proprietaire findByCin(String cin);

}
