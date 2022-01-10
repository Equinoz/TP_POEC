package rest;

import java.util.List;

import bll.FilmManager;
import bo.Film;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;


@Path("film")
public class FilmREST {
	@GET
	public List<Film> getSceance() {
		return FilmManager.selectAll();
	}

	@GET
	@Path("/{id:\\d+}")
	public Film getSceanceById(@PathParam("id") int id) {
		return FilmManager.selectById(id);
	}

	@POST
	public Film insertSceance(@FormParam("content") String content) {
		Film filmToInsert = new Film();
		// TODO code the form treatment
		return FilmManager.insert(filmToInsert);
	}

	@PUT
	@Path("/{id :  \\d+}")
	public Film updateSceance(@PathParam("id") int id, @FormParam("content") String content) {
		Film filmToUpdate = FilmManager.selectById(id);
		// TODO code the form treatment
		return FilmManager.update(filmToUpdate);
	}

	@DELETE
	@Path("/{id :  \\d+}")
	public Film deleteSceanceById(@PathParam("id") int id) {
		return FilmManager.delete(FilmManager.selectById(id));
	}
}
