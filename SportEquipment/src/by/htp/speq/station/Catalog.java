package by.htp.speq.station;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import by.htp.speq.entity.RentUnit;

public class Catalog implements Serializable {

	private static final long serialVersionUID = 6600747107718517426L;
	private List<RentUnit> units;

	public Catalog() {
		units = new ArrayList<RentUnit>();
	}

	public List<RentUnit> getUnits() {
		return units;
	}

	public void addRentUnit(RentUnit unit) {
		units.add(unit);
	}

	@Override
	public String toString() {
		return "Catalog [units=" + units + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((units == null) ? 0 : units.hashCode());
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
		if (!(obj instanceof Catalog)) {
			return false;
		}
		Catalog other = (Catalog) obj;
		if (units == null) {
			if (other.units != null) {
				return false;
			}
		} else if (!units.equals(other.units)) {
			return false;
		}
		return true;
	}

}
