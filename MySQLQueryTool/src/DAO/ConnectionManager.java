package DAO;

import java.sql.Connection;
import java.sql.DriverManager;



import javax.swing.JOptionPane;

public class ConnectionManager {
	
	public static Connection getConnection(String server,String username,String pass) throws Exception {
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://"+server+"/?useSSL=false", username, pass);
		 
		JOptionPane.showMessageDialog(null, "Connected Succesfully");
		return conn;
	
	}
	
}
