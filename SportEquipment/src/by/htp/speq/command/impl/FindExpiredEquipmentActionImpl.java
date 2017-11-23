package by.htp.speq.command.impl;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import by.htp.speq.command.StationAction;
import by.htp.speq.entity.RentUnit;
import by.htp.speq.logic.FileStationLogic;
import by.htp.speq.logic.FileStationLogicImpl;
import by.htp.speq.station.Catalog;
import by.htp.speq.utility.PrintObject;
import by.htp.speq.utility.UserInputReader;

public class FindExpiredEquipmentActionImpl implements StationAction {

	FileStationLogic logic = new FileStationLogicImpl();
	Catalog rentedCatalog = logic.readRentedCatalog();
	Date checkDate = UserInputReader.promptAndReadDate();

	@Override
	public void performAction() throws FileNotFoundException {

		List<RentUnit> expired = findExpired(checkDate);

		for (RentUnit unit : expired) {
			PrintObject.print(unit);
		}

	}

	private List<RentUnit> findExpired(Date checkDate) {
		List<RentUnit> expired = new ArrayList<>();
		for (RentUnit unit : rentedCatalog.getUnits()) {
			double delta = (double) ((checkDate.getTime() - unit.getRentStartDate().getTime()) / 3600000);
			int deltaInt = (int) Math.ceil(delta);
			if (deltaInt >= 24) {
				expired.add(unit);
			}
		}
		return expired;
	}
}
