package by.htp.speq.logic;

import by.htp.speq.entity.Equipment;
import by.htp.speq.entity.RentUnit;
import by.htp.speq.station.Catalog;
import by.htp.speq.station.IncomeReport;

public class ConsoleStationLogicImpl implements FileStationLogic {

	@Override
	public Catalog readCatalog() {

		Equipment eq1 = new Equipment("Eq1");
		Equipment eq2 = new Equipment("Eq1");
		Equipment eq3 = new Equipment("Eq1");

		RentUnit re1 = new RentUnit();
		RentUnit re2 = new RentUnit();
		RentUnit re3 = new RentUnit();

		Catalog catalog = new Catalog();
		catalog.addRentUnit(re1);
		catalog.addRentUnit(re2);
		catalog.addRentUnit(re3);

		return catalog;
	}

	@Override
	public Catalog readRentedCatalog() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeCatalog(Catalog catalog) {
		// TODO Auto-generated method stub

	}

	@Override
	public void writeRentedCatalog(Catalog catalog) {
		// TODO Auto-generated method stub

	}

	@Override
	public IncomeReport readIncomeReport() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeIncomeReport(IncomeReport report) {
		// TODO Auto-generated method stub

	}

}
