package gestionCinema.bll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import gestionCinema.bo.Reservation;
import gestionCinema.dao.ReservationDAOJDBCImpl;

@Service
@Primary
public class ReservationManager extends CrudManager<Reservation, ReservationDAOJDBCImpl>{
	
	@Autowired
	ClientManager clientManager;
	
	@Override
	public Reservation insert(Reservation reservation) {
		if(reservation.getClient().getClientId()==null) {
			clientManager.insert(reservation.getClient());
		}
		return dao.save(reservation);
	}
}
