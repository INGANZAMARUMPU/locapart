package models;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "appartement")
public class Appartement {
    
	@DatabaseField(id = true)
	private Integer id;
	
	@DatabaseField(canBeNull=false, foreign=true, foreignColumnName="id")
	private Ville ville;
	
	@DatabaseField
	private String nom;
	
	@DatabaseField
	private Float taille;
	
	@DatabaseField
	private String image;
	
	@DatabaseField
	private Float prix;
	
	@DatabaseField(dataType=DataType.LONG_STRING)
	private String Details;

	public Appartement() {
		super();
	}

	public Appartement(Integer id, Ville ville, String nom, Float taille, String image, Float prix, String details) {
		super();
		this.id = id;
		this.ville = ville;
		this.nom = nom;
		this.taille = taille;
		this.image = image;
		this.prix = prix;
		Details = details;
	}

	public Integer getId() {
		return id;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Float getTaille() {
		return taille;
	}

	public void setTaille(Float taille) {
		this.taille = taille;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Float getPrix() {
		return prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}

	public String getDetails() {
		return Details;
	}

	public void setDetails(String details) {
		Details = details;
	}
	
	

}
