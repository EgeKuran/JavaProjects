package question3;

import org.omg.Messaging.SyncScopeHelper;

public class WeatherInfo {

	private String city;
	private String situation;
	private int temperature;
	private int humidity;
	private String wind;
	
	public WeatherInfo() {
		// TODO Auto-generated constructor stub
	}

	public WeatherInfo(String city, String situation, int temperature, int humidity, String wind) {

		this.city = city;
		this.situation = situation;
		this.temperature = temperature;
		this.humidity = humidity;
		this.wind = wind;
	}



	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSituation() {
		return situation;
	}
	public void setSituation(String situation) {
		this.situation = situation;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public String getWind() {
		return wind;
	}
	public void setWind(String wind) {
		this.wind = wind;
	}

@Override
public String toString() {
	// TODO Auto-generated method stub
	return 	this.getCity() + "\n" +this.situation +", temperature=" + this.temperature +", humidity= " + this.humidity + ", wind= " + this.wind ;
}

	
}
