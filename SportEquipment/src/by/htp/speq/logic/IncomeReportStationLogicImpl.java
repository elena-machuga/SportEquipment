package by.htp.speq.logic;

import java.math.BigDecimal;
import java.util.Date;
import by.htp.speq.entity.RentUnit;
import by.htp.speq.station.IncomeReport;
import by.htp.speq.utility.UserInputReader;

public class IncomeReportStationLogicImpl {

	FileStationLogic logic = new FileStationLogicImpl();
	IncomeReport report = new IncomeReport();

	public void countIncome(RentUnit unit) {
		Date rentEndDate = UserInputReader.promptAndReadDate();
		countProfit(unit, rentEndDate);
		report.addRentUnitToReport(unit);
		logic.writeIncomeReport(report);
	}

	private void countProfit(RentUnit unit, Date date) {
		double delta = (double) ((date.getTime() - unit.getRentStartDate().getTime()) / 3600000);
		int deltaInt = (int) Math.ceil(delta);
		BigDecimal profit = unit.getHourRate().multiply(new BigDecimal(deltaInt));
		IncomeReport.setProfit(IncomeReport.getProfit().add(profit));
		if (deltaInt > 24) {
			countFine(unit, date);
		}
	}

	private void countFine(RentUnit unit, Date date) {
		double delta = (double) ((date.getTime() - unit.getRentStartDate().getTime()) / 3600000);
		int deltaInt = (int) Math.ceil(delta);
		BigDecimal fine = unit.getHourRate().multiply(new BigDecimal(deltaInt - 24)).multiply(new BigDecimal(0.1));
		IncomeReport.setFine(IncomeReport.getFine().add(fine));
	}
}
