package bll;

import java.util.List;

import bo.Film;
import dao.FilmDAOJDBCImpl;

public class FilmManager {
	public static List<Film> selectAll() {
		return FilmDAOJDBCImpl.selectAll();
	}

	public static Film selectById(int id) {
		return FilmDAOJDBCImpl.selectById(id);
	}

	public static Film insert(Film filmToInsert) {
		return FilmDAOJDBCImpl.insert(filmToInsert);
	}

	public static Film delete(Film selectById) {
		return FilmDAOJDBCImpl.delete(selectById);
	}

	public static Film update(Film filmToUpdate) {
		return FilmDAOJDBCImpl.update(filmToUpdate);
	}
}
