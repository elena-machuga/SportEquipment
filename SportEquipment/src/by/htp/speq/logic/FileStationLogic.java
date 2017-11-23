package by.htp.speq.logic;

import by.htp.speq.station.Catalog;
import by.htp.speq.station.IncomeReport;

public interface FileStationLogic {

	Catalog readCatalog();

	Catalog readRentedCatalog();

	IncomeReport readIncomeReport();

	void writeCatalog(Catalog catalog);

	void writeRentedCatalog(Catalog catalog);

	void writeIncomeReport(IncomeReport report);

}
