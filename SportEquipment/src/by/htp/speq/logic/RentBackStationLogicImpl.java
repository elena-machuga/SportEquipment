package by.htp.speq.logic;

import by.htp.speq.entity.RentUnit;
import by.htp.speq.station.Catalog;
import by.htp.speq.utility.PrintObject;
import by.htp.speq.utility.UserInputReader;

public class RentBackStationLogicImpl {

	private FileStationLogic logic = new FileStationLogicImpl();
	Catalog catalog = logic.readCatalog();
	Catalog rentedCatalog = logic.readRentedCatalog();
	IncomeReportStationLogicImpl incomeReport = new IncomeReportStationLogicImpl();

	public RentUnit searchRentUnit() {
		PrintObject.print("Enter equipment ID");
		String equipmentID = UserInputReader.readUserInputString();
		RentUnit unit = null;
		while (!equipmentID.equals("")) {
			unit = findRentUnit(equipmentID, rentedCatalog);
			if (unit == null) {
				PrintObject.print("Equipment not found");
				equipmentID = UserInputReader.readUserInputString();
			} else {
				break;
			}
		}
		return unit;
	}

	public void rentBackRentUnit(RentUnit unit) {
		incomeReport.countIncome(unit);
		catalog.addRentUnit(unit);
		logic.writeCatalog(catalog);
		rentedCatalog.getUnits().remove(unit);
		logic.writeRentedCatalog(rentedCatalog);

	}

	private RentUnit findRentUnit(String equipmentID, Catalog catalog) {
		RentUnit foundUnit = null;
		for (RentUnit u : catalog.getUnits()) {
			if (u.getRentUnitID().equalsIgnoreCase(equipmentID)) {
				foundUnit = u;
				break;
			}
		}
		return foundUnit;
	}

}
