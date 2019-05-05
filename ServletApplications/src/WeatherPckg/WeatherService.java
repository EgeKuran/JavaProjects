package WeatherPckg;


import java.util.List;

public interface WeatherService {
	
	//return WeatherInfo of a specific city
	public WeatherInfo getCityInfo(String city);
	//return list of info where temperature is >=30 and sunny
	public List<WeatherInfo> getSummerSpots();
	//return list of info where temperature is <=0 and snowy
	public List<WeatherInfo> getWinterSpots();
	
	
}
