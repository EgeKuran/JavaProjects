package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainClass {
	public static void main(String[] args) {
		
	try(Connection conn = 	DriverManager.getConnection("jdbc:mysql://localhost/addressbook?useSSL=false", "root", "123456");)
	{
		String query = "insert into category(name) values(?);";
	}catch (SQLException e) {
		// TODO: handle exception
	}
	
	

	}	
}

