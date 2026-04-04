package com.projet.app.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "arrondissements")
@AllArgsConstructor
@NoArgsConstructor
public class Arrondissement {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String nom;
	
	
}
