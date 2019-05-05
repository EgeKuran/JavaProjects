package Servlets;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

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
 * Servlet implementation class WeatherByCityServlet
 */
@WebServlet("/weatherinfo/*")
public class WeatherByCityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public WeatherByCityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			Path path = Paths.get(request.getRequestURL().toString());
//			String city=path.getName(path.getNameCount()-1).toString();
		String[] urlS = request.getRequestURL().toString().split("/");
		String city="";
	
			city=urlS[urlS.length-1];
		
		
		WeatherInfo info =new WeatherServiceImpl().getCityInfo(city);
		Gson gson= new GsonBuilder().create();
		gson.toJson(info,response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
