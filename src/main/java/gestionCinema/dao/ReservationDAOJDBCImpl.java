package gestionCinema.dao;

import org.springframework.data.repository.CrudRepository;

import gestionCinema.bo.Reservation;

public interface ReservationDAOJDBCImpl extends CrudRepository<Reservation, Integer> {	

}
