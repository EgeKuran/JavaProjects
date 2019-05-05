package WeatherPckg;


import java.util.List;

public class WeatherServiceImpl implements WeatherService{
	private WeatherDAO wDao = new WeatherInfoImpl();
	@Override
	public WeatherInfo getCityInfo(String city) {
		
		WeatherInfo winfo =wDao.findByCity(city);
		return winfo;
		
	}

	@Override
	public List<WeatherInfo> getSummerSpots() {
		List<WeatherInfo> winfoList =wDao.findByTemperatureAndSituation(30, true, "sunny");
		
		return winfoList;
	}

	@Override
	public List<WeatherInfo> getWinterSpots() {
		List<WeatherInfo> winfoList =wDao.findByTemperatureAndSituation(0, false, "snowy");
		return winfoList;
	}

}
