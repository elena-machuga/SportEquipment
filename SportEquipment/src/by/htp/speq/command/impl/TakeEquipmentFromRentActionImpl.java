package by.htp.speq.command.impl;

import java.io.FileNotFoundException;

import by.htp.speq.command.StationAction;
import by.htp.speq.entity.RentUnit;
import by.htp.speq.logic.RentBackStationLogicImpl;

public class TakeEquipmentFromRentActionImpl implements StationAction {

	@Override
	public void performAction() throws FileNotFoundException {

		RentBackStationLogicImpl rentBack = new RentBackStationLogicImpl();
		RentUnit unit = rentBack.searchRentUnit();

		if (unit != null) {
			rentBack.rentBackRentUnit(unit);
		}

	}

}
