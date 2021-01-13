package dao.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="personnes")
public class Personne implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String ville;
	
	@OneToMany(mappedBy="pers")
	private List<Voiture> voiutres = new ArrayList<Voiture>();
	
	public Personne() {
		// Constructor
	}
	
	public Personne(Long id, String nom, String ville) {
		super();
		this.id = id;
		this.nom = nom;
		this.ville = ville;
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

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public List<Voiture> getVoiutres() {
		return voiutres;
	}

	public void setVoiutres(List<Voiture> voiutres) {
		this.voiutres = voiutres;
	}
	
}
