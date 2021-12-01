package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.*;

public class SceanceDAOJDBCImpl {

	private String connexionParam = "jdbc:mysql://localhost/cinema?user=root&password=root";

	/**
	 * @param connexionParam the connexionParam to set
	 */
	public void setConnexionParam(String connexionParam) {
		this.connexionParam = connexionParam;
	}

	public List<Sceance> selectAll() {
		List<Sceance> ret = new ArrayList<Sceance>();
		Connection conn;
		try {
			conn = DriverManager.getConnection(connexionParam);

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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public List<Sceance> selectAllWithSF() {
		List<Sceance> ret = new ArrayList<Sceance>();
		Connection conn;
		try {
			conn = DriverManager.getConnection(connexionParam);

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM sceance as sc "
					+ "JOIN salle s ON s.salle_id = sc.salle_id "
					+ "JOIN film f ON f.film_id = sc.film_id");
			ResultSet rs = ps.executeQuery(); // select

			// Un curseur qui se déplace ligne par ligne pour accéder aux informations
			while (rs.next()) {
				Film currentFilm = new Film(rs.getInt("f.film_id"),
						rs.getString("f.nom"),
						rs.getTime("f.durée"),
						rs.getString("f.Producteur"),
						rs.getString("f.Réalisateur"),
						rs.getString("f.PEGI"),
						rs.getTimestamp("f.date_diffusion"),
						rs.getString("f.genre"));
				Salle currentSalle = new Salle(rs.getInt("s.salle_id"),
						rs.getInt("s.capacité"),
						rs.getInt("s.numéro_salle"),
                        rs.getInt("s.équipement_3D"),
                        rs.getInt("s.cinemas_id"));
				
				Sceance currentSceance = new Sceance(rs.getInt("scéance_id"),currentFilm,currentSalle, rs.getTimestamp("horaire_scéance"), rs.getTime("durée_réclams"),
						rs.getInt("prix"), rs.getInt("occupation"), rs.getBoolean("VOSTFR"));

				ret.add(currentSceance);

			}
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	

	public Sceance selectById(int id) {
		Sceance ret = null;
		Connection conn;
		try {
			conn = DriverManager.getConnection(connexionParam);

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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public int insert(Sceance sceanceToInsert) {
		int resultat = -1;
		Connection conn;
		try {
			conn = DriverManager.getConnection(connexionParam);

			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO sceance(film_id," 
								+ "salle_id," 
								+ "horaire_scéance," 
								+ "durée_réclams," 
								+ "prix,"
								+ "occupation," 
								+ "VOSTFR) " 
								+ "VALUES (?,?,?,?,?,?,?)",
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	public void update(Sceance sceanceToUpdate) {
		Connection conn;
		try {
			conn = DriverManager.getConnection(connexionParam);

			PreparedStatement ps = conn.prepareStatement(
					"UPDATE sceance SET film_id =?," 
							+ "salle_id =?," 
							+ "horaire_scéance =?," 
							+ "durée_réclams =?," 
							+ "prix =?,"
							+ "occupation =?," 
							+ "VOSTFR =? "
							+ "WHERE scéance_id=?");
			ps.setInt(1, sceanceToUpdate.getFilmId());			
			ps.setInt(2, sceanceToUpdate.getSalleId());
			ps.setTimestamp(3, sceanceToUpdate.getHoraireSceance());
			ps.setTime(4, sceanceToUpdate.getDureeReclams());
			ps.setInt(5, sceanceToUpdate.getPrix());
			ps.setInt(6, sceanceToUpdate.getOccupation());
			ps.setBoolean(7, sceanceToUpdate.isVostfr());
			ps.setInt(8,sceanceToUpdate.getSceanceId());

			ps.executeUpdate(); // insert, update, delete

			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	

	public void deleteById(int id) {
		Connection conn;
		try {
			conn = DriverManager.getConnection(connexionParam);
			PreparedStatement ps = conn.prepareStatement("DELETE FROM sceance WHERE scéance_id=?");
			ps.setInt(1, id);
			ps.executeUpdate(); // delete lines with sceance_id = id
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
