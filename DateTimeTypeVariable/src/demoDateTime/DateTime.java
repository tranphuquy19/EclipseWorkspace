package demoDateTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateTime {

	public static void main(String[] args) {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("[dd/MM - HH:mm]");
		String now = df.format(date);
		System.out.println(now);
	}

}
