package example1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class MainClass {

	public static void main(String[] args) {
		Connection conn = null;
		//Open connection
		//Connection String
		try {
		 conn =
				 DriverManager
				 .getConnection("jdbc:mysql://localhost/addressbook?useSSL=false",
						 "root", "1234");
		
		 
		 
		 Statement stmt = conn.createStatement();
		 
		 ResultSet rs = stmt.executeQuery("select * from person");
		 
		 while(rs.next()) {
			 String name = rs.getString("name");
			 String lastname = rs.getString("lastname");
			 System.out.println(name + " " + lastname);
		 }
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
	}
	
	
	
}
