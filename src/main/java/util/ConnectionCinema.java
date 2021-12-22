package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionCinema {
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
//		ResourceBundle rd = ResourceBundle.getBundle("system.properties");
//		// load the driver
//		Class.forName(rd.getString("driver"));
//		// get the connection
//		return DriverManager.getConnection(rd.getString("url"), rd.getString("userName"), rd.getString("password"));
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost/cinema?user=root&password=root");
	}
}
