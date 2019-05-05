package WeatherPckg;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WeatherInfoImpl implements WeatherDAO{

	@Override
	public WeatherInfo findByCity(String city) {
		Connection conn = null;
		WeatherInfo winfo= new WeatherInfo();
		
			try {
				conn =
				     DriverManager.getConnection("jdbc:mysql://localhost/weather?useSSL=false", "root", "123456");

				String query = "Select * from weather.data where city=?";
				
				PreparedStatement pst = conn.prepareStatement(query);
				
				pst.setString(1, city);
				ResultSet rs = pst.executeQuery();
				while(rs.next()) 
				{
					winfo.setCity(rs.getString("city"));
					winfo.setHumidity(rs.getInt("humidity"));
					winfo.setSituation(rs.getString("situation"));
					winfo.setTemperature(rs.getInt("temperature"));
					winfo.setWind(rs.getString("wind"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return winfo;
	
	}

	@Override
	public List<WeatherInfo> findByTemperatureAndSituation(int temperature, boolean greaterThan, String situation) {
		Connection conn = null;
		List<WeatherInfo> winfoList = new ArrayList<>();
	
		 try {
			conn =
			     DriverManager.getConnection("jdbc:mysql://localhost/weather?useSSL=false", "root", "123456");
			
			String query = "Select * from weather.data where temperature<=? and situation=?";
			if(greaterThan) {	query = "Select * from weather.data where temperature>=? and situation=?";}
			
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setInt(1,temperature);
			pst.setString(2, situation);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				WeatherInfo winfo = new  WeatherInfo();
				winfo.setCity(rs.getString("city"));
				winfo.setHumidity(rs.getInt("humidity"));
				winfo.setSituation(rs.getString("situation"));
				winfo.setTemperature(rs.getInt("temperature"));
				winfo.setWind(rs.getString("wind"));
				winfoList.add(winfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return winfoList;
	}

}
