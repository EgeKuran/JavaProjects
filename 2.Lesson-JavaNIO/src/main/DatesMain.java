package main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

public class DatesMain {
	
	public static void main(String[] args) {
		
		//Local Date
		
		// LocalDateTime
		
//		Date now = new Date();
		LocalDate lct = LocalDate.of(2017, 01	, 5);
		LocalDateTime lct2 =LocalDateTime.of(2018, 3, 9, 12, 01);
		
//		System.out.println(now);
		System.out.println(lct);
		System.out.println(lct2);
		
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime orgTime = LocalDateTime.of(2018, 2, 7, 12, 01);
		
		long daysToEvent = now.until(orgTime, ChronoUnit.DAYS);
		System.out.println(daysToEvent);
	}

}
