package com.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="marques")
public class Marque implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	
	@OneToMany(mappedBy="marque")
	private List<Voiture> voiutres = new ArrayList<Voiture>();
	
	public Marque() {
		// Constructor
	}
	
	public Marque(Long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Voiture> getVoiutres() {
		return voiutres;
	}

	public void setVoiutres(List<Voiture> voiutres) {
		this.voiutres = voiutres;
	}
	
}
