package models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "reservation")
public class Reservation {
	    
    @DatabaseField(generatedId=true)
    private Integer id;
    
    @DatabaseField(canBeNull=false, foreign=true, foreignColumnName="id")
    private Appartement appartement;

	@DatabaseField(canBeNull=false)
	private String nom;

	@DatabaseField(canBeNull=false)
	private String prenom;

	@DatabaseField(canBeNull=false)
	private Integer semaine_debut;

	@DatabaseField(canBeNull=false)
	private Integer semaine_fin;
    
    public Reservation() {
    }

	public Reservation(Appartement appartement, String nom, String prenom, Integer semaine_debut, Integer semaine_fin) {
		super();
		this.appartement = appartement;
		this.nom = nom;
		this.prenom = prenom;
		this.semaine_debut = semaine_debut;
		this.semaine_fin = semaine_fin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Appartement getAppartement() {
		return appartement;
	}

	public void setAppartement(Appartement appartement) {
		this.appartement = appartement;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Integer getSemaine_debut() {
		return semaine_debut;
	}

	public void setSemaine_debut(Integer semaine_debut) {
		this.semaine_debut = semaine_debut;
	}

	public Integer getSemaine_fin() {
		return semaine_fin;
	}

	public void setSemaine_fin(Integer semaine_fin) {
		this.semaine_fin = semaine_fin;
	}

	
    
}