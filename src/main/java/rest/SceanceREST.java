package rest;

import java.util.List;

import bll.SceanceManager;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import bo.Sceance;

@Path("sceance")
public class SceanceREST {
	@GET
	public List<Sceance> getSceance() {
		return SceanceManager.allSceance();
	}

	@GET
	@Path("/{id:\\d+}")
	public Sceance getSceanceById(@PathParam("id") int id) {
		return SceanceManager.selectById(id);
	}

	@POST
	public Sceance insertSceance(@FormParam("content") String content) {
		Sceance sceanceToInsert = new Sceance();
		// TODO code the form treatment
		return SceanceManager.insert(sceanceToInsert);
	}

	@PUT
	@Path("/{id :  \\d+}")
	public Sceance updateSceance(@PathParam("id") int id, @FormParam("content") String content) {
		Sceance sceanceToUpdate = SceanceManager.selectById(id);
		// TODO code the form treatment
		return SceanceManager.update(sceanceToUpdate);
	}

	@DELETE
	@Path("/{id :  \\d+}")
	public Sceance deleteSceanceById(@PathParam("id") int id) {
		return SceanceManager.delete(SceanceManager.selectById(id));
	}
}
