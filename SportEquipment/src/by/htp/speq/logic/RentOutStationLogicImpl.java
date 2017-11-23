package by.htp.speq.logic;

import java.util.Date;
import by.htp.speq.entity.Category;
import by.htp.speq.entity.RentUnit;
import by.htp.speq.station.Catalog;
import by.htp.speq.utility.PrintObject;
import by.htp.speq.utility.UserInputReader;

public class RentOutStationLogicImpl {

	private FileStationLogic logic = new FileStationLogicImpl();
	Catalog catalog = logic.readCatalog();
	Catalog rentedCatalog = logic.readRentedCatalog();

	public RentUnit selectRentUnit() {
		PrintObject.print("Enter equipment ID");
		String equipmentID = UserInputReader.readUserInputString();
		RentUnit unit = null;
		while (!equipmentID.equals("")) {
			unit = findRentUnit(equipmentID, catalog);
			if (unit == null) {
				PrintObject.print("Equipment not found");
				equipmentID = UserInputReader.readUserInputString();
			} else {
				break;
			}
		}
		return unit;
	}

	public void rentOutRentUnit(RentUnit unit) {
		PrintObject.print("Enter RenterID");
		String renterID = UserInputReader.readUserInputString();
		if (unit.getCategory().equals(Category.FACILITY)) {
			boolean enoughCapacity = checkUserCapasity(renterID, rentedCatalog);
			if (enoughCapacity) {
				performRentAction(renterID, unit, catalog, rentedCatalog);
			} else {
				PrintObject.print("Renter already rented 3 facilities");
			}
		} else {
			performRentAction(renterID, unit, catalog, rentedCatalog);
		}
	}

	private void performRentAction(String renterID, RentUnit unit, Catalog catalog, Catalog rentedCatalog) {
		Date rentStartDate = UserInputReader.promptAndReadDate();
		unit.setRenterID(renterID);
		unit.setRentStartDate(rentStartDate);
		rentedCatalog.addRentUnit(unit);
		logic.writeRentedCatalog(rentedCatalog);
		catalog.getUnits().remove(unit);
		logic.writeCatalog(catalog);
	}

	private boolean checkUserCapasity(String renterID, Catalog rentedCatalog) {

		int count = 0;
		for (RentUnit unit : rentedCatalog.getUnits()) {
			if (unit.getCategory().equals(Category.FACILITY) && unit.getRenterID().equalsIgnoreCase(renterID)) {
				count++;
			}
		}
		if (count > 2) {
			return false;
		} else {
			return true;
		}
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
