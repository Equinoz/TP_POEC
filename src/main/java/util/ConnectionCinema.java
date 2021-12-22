package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionCinema {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
<<<<<<< HEAD
//		ResourceBundle rd = ResourceBundle.getBundle("system.properties");
//		// load the driver
//		Class.forName(rd.getString("driver"));
//		// get the connection
//		return DriverManager.getConnection(rd.getString("url"), rd.getString("userName"), rd.getString("password"));
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost/cinema?user=root&password=root");
=======


		Properties prop = new Properties();
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream in = classLoader.getResourceAsStream("database.properties");
			prop.load(in);
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// load the driver
		Class.forName(prop.getProperty("driver"));
		// get the connection
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("userName"), prop.getProperty("password"));
>>>>>>> fca8609c08d7e6d268de6f3debfcdde634fc5173
	}
}
