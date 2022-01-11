package bll;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import bo.Film;
import bo.Sceance;
import dao.SceanceDAOJDBCImpl;

public class SceanceManager {
	public static List<Sceance> selectAll() {
		return SceanceDAOJDBCImpl.selectAll();
	}

	public static List<Sceance> getSceanceWithRemainigSeats() {
		List<Sceance> lst = new ArrayList<Sceance>();
		for (Sceance sc : selectAll()) {
			if (sc.getOccupation() < sc.getSalleAssociee().getCapacité()) {
				lst.add(sc);
			}
		}
		return lst;
	}

	public static List<Sceance> getSceanceByFilm(Integer id){
		List<Sceance> lst = new ArrayList<Sceance>();
		for (Sceance sc : selectAll()) {
			if (sc.getFilmAssocie().getFilmId().equals(id)) {
				lst.add(sc);
			}
		}
		return lst;
	}
	
	public static List<Sceance> getSceanceByDate(LocalDate date){
		List<Sceance> lst = new ArrayList<Sceance>();
		for (Sceance sc : selectAll()) {
			if (sc.getHoraireSceance().toLocalDate().equals(date)) {
				lst.add(sc);
			}
		}
		return lst;
	}
	
	public static int getRemainingSeatsBySceance(Sceance sc) {
		return sc.getSalleAssociee().getCapacité() - sc.getOccupation();
	}

	public static Duration getTimePassedSceance(Sceance sc) {
		if (LocalDateTime.now().isBefore(sc.getHoraireSceance())) {
			// Sceance has not begun
			return Duration.ofSeconds(0);
		} else {
			Duration sceanceDuration = sc.getDureeReclams().plus(sc.getFilmAssocie().getDuree().getSeconds(),
					ChronoUnit.SECONDS);
			if ((LocalDate.now().isAfter(sc.getHoraireSceance().toLocalDate())) || (LocalTime.now().isAfter(sc.getHoraireSceance().toLocalTime()
					.plus(sceanceDuration.getSeconds(), ChronoUnit.SECONDS)))) {
				// Sceance is already finished
				return sceanceDuration;
			} else {
				// Sceance is on going
				return Duration.of(LocalTime.now().minus(sc.getHoraireSceance().toLocalTime().toSecondOfDay(), ChronoUnit.SECONDS).toSecondOfDay(),ChronoUnit.SECONDS);
			}
		}
	}

	public static Duration getRemainingTimeBySceance(Sceance sc) {
		return sc.getDureeReclams().plus(sc.getFilmAssocie().getDuree().getSeconds(),
				ChronoUnit.SECONDS).minus(getTimePassedSceance(sc));
	}
	
	public static Sceance selectById(int id) {
		return SceanceDAOJDBCImpl.selectById(id);
	}

	public static Sceance insert(Sceance sceanceToInsert) {
		return SceanceDAOJDBCImpl.insert(sceanceToInsert);
	}

	public static Sceance delete(Sceance selectById) {
		return SceanceDAOJDBCImpl.delete(selectById);
	}

	public static Sceance update(Sceance sceanceToUpdate) {
		return SceanceDAOJDBCImpl.update(sceanceToUpdate);
	}

}
