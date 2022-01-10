package rest;

import java.util.List;

import bll.ReservationManager;
import bo.Reservation;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;


@Path("reservation")
public class ReservationREST {
	@GET
	public List<Reservation> getReservation() {
		return ReservationManager.selectAll();
	}

	@GET
	@Path("/{id:\\d+}")
	public Reservation getReservationById(@PathParam("id") int id) {
		return ReservationManager.selectById(id);
	}

	@POST
	public Reservation insertReservation(@FormParam("content") String content) {
		Reservation reservationToInsert = new Reservation();
		// TODO code the form treatment
		return ReservationManager.insert(reservationToInsert);
	}

	@PUT
	@Path("/{id :  \\d+}")
	public Reservation updateReservation(@PathParam("id") int id, @FormParam("content") String content) {
		Reservation reservationToUpdate = ReservationManager.selectById(id);
		// TODO code the form treatment
		return ReservationManager.update(reservationToUpdate);
	}

	@DELETE
	@Path("/{id :  \\d+}")
	public Reservation deleteReservationById(@PathParam("id") int id) {
		return ReservationManager.delete(ReservationManager.selectById(id));
	}
}
