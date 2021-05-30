package models;
import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "reservation")
public class Reservation {
	    
    @DatabaseField(id = true)
    private Integer id;
    
    @DatabaseField(canBeNull=false, foreign=true, foreignColumnName="id")
    private Appartement appartement;

	@DatabaseField
	private String nom;

	@DatabaseField
	private String prenom;

	@DatabaseField
	private Date date_debut;

	@DatabaseField
	private Integer nombre_jours;
    
    public Reservation() {
    }

	public Reservation(Appartement appartement, String nom, String prenom, Date date_debut, Integer nombre_jours) {
		super();
		this.appartement = appartement;
		this.nom = nom;
		this.prenom = prenom;
		this.date_debut = date_debut;
		this.nombre_jours = nombre_jours;
	}

	public Integer getId() {
		return id;
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

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Integer getNombre_jours() {
		return nombre_jours;
	}

	public void setNombre_jours(Integer nombre_jours) {
		this.nombre_jours = nombre_jours;
	}
    
}