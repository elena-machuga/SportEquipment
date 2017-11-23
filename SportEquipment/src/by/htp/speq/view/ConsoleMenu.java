package by.htp.speq.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import by.htp.speq.utility.PrintObject;

public class ConsoleMenu {

	public void printMenu() {
		PrintObject.print("1.View catalog");
		PrintObject.print("2.View equipment in rent");
		PrintObject.print("3.Rent equipment");
		PrintObject.print("4.Return equipment");
		PrintObject.print("5.Find expired equipment");
		PrintObject.print("6.View profit report and close station");
	}

	public String readUserInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		return input;
	}

}
