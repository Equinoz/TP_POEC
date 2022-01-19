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

import gestionCinema.bll.FilmManager;
import gestionCinema.bo.Film;


@RestController
public class FilmREST {

	@Autowired
	FilmManager manager;

	@GetMapping("WS/film")
	public List<Film> getClient() {
		return manager.selectAll();
	}

	@GetMapping("WS/film/{id}")
	public Film getClientById(@PathVariable("id") int id) {
		return manager.selectById(id);
	}

	@PostMapping("WS/film")
	public Film insertClient(@RequestBody Film clientToInsert) {
		return manager.insert(clientToInsert);
	}

	@PutMapping("WS/film/{id}")
	public Film updateClient(@PathVariable("id") int id, @RequestBody Film clientToUpdate) {
		return manager.update(clientToUpdate);
	}

	@DeleteMapping("WS/film/{id}")
	public Film deleteClientById(@PathVariable("id") int id) {
		return manager.delete(manager.selectById(id));
	}
}
