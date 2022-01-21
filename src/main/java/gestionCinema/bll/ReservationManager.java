package gestionCinema.bll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import gestionCinema.bo.Reservation;
import gestionCinema.dao.ReservationDAOJDBCImpl;

@Service
@Primary
public class ReservationManager extends CrudManager<Reservation, ReservationDAOJDBCImpl> {

	@Autowired
	ClientManager clientManager;
	
	@Autowired
	BlackListManager blackListManager;

	@Override
	public Reservation insert(Reservation reservation) throws ReservationException {
		if(blackListManager.isBlackListed(reservation.getClient())) {
			throw new ReservationException("Client sur la black list");
		}
		if (reservation.getClient().getClientId() == null) {
			try {
				clientManager.insert(reservation.getClient());
			} catch (Exception e) {
				throw new ReservationException(e.getMessage());
			}
		}
		return dao.save(reservation);
	}
	
	@Override
	public Reservation update(Reservation reservation) throws ReservationException {
		if(blackListManager.isBlackListed(reservation.getClient())) {
			throw new ReservationException("Client sur la black list");
		}
		if (reservation.getClient().getClientId() == null) {
			try {
				clientManager.insert(reservation.getClient());
			} catch (Exception e) {
				throw new ReservationException(e.getMessage());
			}
		}
		return dao.save(reservation);
	}

}
