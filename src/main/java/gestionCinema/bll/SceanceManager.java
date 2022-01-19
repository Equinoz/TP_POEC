package gestionCinema.bll;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import gestionCinema.bo.Sceance;
import gestionCinema.dao.SceanceDAOJDBCImpl;

@Service
@Primary
public class SceanceManager extends CrudManager<Sceance, SceanceDAOJDBCImpl> {

	@Autowired
	SceanceDAOJDBCImpl dao;

	public List<Sceance> getSceanceWithRemainigSeats() {
		List<Sceance> lst = new ArrayList<Sceance>();
		for (Sceance sc : selectAll()) {
			if (sc.getOccupation() < sc.getSalleAssociee().getCapacité()) {
				lst.add(sc);
			}
		}
		return lst;
	}

	public List<Sceance> getSceanceByFilm(Integer id) {
		List<Sceance> lst = new ArrayList<Sceance>();
		for (Sceance sc : selectAll()) {
			if (sc.getFilmAssocie().getFilm_id().equals(id)) {
				lst.add(sc);
			}
		}
		return lst;
	}

	public List<Sceance> getSceanceByDate(LocalDate date) {
		List<Sceance> lst = new ArrayList<Sceance>();
		for (Sceance sc : selectAll()) {
			if (sc.getHoraireSceance().toLocalDate().equals(date)) {
				lst.add(sc);
			}
		}
		return lst;
	}

	public int getRemainingSeatsBySceance(Sceance sc) {
		return sc.getSalleAssociee().getCapacité() - sc.getOccupation();
	}

	public Duration getTimePassedSceance(Sceance sc) {
		if (LocalDateTime.now().isBefore(sc.getHoraireSceance())) {
			// Sceance has not begun
			return Duration.ofSeconds(0);
		} else {
			Duration sceanceDuration = sc.getDureeReclams().plus(sc.getFilmAssocie().getDuree().getSeconds(),
					ChronoUnit.SECONDS);
			if ((LocalDate.now().isAfter(sc.getHoraireSceance().toLocalDate())) || (LocalTime.now().isAfter(
					sc.getHoraireSceance().toLocalTime().plus(sceanceDuration.getSeconds(), ChronoUnit.SECONDS)))) {
				// Sceance is already finished
				return sceanceDuration;
			} else {
				// Sceance is on going
				return Duration.of(
						LocalTime.now().minus(sc.getHoraireSceance().toLocalTime().toSecondOfDay(), ChronoUnit.SECONDS)
								.toSecondOfDay(),
						ChronoUnit.SECONDS);
			}
		}
	}

	public Duration getRemainingTimeBySceance(Sceance sc) {
		return sc.getDureeReclams().plus(sc.getFilmAssocie().getDuree().getSeconds(), ChronoUnit.SECONDS)
				.minus(getTimePassedSceance(sc));
	}

}
