package gestionCinema.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestionCinema.bll.ReservationManager;
import gestionCinema.bo.Reservation;


@RestController
@RequestMapping("/WS/reservation")
public class ReservationREST implements CrudREST<Reservation> {
	@Autowired
	ReservationManager manager;

	@Override
	public List<Reservation> getAll() {
		return manager.selectAll();
	}

	@Override
	public Reservation getById(Integer id) {
		return manager.selectById(id);
	}

	@Override
	public Reservation insert(Reservation objectToInsert) {
		return manager.insert(objectToInsert);
	}

	@Override
	public Reservation update(Integer id, Reservation objectToUpdate) {
		return manager.update(objectToUpdate);
	}

	@Override
	public Reservation deleteById(Integer id) {
		return manager.delete(manager.selectById(id));
	}


}
