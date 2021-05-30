package api;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import models.*;

import javax.ws.rs.GET;  
import javax.ws.rs.Path;  
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
}   