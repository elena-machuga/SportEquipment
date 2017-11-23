package by.htp.speq.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class UserInputReader {

	public static String readUserInputString() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		try {
			input = br.readLine();
		} catch (IOException e) {
			PrintObject.print("Input format exception");
			e.printStackTrace();
		}
		return input;
	}

	public static Date promptAndReadDate() {
		PrintObject.print("Enter current date and time MM/dd/yyyy HH:mm");
		String currentDate = readUserInputString();
		Date resultDate = DateConverter.convertStringToDate(currentDate);
		return resultDate;
	}
}
