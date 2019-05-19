package com.amc.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DaysCalculator {
	
	public long getDays(Date date) {
		   SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
		    String inputString1 = myFormat.format(date);
		    String inputString2 = getTodayDate();

		try {
		    Date date3 = myFormat.parse(inputString1);
		    Date date4 = myFormat.parse(inputString2);
		    long diff = date3.getTime() - date4.getTime();
		    long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		    return days;
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		
		return 0l;
          
  
		
	}
	
	private String getTodayDate() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		return dateFormat.format(date);
 }

}
