package dao;
import bo.Salle;
import util.ConnectionCinema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalleDAOJDBClmpl {
	
    public static List<Salle> selectAll(){
        List<Salle> resultat = new ArrayList<Salle>();
        try{
			Connection conn = ConnectionCinema.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM salle");
            ResultSet rs = ps.executeQuery(); // select

            while (rs.next()){
                Salle salle = new Salle(rs.getInt("salle_id"),rs.getInt("capacité"),rs.getInt("numéro_salle"),
                        rs.getInt("équipement_3D"),rs.getInt("cinemas_id"));
                resultat.add(salle);
            }
            ps.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return resultat;
    }
    public static Salle selectById(int id) {
        Salle resultat = null;
        try {
			Connection conn = ConnectionCinema.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM salle WHERE salle_id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();


            if (rs.next()) {
                resultat = new Salle(rs.getInt("salle_id"),rs.getInt("capacité"),rs.getInt("numéro_salle"),
                        rs.getInt("équipement_3D"),rs.getInt("cinemas_id"));

            }
            ps.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultat;
    }
    public static int insert(Salle salleInsert) {
        int resultat = -1;
        try {
			Connection conn = ConnectionCinema.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO salle(salle_id, capacité, numéro_salle,équipement_3D,cinemas_id) VALUES (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, salleInsert.getSalle_id());
            ps.setInt(2, salleInsert.getCapacité());
            ps.setInt(3, salleInsert.getNumero_salle());
            ps.setInt(4, salleInsert.getEquipement_3D());
            ps.setInt(5, salleInsert.getCinemas_id());

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
    public static void update(Salle salleUpdate) {
        try {
			Connection conn = ConnectionCinema.getConnection();

            PreparedStatement ps = conn.prepareStatement(
					"UPDATE salle SET capacité =?," 
							+ "numéro_salle =?," 
							+ "équipement_3D =?," 
							+ "cinemas_id =?"
							+ " WHERE salle_id=?");
            ps.setInt(1, salleUpdate.getCapacité());
            ps.setInt(2, salleUpdate.getNumero_salle());
            ps.setInt(3, salleUpdate.getEquipement_3D());
            ps.setInt(4, salleUpdate.getCinemas_id());
            ps.setInt(5, salleUpdate.getSalle_id());

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

            PreparedStatement ps = conn.prepareStatement("DELETE FROM salle WHERE salle_id= ?");
            ps.setInt(1, id);
            ps.executeUpdate(); // insert, update, delete

            ps.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
