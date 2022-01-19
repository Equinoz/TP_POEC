package gestionCinema.dao;

import org.springframework.data.repository.CrudRepository;

import gestionCinema.bo.Film;

public interface FilmDAOJDBCImpl extends CrudRepository<Film, Integer> {


}