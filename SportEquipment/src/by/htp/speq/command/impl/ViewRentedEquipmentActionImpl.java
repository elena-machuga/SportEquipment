package by.htp.speq.command.impl;

import java.io.FileNotFoundException;
import java.util.List;
import by.htp.speq.command.StationAction;
import by.htp.speq.entity.RentUnit;
import by.htp.speq.logic.FileStationLogic;
import by.htp.speq.logic.FileStationLogicImpl;
import by.htp.speq.station.Catalog;
import by.htp.speq.utility.PrintObject;

public class ViewRentedEquipmentActionImpl implements StationAction {
	private FileStationLogic logic;
	{
		// logic = new ConsoleStationLogicImpl();
		logic = new FileStationLogicImpl();
		// logic = new DataBaseStationLogicImpl();
	}

	@Override
	public void performAction() throws FileNotFoundException {

		Catalog rentedCatalog = logic.readRentedCatalog();
		List<RentUnit> units = rentedCatalog.getUnits();

		for (RentUnit unit : units) {
			if (unit != null) {
				PrintObject.print(unit);
			}
		}

	}

}
