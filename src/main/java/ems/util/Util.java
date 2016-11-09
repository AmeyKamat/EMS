package ems.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	private static String dateFormat = "dd-MM-yyyy";
	
	public static Date getDateFromString(String dateString) throws ParseException{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		return simpleDateFormat.parse(dateString);
	}
	
	public static String getStringFromDate(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		return simpleDateFormat.format(date);
	}
	
	public static Date getDateFromSQLDate(java.sql.Date date){
		return new Date(date.getTime());
	}
	
	public static java.sql.Date getSQLDateFromDate(Date date){
		return new java.sql.Date(date.getTime());
	}
}

