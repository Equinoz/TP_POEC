package gestionCinema.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gestionCinema.bll.ReservationManager;
import gestionCinema.bo.Reservation;


@RestController
public class ReservationREST {
	@Autowired
	ReservationManager manager;

	@GetMapping("WS/reservation")
	public List<Reservation> getClient() {
		return manager.selectAll();
	}

	@GetMapping("WS/reservation/{id}")
	public Reservation getClientById(@PathVariable("id") int id) {
		return manager.selectById(id);
	}

	@PostMapping("WS/reservation")
	public Reservation insertClient(@RequestBody Reservation clientToInsert) {
		return manager.insert(clientToInsert);
	}

	@PutMapping("WS/reservation/{id}")
	public Reservation updateClient(@PathVariable("id") int id, @RequestBody Reservation clientToUpdate) {
		return manager.update(clientToUpdate);
	}

	@DeleteMapping("WS/reservation/{id}")
	public Reservation deleteClientById(@PathVariable("id") int id) {
		return manager.delete(manager.selectById(id));
	}
}
