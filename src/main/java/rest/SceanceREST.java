package rest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import bll.FilmManager;
import bll.SalleManager;
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
		return SceanceManager.selectAll();
	}

	@GET
	@Path("/{id:\\d+}")
	public Sceance getSceanceById(@PathParam("id") int id) {
		return SceanceManager.selectById(id);
	}

	@GET
	@Path("/withRemainingSeats")
	public List<Sceance> getSceanceWithRemainigSeats() {
		return SceanceManager.getSceanceWithRemainigSeats();
	}

	@GET
	@Path("/byFilmId/{id:\\\\d+}")
	public List<Sceance> getSceanceByFilm(@PathParam("id") Integer filmId) {
		return SceanceManager.getSceanceByFilm(filmId);
	}

	@POST
	@Path("/byDate")
	public List<Sceance> getSceanceByDate(@FormParam("date") String date) {
		return SceanceManager.getSceanceByDate(LocalDate.parse(date));
	}

	@POST
	public Sceance insertSceance(@FormParam("date") String dateTime,
			@FormParam("film") String filmId,
			@FormParam("prix") String prix,
			@FormParam("langue") String vostfr,
			@FormParam("id_salle") String salleId) {
		Sceance sceanceToInsert = new Sceance();
		sceanceToInsert.setHoraireSceance(LocalDateTime.parse(dateTime));
		sceanceToInsert.setFilmAssocie(FilmManager.selectById(Integer.parseInt(filmId)));
		sceanceToInsert.setPrix(Integer.parseInt(prix));
		sceanceToInsert.setVostfr(Boolean.parseBoolean(vostfr));
		sceanceToInsert.setSalleAssociee(SalleManager.selectById(Integer.parseInt(salleId)));
		return SceanceManager.insert(sceanceToInsert);
	}

	@PUT
	@Path("/{id :  \\d+}")
	public Sceance updateSceance(@PathParam("id") int id, @FormParam("date") String dateTime,
			@FormParam("film") String filmId,
			@FormParam("prix") String prix,
			@FormParam("langue") String vostfr,
			@FormParam("id_salle") String salleId) {
		Sceance sceanceToUpdate = SceanceManager.selectById(id);
		sceanceToUpdate.setHoraireSceance(LocalDateTime.parse(dateTime));
		sceanceToUpdate.setFilmAssocie(FilmManager.selectById(Integer.parseInt(filmId)));
		sceanceToUpdate.setPrix(Integer.parseInt(prix));
		sceanceToUpdate.setVostfr(Boolean.parseBoolean(vostfr));
		sceanceToUpdate.setSalleAssociee(SalleManager.selectById(Integer.parseInt(salleId)));
		return SceanceManager.update(sceanceToUpdate);
	}

	@DELETE
	@Path("/{id :  \\d+}")
	public Sceance deleteSceanceById(@PathParam("id") int id) {
		return SceanceManager.delete(SceanceManager.selectById(id));
	}
}
