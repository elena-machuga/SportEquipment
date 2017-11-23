package by.htp.speq.command;

import by.htp.speq.command.impl.DefaultActionImpl;
import by.htp.speq.command.impl.FindExpiredEquipmentActionImpl;
import by.htp.speq.command.impl.GiveEquipmentForRentActionImpl;
import by.htp.speq.command.impl.TakeEquipmentFromRentActionImpl;
import by.htp.speq.command.impl.ViewCatalogActionImpl;
import by.htp.speq.command.impl.ViewIncomeReportActionImpl;
import by.htp.speq.command.impl.ViewRentedEquipmentActionImpl;

public class ActionHelper {

	public static StationAction defineAction(String input) {

		StationAction action = new DefaultActionImpl();

		switch (input) {
		case "1":
			action = new ViewCatalogActionImpl();
			break;
		case "2":
			action = new ViewRentedEquipmentActionImpl();
			break;

		case "3":
			action = new GiveEquipmentForRentActionImpl();
			break;

		case "4":
			action = new TakeEquipmentFromRentActionImpl();
			break;

		case "5":
			action = new FindExpiredEquipmentActionImpl();
			break;

		case "6":
			action = new ViewIncomeReportActionImpl();
			break;

		default:
		}

		return action;
	}

}
