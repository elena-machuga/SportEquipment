package by.htp.speq.command.impl;

import java.io.FileNotFoundException;
import by.htp.speq.command.StationAction;
import by.htp.speq.entity.RentUnit;
import by.htp.speq.logic.RentOutStationLogicImpl;

public class GiveEquipmentForRentActionImpl implements StationAction {

	@Override
	public void performAction() throws FileNotFoundException {

		RentOutStationLogicImpl rentOut = new RentOutStationLogicImpl();

		RentUnit unit = rentOut.selectRentUnit();

		if (unit != null) {
			rentOut.rentOutRentUnit(unit);
		}

	}

}
