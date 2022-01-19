package gestionCinema.dao;

import org.springframework.data.repository.CrudRepository;

import gestionCinema.bo.Sceance;

public interface SceanceDAOJDBCImpl extends CrudRepository<Sceance, Integer> {

}
