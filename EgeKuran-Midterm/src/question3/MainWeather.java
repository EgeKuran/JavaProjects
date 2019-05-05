package question3;



public class MainWeather {
	public static void main(String[] args) {
		
		WeatherServiceImpl srv = new WeatherServiceImpl();
	
		
		System.out.println("ISTANBUL\n");
		System.out.println(srv.getCityInfo("ISTANBUL").toString());
		System.out.println(srv.getSummerSpots().toString());
		System.out.println(	
				srv.getWinterSpots().toString()
				);
		
		
		
		
		
		
	}

}
