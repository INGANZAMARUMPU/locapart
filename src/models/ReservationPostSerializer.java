package models;

import com.j256.ormlite.dao.Dao;

public class ReservationPostSerializer {
    private Integer appartement_id;
	private String nom;
	private String prenom;
	private Integer semaine;
	private Integer nombre;
	
	public ReservationPostSerializer() {
	}

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

	public Integer getSemaine() {
		return semaine;
	}

	public void setSemaine(Integer semaine) {
		this.semaine = semaine;
	}

	public Integer getNombre() {
		return nombre;
	}

	public void setNombre(Integer nombre) {
		this.nombre = nombre;
	}

	public void setAppartement_id(Integer appartement_id) {
		this.appartement_id = appartement_id;
	}

	public Reservation toReservation(Dao<Appartement, Integer> dao) {
		try {
			Appartement appartement = dao.queryForId(appartement_id);
			Reservation reservation = new Reservation();
			reservation.setAppartement(appartement);
			reservation.setNom(nom);
			reservation.setPrenom(prenom);
			reservation.setSemaine_debut(semaine);
			reservation.setSemaine_fin(semaine + nombre);
			return reservation;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String toString() {
		return "ReservationPostSerializer [appartement_id=" + appartement_id + ", nom=" + nom + ", prenom=" + prenom
				+ ", semaine=" + semaine + ", nombre=" + nombre + "]";
	}
	
	
}