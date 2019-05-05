package DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	
	public static Connection getConnection(){
	
	Properties prop = new Properties();
	
	Connection conn = null;
	try {
		prop.load(new FileReader(new File("db.properties")));
		
		String server = prop.getProperty("SERVER");
		String db = prop.getProperty("DATABASE");
		String username = prop.getProperty("USER");
		String password = prop.getProperty("PASSWORD");
		
		conn = DriverManager.getConnection("jdbc:mysql:// " + server + "/" + db , username, password);
		
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
