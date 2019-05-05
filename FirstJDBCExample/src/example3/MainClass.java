package example3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainClass {

	public static void main(String[] args) {
		
		try(
				Connection conn =	DriverManager
				.getConnection("jdbc:mysql://localhost/addressbook","root","1234");
	
				
				
				)

		{
				String query = "insert into category(name) values(?)";
				PreparedStatement psmt =  conn.prepareStatement(query);
				
				psmt.setString(1, "Test3");
				System.out.println(psmt.executeUpdate() +"rows have changed");
				
				
				
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
				
		
		
		
	}
	
	
	
}
