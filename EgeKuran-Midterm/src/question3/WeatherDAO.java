package question3;

import java.util.List;

public interface WeatherDAO {

	public WeatherInfo findByCity(String city);
	public List<WeatherInfo> findByTemperatureAndSituation(int temperature,boolean greaterThan, String situation);

	
}
