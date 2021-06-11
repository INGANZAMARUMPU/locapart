package api;
import java.sql.SQLException;
import java.util.ArrayList;
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
		return Response.ok(villes).header("Access-Control-Allow-Origin", "*").build();
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
		return Response.ok(ville).header("Access-Control-Allow-Origin", "*").build();
	}

	@GET 
	@Path("ville/{id}/appartements/")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getVilleAppartement(@PathParam("id") String ville_id) {
		
		List<Appartement> appartements = new ArrayList();
		try {
			appartements = new DataBank().appartement_dao.queryForEq("ville_id", ville_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.ok(appartements).header("Access-Control-Allow-Origin", "*").build();
	}

	@POST 
	@Path("/louer/")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response louerAppartemet(ReservationPostSerializer reservationPostSerializer) {
		System.out.println(reservationPostSerializer.toString());
		try {
			Dao<Appartement, Integer> appart_dao = new DataBank().appartement_dao;
			new DataBank().reservation_dao.create(reservationPostSerializer.toReservation(appart_dao));
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(400).entity(e.getMessage()).type(MediaType.APPLICATION_JSON).build();
		}
		return Response.ok("{\"message\":\"Reservation réussie\"}").header("Access-Control-Allow-Origin", "*").build();
	}
}   