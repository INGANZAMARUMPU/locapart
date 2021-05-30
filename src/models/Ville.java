package models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "ville")
public class Ville {
	    
    @DatabaseField(id = true)
    private Integer id;

	@DatabaseField
	private String nom;

	@DatabaseField
	private Double longitude;

	@DatabaseField
	private Double latitude;
    
    public Ville() {
    }

	public Ville(String nom, Double longitude, Double latitude) {
		super();
		this.nom = nom;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public Integer getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
    
}