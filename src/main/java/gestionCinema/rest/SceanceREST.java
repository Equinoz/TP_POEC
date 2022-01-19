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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestionCinema.bll.SceanceManager;
import gestionCinema.bo.Sceance;

@RestController
@RequestMapping("/WS/sceance")
public class SceanceREST implements CrudREST<Sceance> {

	@Autowired
	SceanceManager manager;

	@GetMapping("/withRemainingSeats")
	public List<Sceance> getSceanceWithRemainigSeats() {
		return manager.getSceanceWithRemainigSeats();
	}

	@GetMapping("/byFilmId/{id}")
	public List<Sceance> getSceanceByFilm(@PathVariable("id") Integer filmId) {
		return manager.getSceanceByFilm(filmId);
	}

	@PostMapping("/byDate")
	public List<Sceance> getSceanceByDate(@RequestBody LocalDate date) {
		return manager.getSceanceByDate(date);
	}

	@Override
	public List<Sceance> getAll() {
		return manager.selectAll();
	}

	@Override
	public Sceance getById(Integer id) {
		return manager.selectById(id);
	}

	@Override
	public Sceance insert(Sceance objectToInsert) {
		return manager.insert(objectToInsert);
	}

	@Override
	public Sceance update(Integer id, Sceance objectToUpdate) {
		return manager.update(objectToUpdate);
	}

	@Override
	public Sceance deleteById(Integer id) {
		return manager.delete(manager.selectById(id));
	}

}
