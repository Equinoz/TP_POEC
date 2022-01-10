package bll;

import java.util.List;

import bo.Reservation;
import dao.ReservationDAOJDBCImpl;

public class ReservationManager {
	public static List<Reservation> selectAll() {
		return ReservationDAOJDBCImpl.selectAll();
	}

	public static Reservation selectById(int id) {
		return ReservationDAOJDBCImpl.selectById(id);
	}

	public static Reservation insert(Reservation reservationToInsert) {
		return ReservationDAOJDBCImpl.insert(reservationToInsert);
	}

	public static Reservation delete(Reservation selectById) {
		return ReservationDAOJDBCImpl.delete(selectById);
	}

	public static Reservation update(Reservation reservationToUpdate) {
		return ReservationDAOJDBCImpl.update(reservationToUpdate);
	}
}
