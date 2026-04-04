package com.projet.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.app.models.DBUser;



@Repository
public interface DBUserRepository extends JpaRepository<DBUser, Long>{
	
	boolean existsByEmail(String email);
	Optional<DBUser>  findByEmail(String email);
}
