package by.htp.speq.station;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import by.htp.speq.entity.Equipment;
import by.htp.speq.entity.RentUnit;

public class CatalogTest {

	private Catalog catalog;

	@Before
	public void initCatalog() {
		catalog = new Catalog();
	}

	@Test
	public void testCatalogRentUnitNotNull() {
		List<RentUnit> units = catalog.getUnits();
		assertNotNull("RentUnit storage was not initialized", units);
	}

	@Test
	public void testAddedRentUnitPresent() {
		Equipment eq = new Equipment("Equipment1");

		RentUnit unit = new RentUnit();
		unit.setEquipment(eq);
//		unit.setHourRate(2.5);

		catalog.addRentUnit(unit);

		List<RentUnit> units = catalog.getUnits();

//		RentUnit lastItem = catalog.getLastRentUnit();
//		assertEquals("RentUnit wasn't added", unit, lastItem);

	}

}
