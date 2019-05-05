package Servlets;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import WeatherPckg.WeatherInfo;
import WeatherPckg.WeatherServiceImpl;

/**
 * Servlet implementation class WeatherSituation
 */
@WebServlet("/weathersituation/*")
public class WeatherSituation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeatherSituation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] urlS = request.getRequestURL().toString().split("/");	
		String situation="";
		
			situation=urlS[urlS.length-1];
		
		
		List<WeatherInfo> infos = new ArrayList<>();
		
		if(situation.equals("summer")) 
		{
			infos = new WeatherServiceImpl().getSummerSpots();
		}
		else
		{
			infos = new WeatherServiceImpl().getWinterSpots();
			
		}
	
	Gson gson= new GsonBuilder().create();
	gson.toJson(infos,response.getWriter());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
