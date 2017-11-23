package by.htp.speq.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {

	private static SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");

	public static Date convertStringToDate(String string) {
		Date date = null;
		try {
			date = df.parse(string);
		} catch (ParseException e) {
			System.out.println("Invalid date and time format");
			e.printStackTrace();
		}
		return date;
	}

	public static String convertDateToString(Date date) {
		String result = df.format(date);
		return result;
	}

}
