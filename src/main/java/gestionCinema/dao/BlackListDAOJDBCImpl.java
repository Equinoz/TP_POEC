package gestionCinema.dao;

import org.springframework.data.repository.CrudRepository;

import gestionCinema.bo.BlackList;

public interface BlackListDAOJDBCImpl extends CrudRepository<BlackList, Integer> {

}
