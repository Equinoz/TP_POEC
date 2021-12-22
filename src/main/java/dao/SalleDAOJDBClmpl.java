package dao;
import bo.Salle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalleDAOJDBClmpl {
	private String connexionParam = "jdbc:mysql://localhost/cinema?user=root&password=root";
	
    public List<Salle> selectAll(){
        List<Salle> resultat = new ArrayList<Salle>();
        Connection connection;
        try{
            connection = DriverManager.getConnection(connexionParam);

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM salle");
            ResultSet rs = ps.executeQuery(); // select

            while (rs.next()){
                Salle salle = new Salle(rs.getInt("salle_id"),rs.getInt("capacité"),rs.getInt("numéro_salle"),
                        rs.getInt("équipement_3D"),rs.getInt("cinemas_id"));
                resultat.add(salle);
            }
            ps.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultat;
    }
    public Salle selectById(int id) {
        Salle resultat = null;
        Connection connection;
        try {
            connection = DriverManager.getConnection(connexionParam);

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM salle WHERE salle_id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();


            if (rs.next()) {
                resultat = new Salle(rs.getInt("salle_id"),rs.getInt("capacité"),rs.getInt("numéro_salle"),
                        rs.getInt("équipement_3D"),rs.getInt("cinemas_id"));

            }
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultat;
    }
    public int insert(Salle salleInsert) {
        int resultat = -1;
        Connection connection;
        try {
            connection = DriverManager.getConnection(connexionParam);

            PreparedStatement ps = connection.prepareStatement("INSERT INTO salle(salle_id, capacité, numéro_salle,équipement_3D,cinemas_id) VALUES (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
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
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultat;
    }
    public void update(Salle salleUpdate) {
        Connection connection;
        try {
            connection = DriverManager.getConnection(connexionParam);

            PreparedStatement ps = connection.prepareStatement(
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
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteById(int id) {
        Connection connection;
        try {
            connection = DriverManager.getConnection(connexionParam);

            PreparedStatement ps = connection.prepareStatement("DELETE FROM salle WHERE salle_id= ?");
            ps.setInt(1, id);
            ps.executeUpdate(); // insert, update, delete

            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
