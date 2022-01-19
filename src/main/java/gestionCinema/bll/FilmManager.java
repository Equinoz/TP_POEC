package gestionCinema.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import gestionCinema.bo.Film;
import gestionCinema.dao.FilmDAOJDBCImpl;

@Service
@Primary
public class FilmManager {
	
	@Autowired
	FilmDAOJDBCImpl dao;
	
	public  List<Film> selectAll() {
		return (List<Film>) dao.findAll();
	}

	public  Film selectById(int id) {
		return dao.findById(id).orElse(null);
	}

	public  Film insert(Film filmToInsert) {
		return dao.save(filmToInsert);
	}

	public  Film delete(Film selectById) {
		dao.delete(selectById);
		return selectById;
	}

	public  Film update(Film filmToUpdate) {
		return dao.save(filmToUpdate);
	}
}
