package WeatherPckg;


import java.util.Arrays;

public class MainWeather {
	public static void main(String[] args) {
		
		WeatherServiceImpl srv = new WeatherServiceImpl();

		System.out.println(srv.getCityInfo("ISTANBUL").toString());
		System.out.println("summer spots \n");
		srv.getSummerSpots().forEach(s->System.out.println(s.toString()));
		System.out.println("winter spots\n");
		srv.getWinterSpots().forEach(t->System.out.println(t.toString()));

//		System.out.println(srv.getCityInfo("ISTANBUL").toString());
//		System.out.println(srv.getSummerSpots().toString());	
//		System.out.println(Arrays.toString(srv.getWinterSpots().toArray()).toString());

	}

}
