package gestionCinema.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import gestionCinema.bo.Reservation;
import gestionCinema.dao.ReservationDAOJDBCImpl;

@Service
@Primary
public class ReservationManager {
	
	@Autowired
	ReservationDAOJDBCImpl dao;
	
	public List<Reservation> selectAll() {
		return (List<Reservation>) dao.findAll();
	}

	public Reservation selectById(int id) {
		return dao.findById(id).orElse(null);
	}

	public Reservation insert(Reservation reservationToInsert) {
		return dao.save(reservationToInsert);
	}

	public Reservation delete(Reservation selectById) {
		dao.delete(selectById);
		return selectById;
	}

	public Reservation update(Reservation reservationToUpdate) {
		return dao.save(reservationToUpdate);
	}
}
