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
	private String longitude;

	@DatabaseField
	private String latitude;
    
    public Ville() {
    }
    

	public Ville(Integer id, String nom, String longitude, String latitude) {
		super();
		this.id = id;
		this.nom = nom;
		this.longitude = longitude;
		this.latitude = latitude;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	
}