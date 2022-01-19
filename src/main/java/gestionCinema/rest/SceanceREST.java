package gestionCinema.rest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gestionCinema.bll.SceanceManager;
import gestionCinema.bo.Sceance;

@RestController
public class SceanceREST {
	
	
	@Autowired
	SceanceManager manager;

	@GetMapping("WS/sceance")
	public List<Sceance> getClient() {
		return manager.selectAll();
	}

	@GetMapping("WS/sceance/{id}")
	public Sceance getClientById(@PathVariable("id") int id) {
		return manager.selectById(id);
	}

	@PostMapping("WS/sceance")
	public Sceance insertClient(@RequestBody Sceance clientToInsert) {
		return manager.insert(clientToInsert);
	}

	@PutMapping("WS/sceance/{id}")
	public Sceance updateClient(@PathVariable("id") int id, @RequestBody Sceance clientToUpdate) {
		return manager.update(clientToUpdate);
	}

	@DeleteMapping("WS/sceance/{id}")
	public Sceance deleteClientById(@PathVariable("id") int id) {
		return manager.delete(manager.selectById(id));
	}

	@GetMapping("WS/sceance/withRemainingSeats")
	public List<Sceance> getSceanceWithRemainigSeats() {
		return manager.getSceanceWithRemainigSeats();
	}

	@GetMapping("/WS/sceance/byFilmId/{id}")
	public List<Sceance> getSceanceByFilm(@PathVariable("id") Integer filmId) {
		return manager.getSceanceByFilm(filmId);
	}

	@PostMapping("/WS/sceance/byDate")
	public List<Sceance> getSceanceByDate(@RequestBody LocalDate date) {
		return manager.getSceanceByDate(date);
	}

}
