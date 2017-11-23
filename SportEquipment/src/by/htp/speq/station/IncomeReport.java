package by.htp.speq.station;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import by.htp.speq.entity.RentUnit;

public class IncomeReport implements Serializable {

	private static final long serialVersionUID = 5596666579515151983L;
	List<RentUnit> rentReport;
	private static BigDecimal profit = new BigDecimal(0);
	private static BigDecimal fine = new BigDecimal(0);

	public IncomeReport() {
		rentReport = new ArrayList<>();
	}

	public static BigDecimal getProfit() {
		return profit;
	}

	public static void setProfit(BigDecimal profit) {
		IncomeReport.profit = profit;
	}

	public static BigDecimal getFine() {
		return fine;
	}

	public static void setFine(BigDecimal fine) {
		IncomeReport.fine = fine;
	}

	public List<RentUnit> getRentReport() {
		return rentReport;
	}

	public void addRentUnitToReport(RentUnit unit) {
		rentReport.add(unit);
	}

	@Override
	public String toString() {
		return "IncomeReport [rentReport=" + rentReport + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rentReport == null) ? 0 : rentReport.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof IncomeReport)) {
			return false;
		}
		IncomeReport other = (IncomeReport) obj;
		if (rentReport == null) {
			if (other.rentReport != null) {
				return false;
			}
		} else if (!rentReport.equals(other.rentReport)) {
			return false;
		}
		return true;
	}
}
