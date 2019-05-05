package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	
	
	public static Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();
		try {
			prop.load(new FileReader(new File("db.properties")));
			String server = prop.getProperty("SERVER");
			String db = prop.getProperty("DATABASE");
			String username = prop.getProperty("USER");
			String pass = prop.getProperty("PASSWORD");
			
		 conn =
		     DriverManager.getConnection("jdbc:mysql://localhost/inventory?useSSL=false", "root", "123456");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return conn;
		
	}
	
	

}
