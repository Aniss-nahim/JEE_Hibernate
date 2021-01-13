package dao.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="voitures")

public class Voiture implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String matricule;
	
	@ManyToOne
	private Personne pers;
	
	@ManyToMany
	@JoinTable(
			name="voiture_chauffeur",
			joinColumns = @JoinColumn(
						name="V_id",
						referencedColumnName = "id"
					),
			inverseJoinColumns = @JoinColumn(
						name="C_id",
						referencedColumnName = "id"
					)
	)	
	private List<Chauffeur> chauffeurs = new ArrayList<Chauffeur>();
	
	
	public Voiture() {
		// constructor
	}
	
	public Voiture(Long id, String nom, String matricule) {
		super();
		this.id = id;
		this.nom = nom;
		this.matricule = matricule;
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
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
}
