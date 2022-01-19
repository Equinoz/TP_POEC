package gestionCinema.bll;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import gestionCinema.bo.Film;
import gestionCinema.dao.FilmDAOJDBCImpl;

@Service
@Primary
public class FilmManager extends CrudManager<Film, FilmDAOJDBCImpl> {

}
