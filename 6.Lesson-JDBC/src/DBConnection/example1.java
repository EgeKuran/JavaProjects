package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 
public class example1 {
	public static void main(String[] args) {
		
		//open connection
		
		//connection string
		
		
		try (Connection conn = 	DriverManager.getConnection("jdbc:mysql://localhost/addressbook?useSSL=false", "root", "123456");){
		
			
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM PERSON");
		while(rs.next()) 
		{
			String name =rs.getString("name");
			String lname =rs.getString("lastname");
			System.out.println(name + " " + lname);
		}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
