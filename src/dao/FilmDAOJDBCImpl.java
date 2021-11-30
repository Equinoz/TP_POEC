package dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bo.Film;

public class FilmDAOJDBCImpl {
	public List<Film> selectAll() {
		List<Film> results = new ArrayList<Film>();
		Connection conn;

		try {
			conn = DriverManager.getConnection("connectionUrl");

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM film");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Film currentFilm = new Film(rs.getInt("film_id"),
										rs.getString("nom"),
										rs.getInt("durée"),
										rs.getString("Producteur"),
										rs.getString("Réalisateur"),
										rs.getString("PEGI"),
										rs.getString("date_diffusion"),
										rs.getString("genre"));

				results.add(currentFilm);
			}

			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return results;
	}

	public Film selectById(int id) {
		Film result = null;
		Connection conn;

		try {
			conn = DriverManager.getConnection("connectionUrl");

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM film WHERE id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				result = new Film(rs.getInt("film_id"),
										rs.getString("nom"),
										rs.getInt("durée"),
										rs.getString("Producteur"),
										rs.getString("Réalisateur"),
										rs.getString("PEGI"),
										rs.getString("date_diffusion"),
										rs.getString("genre"));
			}

			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public int insert(Film newFilm) {
		int result = -1;
		Connection conn;

		try {
			conn = DriverManager.getConnection("connectionUrl");

			PreparedStatement ps = conn.prepareStatement("INSERT INTO film (nom, durée, Producteur, Réalisateur, PEGI, date_diffusion, genre) VALUES (?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, newFilm.getNom());
			ps.setInt(2, newFilm.getDuree());
			ps.setString(3, newFilm.getProducteur());
			ps.setString(4, newFilm.getRealisateur());
			ps.setString(5, newFilm.getPegi());
			ps.setString(6, newFilm.getDateDiffusion());
			ps.setString(7, newFilm.getGenre());

			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();

			if (rs.next()) {
				result = rs.getInt(1);
			}

			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public int update(Film updatedFilm) {
		int result = -1;
		Connection conn;

		try {
			conn = DriverManager.getConnection("connectionUrl");

			PreparedStatement ps = conn.prepareStatement("UPDATE film SET nom=?, durée=?, Producteur=?, Réalisateur=?, PEGI=?, date_diffusion=?, genre=? WHERE film_id=?");
			ps.setString(1, updatedFilm.getNom());
			ps.setInt(2, updatedFilm.getDuree());
			ps.setString(3, updatedFilm.getProducteur());
			ps.setString(4, updatedFilm.getRealisateur());
			ps.setString(5, updatedFilm.getPegi());
			ps.setString(6, updatedFilm.getDateDiffusion());
			ps.setString(7, updatedFilm.getGenre());
			ps.setInt(8, updatedFilm.getFilmId());

			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();

			if (rs.next()) {
				result = rs.getInt(1);
			}

			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public void deleteById(int id) {
		Connection conn;

		try {
			conn = DriverManager.getConnection("connectionUrl");

			PreparedStatement ps = conn.prepareStatement("DELETE FROM film WHERE id=?");
			ps.setInt(1, id);
			ps.executeUpdate();

			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}