package com.projet.app.models;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "densite")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Densite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String libelle;
	private Long prix;

}

