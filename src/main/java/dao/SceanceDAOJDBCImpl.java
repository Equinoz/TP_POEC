package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import bo.*;
import util.ConnectionCinema;

public class SceanceDAOJDBCImpl {

	public static List<Sceance> selectAll() {
		List<Sceance> ret = new ArrayList<Sceance>();
		try {
			Connection conn = ConnectionCinema.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM sceance");
			ResultSet rs = ps.executeQuery(); // select

			// Un curseur qui se déplace ligne par ligne pour accéder aux informations
			while (rs.next()) {
				Sceance currentSceance = new Sceance(rs.getInt("scéance_id"), rs.getInt("film_id"),
						rs.getInt("salle_id"), rs.getTimestamp("horaire_scéance"), rs.getTime("durée_réclams"),
						rs.getInt("prix"), rs.getInt("occupation"), rs.getBoolean("VOSTFR"));

				ret.add(currentSceance);

			}
			ps.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public static List<Sceance> getSceanceWithRemainigSeats() {
		List<Sceance> lst = new ArrayList<Sceance>();
		try {
			Connection conn = ConnectionCinema.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT sc.* FROM sceance as sc "
					+ "JOIN salle s ON s.salle_id = sc.salle_id " + " WHERE sc.occupation < s.capacité");

			ResultSet rs = ps.executeQuery(); // select
			while (rs.next()) {

				Sceance currentSceance = new Sceance(rs.getInt("scéance_id"), rs.getInt("film_id"),
						rs.getInt("salle_id"), rs.getTimestamp("horaire_scéance"), rs.getTime("durée_réclams"),
						rs.getInt("prix"), rs.getInt("occupation"), rs.getBoolean("VOSTFR"));

				lst.add(currentSceance);
			}
			ps.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lst;
	}

	public static int getRemainingSeatsBySceance(Sceance sc) {
		int ret = 0;
		try {
			Connection conn = ConnectionCinema.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT sc.occupation,s.capacité FROM sceance as sc "
					+ "JOIN salle s ON s.salle_id = sc.salle_id " + " WHERE sc.scéance_id = ?");
			ps.setInt(1, sc.getSceanceId());
			ResultSet rs = ps.executeQuery(); // select
			if (rs.next()) {
				ret = rs.getInt("s.capacité") - rs.getInt("sc.occupation");
			}
			ps.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
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

	public static StatusSceance getStatusSceance(Sceance sc) {

		return StatusSceance.FINI;
	}

	public static List<Sceance> selectByDate(LocalDateTime dateTime) {
		List<Sceance> ret = new ArrayList<Sceance>();
		try {
			Connection conn = ConnectionCinema.getConnection();

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM sceance WHERE horaire_scéance >= ?");
			ps.setTimestamp(1, Timestamp.valueOf(dateTime));
			ResultSet rs = ps.executeQuery(); // select

			// Un curseur qui se déplace ligne par ligne pour accéder aux informations
			while (rs.next()) {
				Sceance currentSceance = new Sceance(rs.getInt("scéance_id"), rs.getInt("film_id"),
						rs.getInt("salle_id"), rs.getTimestamp("horaire_scéance"), rs.getTime("durée_réclams"),
						rs.getInt("prix"), rs.getInt("occupation"), rs.getBoolean("VOSTFR"));

				ret.add(currentSceance);

			}
			ps.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public static List<Sceance> getSceanceUpgraded(List<Sceance> lst) {
		List<Sceance> ret = new ArrayList<Sceance>();
		String strWhere = "";

		try {
			Connection conn = ConnectionCinema.getConnection();

			for (int i = 0; i < lst.size(); i++) {
				strWhere += "?";
				if (i < (lst.size() - 1)) {
					strWhere += " OR sc.scéance_id = ";
				}
			}
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM sceance as sc " + "JOIN salle s ON s.salle_id = sc.salle_id "
							+ "JOIN film f ON f.film_id = sc.film_id" + " WHERE sc.scéance_id = " + strWhere);
			for (int i = 0; i < lst.size(); i++) {
				ps.setInt(i + 1, lst.get(i).getSceanceId());
			}
			ResultSet rs = ps.executeQuery(); // select

			// Un curseur qui se déplace ligne par ligne pour accéder aux informations
			while (rs.next()) {
				Film currentFilm = new Film(rs.getInt("f.film_id"), rs.getString("f.nom"), rs.getTime("f.durée"),
						rs.getString("f.Producteur"), rs.getString("f.Réalisateur"), rs.getString("f.PEGI"),
						rs.getTimestamp("f.date_diffusion"), rs.getString("f.genre"));
				Salle currentSalle = new Salle(rs.getInt("s.salle_id"), rs.getInt("s.capacité"),
						rs.getInt("s.numéro_salle"), rs.getInt("s.équipement_3D"), rs.getInt("s.cinemas_id"));

				Sceance currentSceance = new Sceance(rs.getInt("scéance_id"), currentFilm, currentSalle,
						rs.getTimestamp("horaire_scéance"), rs.getTime("durée_réclams"), rs.getInt("prix"),
						rs.getInt("occupation"), rs.getBoolean("VOSTFR"));

				ret.add(currentSceance);

			}
			ps.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public static List<Sceance> selectAllWithSF() {
		List<Sceance> ret = new ArrayList<Sceance>();
		try {
			Connection conn = ConnectionCinema.getConnection();

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM sceance as sc "
					+ "JOIN salle s ON s.salle_id = sc.salle_id " + "JOIN film f ON f.film_id = sc.film_id");
			ResultSet rs = ps.executeQuery(); // select

			// Un curseur qui se déplace ligne par ligne pour accéder aux informations
			while (rs.next()) {
				Film currentFilm = new Film(rs.getInt("f.film_id"), rs.getString("f.nom"), rs.getTime("f.durée"),
						rs.getString("f.Producteur"), rs.getString("f.Réalisateur"), rs.getString("f.PEGI"),
						rs.getTimestamp("f.date_diffusion"), rs.getString("f.genre"));
				Salle currentSalle = new Salle(rs.getInt("s.salle_id"), rs.getInt("s.capacité"),
						rs.getInt("s.numéro_salle"), rs.getInt("s.équipement_3D"), rs.getInt("s.cinemas_id"));

				Sceance currentSceance = new Sceance(rs.getInt("scéance_id"), currentFilm, currentSalle,
						rs.getTimestamp("horaire_scéance"), rs.getTime("durée_réclams"), rs.getInt("prix"),
						rs.getInt("occupation"), rs.getBoolean("VOSTFR"));

				ret.add(currentSceance);

			}
			ps.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public static Sceance selectById(int id) {
		Sceance ret = null;
		try {
			Connection conn = ConnectionCinema.getConnection();

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM sceance WHERE scéance_id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery(); // select

			// Un curseur qui se déplace ligne par ligne pour accéder aux informations
			if (rs.next()) {
				ret = new Sceance(rs.getInt("scéance_id"), rs.getInt("film_id"), rs.getInt("salle_id"),
						rs.getTimestamp("horaire_scéance"), rs.getTime("durée_réclams"), rs.getInt("prix"),
						rs.getInt("occupation"), rs.getBoolean("VOSTFR"));

			}
			ps.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public static int insert(Sceance sceanceToInsert) {
		int resultat = -1;
		try {
			Connection conn = ConnectionCinema.getConnection();

			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO sceance(film_id," + "salle_id," + "horaire_scéance," + "durée_réclams," + "prix,"
							+ "occupation," + "VOSTFR) " + "VALUES (?,?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, sceanceToInsert.getFilmId());
			ps.setInt(2, sceanceToInsert.getSalleId());
			ps.setTimestamp(3, sceanceToInsert.getHoraireSceance());
			ps.setTime(4, sceanceToInsert.getDureeReclams());
			ps.setInt(5, sceanceToInsert.getPrix());
			ps.setInt(6, sceanceToInsert.getOccupation());
			ps.setBoolean(7, sceanceToInsert.isVostfr());

			ps.executeUpdate(); // insert, update, delete
			ResultSet rs = ps.getGeneratedKeys();

			if (rs.next()) {
				resultat = rs.getInt(1);
			}

			ps.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	public static void update(Sceance sceanceToUpdate) {
		try {
			Connection conn = ConnectionCinema.getConnection();

			PreparedStatement ps = conn.prepareStatement(
					"UPDATE sceance SET film_id =?," + "salle_id =?," + "horaire_scéance =?," + "durée_réclams =?,"
							+ "prix =?," + "occupation =?," + "VOSTFR =? " + "WHERE scéance_id=?");
			ps.setInt(1, sceanceToUpdate.getFilmId());
			ps.setInt(2, sceanceToUpdate.getSalleId());
			ps.setTimestamp(3, sceanceToUpdate.getHoraireSceance());
			ps.setTime(4, sceanceToUpdate.getDureeReclams());
			ps.setInt(5, sceanceToUpdate.getPrix());
			ps.setInt(6, sceanceToUpdate.getOccupation());
			ps.setBoolean(7, sceanceToUpdate.isVostfr());
			ps.setInt(8, sceanceToUpdate.getSceanceId());

			ps.executeUpdate(); // insert, update, delete

			ps.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void deleteById(int id) {
		try {
			Connection conn = ConnectionCinema.getConnection();
			PreparedStatement ps = conn.prepareStatement("DELETE FROM sceance WHERE scéance_id=?");
			ps.setInt(1, id);
			ps.executeUpdate(); // delete lines with sceance_id = id
			ps.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
