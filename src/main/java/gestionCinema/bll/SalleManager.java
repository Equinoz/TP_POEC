package gestionCinema.bll;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import gestionCinema.bo.Salle;
import gestionCinema.dao.SalleDAOJDBClmpl;

@Service
@Primary
public class SalleManager extends CrudManager<Salle, SalleDAOJDBClmpl> {
	
}
