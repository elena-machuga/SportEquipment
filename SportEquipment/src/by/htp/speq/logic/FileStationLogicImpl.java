package by.htp.speq.logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import by.htp.speq.entity.Category;
import by.htp.speq.entity.Equipment;
import by.htp.speq.entity.RentUnit;
import by.htp.speq.station.Catalog;
import by.htp.speq.station.IncomeReport;
import by.htp.speq.utility.DateConverter;
import by.htp.speq.utility.PrintObject;
import by.htp.speq.utility.StringToBigDecimalConverter;

public class FileStationLogicImpl implements FileStationLogic {

	private static final String CATALOG_FILE_PATH = "resources/station_info.txt";
	private static final String RENTED_FILE_PATH = "resources/equipment_in_rent.txt";
	private static final String INCOME_REPORT_FILE_PATH = "resources/income_report.txt";
	private static final String DELIMETER = ",";

	public static String getCatalogFilePath() {
		return CATALOG_FILE_PATH;
	}

	public static String getRentedFilePath() {
		return RENTED_FILE_PATH;
	}

	public static String getIncomeReportFilePath() {
		return INCOME_REPORT_FILE_PATH;
	}

	@Override
	public Catalog readCatalog() {

		Catalog catalog = new Catalog();

		List<String> lines = readData(CATALOG_FILE_PATH);

		for (String line : lines) {
			RentUnit unit = parseRentUnit(line);
			catalog.addRentUnit(unit);
		}
		return catalog;
	}

	@Override
	public void writeCatalog(Catalog catalog) {
		File catalogFile = new File(CATALOG_FILE_PATH);

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(catalogFile))) {
			for (RentUnit unit : catalog.getUnits()) {
				bw.write(unit.getRentUnitID() + ", " + unit.getEquipment().getTitle() + ", " + unit.getCategory() + ", "
						+ unit.getHourRate() + "\n");
			}
		} catch (IOException e) {
			PrintObject.print("Error while writing catalog");
			e.printStackTrace();
		}
	}

	@Override
	public Catalog readRentedCatalog() {

		Catalog catalog = new Catalog();

		List<String> lines = readData(RENTED_FILE_PATH);

		for (String line : lines) {
			RentUnit unit = parseRentedUnit(line);
			catalog.addRentUnit(unit);
		}
		return catalog;
	}

	@Override
	public void writeRentedCatalog(Catalog catalog) {
		File catalogFile = new File(RENTED_FILE_PATH);

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(catalogFile))) {
			for (RentUnit unit : catalog.getUnits()) {
				bw.write(unit.getRentUnitID() + ", " + unit.getEquipment().getTitle() + ", " + unit.getCategory() + ", "
						+ unit.getHourRate() + ", " + DateConverter.convertDateToString(unit.getRentStartDate()) + ", "
						+ unit.getRenterID() + "\n");
			}
		} catch (IOException e) {
			PrintObject.print("Error while writing rented catalog");
			e.printStackTrace();
		}
	}

	@Override
	public IncomeReport readIncomeReport() {

		IncomeReport report = new IncomeReport();

		List<String> lines = readData(INCOME_REPORT_FILE_PATH);

		for (String line : lines) {
			RentUnit unit = parseRentedUnit(line);
			report.addRentUnitToReport(unit);
		}
		return report;
	}

	@Override
	public void writeIncomeReport(IncomeReport report) {
		File reportFile = new File(INCOME_REPORT_FILE_PATH);

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(reportFile))) {
			for (RentUnit unit : report.getRentReport()) {
				bw.write(unit.getRentUnitID() + ", " + unit.getEquipment().getTitle() + ", " + unit.getCategory() + ", "
						+ unit.getHourRate() + ", " + DateConverter.convertDateToString(unit.getRentStartDate()) + ", "
						+ unit.getRenterID() + "\n");
			}
		} catch (IOException e) {
			PrintObject.print("Error while writing rented catalog");
			e.printStackTrace();
		}
	}

	private List<String> readData(String filePath) {

		List<String> lines = new ArrayList<>();
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(filePath));
			String line;
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return lines;
	}

	private RentUnit parseRentUnit(String line) {
		List<String> values = getRentUnitValues(line);
		Equipment eq = new Equipment();
		RentUnit rentUnit = new RentUnit();

		rentUnit.setRentUnitID(values.get(0));
		eq.setTitle(values.get(1));
		rentUnit.setEquipment(eq);
		rentUnit.setCategory(Category.valueOf(values.get(2)));
		BigDecimal bd = StringToBigDecimalConverter.convertStringToBigDecimal(values.get(3));
		rentUnit.setHourRate(bd);
		return rentUnit;
	}

	private RentUnit parseRentedUnit(String line) {
		List<String> values = getRentUnitValues(line);
		Equipment eq = new Equipment();
		RentUnit rentedUnit = new RentUnit();

		rentedUnit.setRentUnitID(values.get(0));
		eq.setTitle(values.get(1));
		rentedUnit.setEquipment(eq);
		rentedUnit.setCategory(Category.valueOf(values.get(2)));
		BigDecimal bd = StringToBigDecimalConverter.convertStringToBigDecimal(values.get(3));
		rentedUnit.setHourRate(bd);
		Date rentStartDate = DateConverter.convertStringToDate(values.get(4));
		rentedUnit.setRentStartDate(rentStartDate);
		rentedUnit.setRenterID(values.get(5));
		return rentedUnit;
	}

	private List<String> getRentUnitValues(String line) {
		String[] values = line.split(DELIMETER);
		List<String> list = new ArrayList<>();
		for (int i = 0; i < values.length; i++) {
			list.add(values[i].trim());
		}
		return list;
	}
}
