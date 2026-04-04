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
@Table(name = "proprietaire")
@NoArgsConstructor
@AllArgsConstructor
public class Proprietaire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private String cin;
	private String adresse;
	private String email;
	private String tel;
	
	public Proprietaire(String nom,String prenom,String cin,String adresse,String email, String tel) {
		super();
		this.nom=nom;
		this.prenom=prenom;
		this.cin=cin;
		this.adresse=adresse;
		this.email=email;
		this.tel=tel;
	}
}
