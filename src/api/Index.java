package api;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import models.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.Where;

@Path("/")  
public class Index {
	
	@GET  
	@Produces({MediaType.APPLICATION_JSON})  
	public Response villes() {
		
		List<Ville> villes = new ArrayList<Ville>();
		try {
			villes = new DataBank().ville_dao.queryForAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.ok(villes).build();
	}

	@GET 
	@Path("ville/{id}/")
	@Produces({MediaType.APPLICATION_JSON})  
	public Response getVille(@PathParam("id") String id) {
		
		Ville ville = null;
		try {
			ville = new DataBank().ville_dao.queryForId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.ok(ville).build();
	}

	@GET 
	@Path("ville/{id}/appartements/{semaine}/")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getVilleAppartement(@PathParam("id") String ville_id, @PathParam("semaine") Integer semaine) {

		List<Appartement> apparts = new ArrayList();
		List<Appartement> appartements = new ArrayList();
		try {
			Dao<Appartement, Integer> dao = new DataBank().appartement_dao;
			
			apparts = dao.queryForEq("ville_id", ville_id);
			ArrayList<Integer> reservs = new ArrayList<>();
			for (Appartement appartement : apparts) {
				reservs = appartement.getReservations();
				if(!reservs.contains(semaine)){
					appartements.add(appartement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.ok(appartements).build();
	}

	@GET 
	@Path("/appartement/{id}/")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getAppartement(@PathParam("id") Integer appart_id) {
		
		Appartement appartement = null;
		try {
			Dao<Appartement, Integer> dao = new DataBank().appartement_dao;
			appartement = dao.queryForId(appart_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.ok(appartement).build();
	}

	@POST 
	@Path("/louer/")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response louerAppartemet(ReservationPostSerializer reservationPostSerializer) {
		Reservation reservation;
		try {
			Dao<Appartement, Integer> appart_dao = new DataBank().appartement_dao;
			reservation = reservationPostSerializer.toReservation(appart_dao);
			
			Appartement appartement  = reservation.getAppartement();
			ArrayList<Integer> reservations = appartement.getReservations();
			for (int i = reservation.getSemaine_debut(); i < reservation.getSemaine_fin(); i++) {
				if (reservations.contains(i)){
					return Response.status(403).entity("la reservation contient une semaine prise").type(MediaType.APPLICATION_JSON).build();
				}
			}
			
			new DataBank().reservation_dao.create(reservation);
			return Response.ok(reservation).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(400).entity(e.getMessage()).type(MediaType.APPLICATION_JSON).build();
		}
	}
}   