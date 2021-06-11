package models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.j256.ormlite.dao.Dao;

public class ReservationPostSerializer {
    private Integer appartement_id;
	private String nom;
	private String prenom;
	private String date_debut;
	private Integer nombre_jours;
	
	public ReservationPostSerializer() {
	}

//	public ReservationPostSerializer(int appartement_id, String nom, String prenom, String date_debut, Integer nombre_jours) {
//		super();
//		this.appartement_id = appartement_id;
//		this.nom = nom;
//		this.prenom = prenom;
//		this.date_debut = date_debut;
//		this.nombre_jours = nombre_jours;
//	}

	public int getAppartement_id() {
		return appartement_id;
	}

	public void setAppartement_id(int appartement_id) {
		this.appartement_id = appartement_id;
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

	public String getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}

	public Integer getNombre_jours() {
		return nombre_jours;
	}

	public void setNombre_jours(Integer nombre_jours) {
		this.nombre_jours = nombre_jours;
	}

	public Reservation toReservation(Dao<Appartement, Integer> dao) {
		try {
			Appartement appartement = dao.queryForId(appartement_id);
			Reservation reservation = new Reservation();
			reservation.setAppartement(appartement);
			reservation.setNom(nom);
			reservation.setPrenom(prenom);
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
			Date date = formatter.parse(date_debut);
			reservation.setDate_debut(date);
			
			reservation.setNombre_jours(nombre_jours);
			return reservation;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String toString() {
		return "ReservationPostSerializer [appartement_id=" + appartement_id + ", nom=" + nom + ", prenom=" + prenom
				+ ", date_debut=" + date_debut + ", nombre_jours=" + nombre_jours + "]";
	}
	
}