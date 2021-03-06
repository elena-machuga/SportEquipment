package by.htp.speq.command.impl;

import java.io.FileNotFoundException;
import java.util.List;
import by.htp.speq.command.StationAction;
import by.htp.speq.entity.RentUnit;
import by.htp.speq.logic.FileStationLogic;
import by.htp.speq.logic.FileStationLogicImpl;
import by.htp.speq.station.IncomeReport;
import by.htp.speq.utility.PrintObject;

public class ViewIncomeReportActionImpl implements StationAction {

	private FileStationLogic logic;
	{
		// logic = new ConsoleStationLogicImpl();
		logic = new FileStationLogicImpl();
		// logic = new DataBaseStationLogicImpl();
	}

	@Override
	public void performAction() throws FileNotFoundException {
		IncomeReport report = logic.readIncomeReport();
		List<RentUnit> units = report.getRentReport();

		PrintObject.print("For the day the Rent Station made " + IncomeReport.getProfit() + " of profit and "
				+ IncomeReport.getFine() + " of fines.");

		for (RentUnit unit : units) {
			if (unit != null) {
				PrintObject.print(unit);
			}
		}

		System.exit(0);
	}

}
