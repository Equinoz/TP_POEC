package bll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import bo.Sceance;
import dao.SceanceDAOJDBCImpl;
import util.ConnectionCinema;

public class SceanceManager {
	public static List<Sceance> allSceance() {
		return SceanceDAOJDBCImpl.selectAll();
	}

	public static String allSFJSON() throws JsonProcessingException {
		String result ="{\"Search\":[";
		List<Sceance> lst = allSceance();
		for (int i = 0; i < lst.size(); i++) {
			ObjectMapper mapper = new ObjectMapper();
			mapper.setTimeZone(TimeZone.getDefault());
			mapper.setSerializationInclusion(Include.NON_NULL);			
			result += mapper.writeValueAsString(lst.get(i));
			if (i < lst.size() - 1) {
				result += ",";
			}else {
				result+="]}";
			}
		}
		return result;
	}
	
	public static List<Sceance> getSceanceWithRemainigSeats() {
		List<Sceance> lst = new ArrayList<Sceance>();
		for(Sceance sc : allSceance()) {
			if(sc.getOccupation()<sc.getSalleAssociee().getCapacité()) {
				lst.add(sc);
			}
		}
		return lst;
	}

	public static int getRemainingSeatsBySceance(Sceance sc) {	
		return sc.getSalleAssociee().getCapacité()-sc.getOccupation();
	}

	public static LocalTime getTimePassedSceance(Sceance sc) {
		LocalDateTime dateTime = null;
		LocalTime time = null;
		try {
			Connection conn = ConnectionCinema.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT f.durée,sc.horaire_scéance FROM sceance as sc "
					+ "JOIN film f ON sc.film_id = f.film_id " + " WHERE sc.scéance_id = ?");
			ps.setInt(1, sc.getSceanceId());
			ResultSet rs = ps.executeQuery(); // select
			if (rs.next()) {
				dateTime = LocalDateTime.of(
						LocalDateTime.now().minusYears(rs.getTimestamp("sc.horaire_scéance").getYear()).getYear(),
						LocalDateTime.now().minusMonths(rs.getTimestamp("sc.horaire_scéance").getMonth()).getMonth(),
						LocalDateTime.now().minusDays(rs.getTimestamp("sc.horaire_scéance").getDay()).getDayOfMonth(),
						LocalDateTime.now().minusHours(rs.getTimestamp("sc.horaire_scéance").getHours()).getHour(),
						LocalDateTime.now().minusMinutes(rs.getTimestamp("sc.horaire_scéance").getMinutes())
								.getMinute(),
						LocalDateTime.now().minusSeconds(rs.getTimestamp("sc.horaire_scéance").getSeconds())
								.getSecond());
				if (rs.getTime("f.durée").toLocalTime().compareTo(dateTime.toLocalTime()) < 0) {
					time = rs.getTime("f.durée").toLocalTime();
				} else {
					time = dateTime.toLocalTime();
				}
			}
			ps.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return time;
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
