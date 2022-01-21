package gestionCinema.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestionCinema.bll.FilmManager;
import gestionCinema.bo.Film;


@RestController
@RequestMapping("/WS/film")
public class FilmREST implements CrudREST<Film>{

	@Autowired
	FilmManager manager;

	@Override
	public List<Film> getAll() {
		return manager.selectAll();
	}

	@Override
	public Film getById(Integer id) {
		return manager.selectById(id);
	}

	@Override
	public Film insert(Film objectToInsert) throws Exception {
		return manager.insert(objectToInsert);
	}

	@Override
	public Film update(Integer id, Film objectToUpdate) throws Exception {
		return manager.update(objectToUpdate);
	}

	@Override
	public Film deleteById(Integer id) {
		return manager.delete(manager.selectById(id));
	}


}
