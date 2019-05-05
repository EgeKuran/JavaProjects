package Q1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Main {

	public static void main(String[] args) {
		
		Thread t = new Thread(()->{
			
			try {
				int result=0;
				boolean isOn= true;
				
				Connection conn =
					     DriverManager.getConnection("jdbc:mysql://localhost/systemdb?useSSL=false", "root", "123456");
				while(true)
				{
				
					String query = "SELECT status FROM systemdb.system;";
					
					PreparedStatement pmt;
					pmt = conn.prepareStatement(query);
					ResultSet data = pmt.executeQuery();
					while(data.next()) 
					{
						result=data.getInt("status");
						if(result==0 && isOn) 
						{
							System.out.println("System off");
							isOn=false;
						}
						else if(result==1 && !(isOn)) 
						{
							System.out.println("System on");
							isOn =true;
							
						}
					}}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		
			
			}
		});
		
		t.start();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
