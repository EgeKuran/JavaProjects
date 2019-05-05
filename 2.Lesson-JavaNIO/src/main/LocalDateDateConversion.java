package main;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class LocalDateDateConversion {
	
	public static void main(String[] args) {
		
		Date in = new Date();
		LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(),ZoneId.systemDefault());
		
		//From localDate to Date
		
		
	}

}
