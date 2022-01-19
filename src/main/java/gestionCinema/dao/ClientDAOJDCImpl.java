package gestionCinema.dao;


import org.springframework.data.repository.CrudRepository;

import gestionCinema.bo.Client;

public interface ClientDAOJDCImpl extends CrudRepository<Client, Integer> {
	
}
