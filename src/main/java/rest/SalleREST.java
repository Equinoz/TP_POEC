package rest;

import java.util.List;

import bll.SalleManager;
import bo.Salle;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("salle")
public class SalleREST {
	@GET
	public List<Salle> getSalle() {
		return SalleManager.selectAll();
	}

	@GET
	@Path("/{id:\\d+}")
	public Salle getSalleById(@PathParam("id") int id) {
		return SalleManager.selectById(id);
	}

	@POST
	public Salle insertSalle(@FormParam("content") String content) {
		Salle salleToInsert = new Salle();
		// TODO code the form treatment
		return SalleManager.insert(salleToInsert);
	}

	@PUT
	@Path("/{id :  \\d+}")
	public Salle updateSalle(@PathParam("id") int id, @FormParam("content") String content) {
		Salle salleToUpdate = SalleManager.selectById(id);
		// TODO code the form treatment
		return SalleManager.update(salleToUpdate);
	}

	@DELETE
	@Path("/{id :  \\d+}")
	public Salle deleteSceanceById(@PathParam("id") int id) {
		return SalleManager.delete(SalleManager.selectById(id));
	}
}
