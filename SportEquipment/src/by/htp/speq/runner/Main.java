package by.htp.speq.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import by.htp.speq.command.ActionHelper;
import by.htp.speq.command.StationAction;
import by.htp.speq.utility.PrintObject;
import by.htp.speq.view.ConsoleMenu;

public class Main {

	public static void main(String[] args) throws IOException {

		ConsoleMenu menu = new ConsoleMenu();

		menuCycle(menu);
	}

	private static void menuCycle(ConsoleMenu menu) {
		while (true) {
			menu.printMenu();

			String input = null;
			try {
				input = menu.readUserInput();
			} catch (IOException e) {
				PrintObject.print("User input exception");
				e.printStackTrace();
			}

			StationAction action = ActionHelper.defineAction(input);
			try {
				action.performAction();
			} catch (FileNotFoundException e) {
				PrintObject.print("File was not found");
				e.printStackTrace();
			}
		}

	}

}
