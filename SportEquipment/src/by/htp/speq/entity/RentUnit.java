package by.htp.speq.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class RentUnit implements Serializable {

	private static final long serialVersionUID = -3663995741219911005L;
	private String rentUnitID;
	private Equipment equipment;
	private Category category;
	private BigDecimal hourRate;
	private Date rentStartDate;
	private String renterID;

	public RentUnit() {
	}

	public RentUnit(String rentUnitID, Equipment equipment, Category category, BigDecimal hourRate) {
		this.rentUnitID = rentUnitID;
		this.equipment = equipment;
		this.category = category;
		this.hourRate = hourRate;
	}

	public String getRentUnitID() {
		return rentUnitID;
	}

	public void setRentUnitID(String rentUnitID) {
		this.rentUnitID = rentUnitID;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public BigDecimal getHourRate() {
		return hourRate;
	}

	public void setHourRate(BigDecimal hourRate) {
		this.hourRate = hourRate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getRentStartDate() {
		return rentStartDate;
	}

	public void setRentStartDate(Date rentStartDate) {
		this.rentStartDate = rentStartDate;
	}

	public String getRenterID() {
		return renterID;
	}

	public void setRenterID(String renterID) {
		this.renterID = renterID;
	}

	@Override
	public String toString() {
		return "RentUnit [rentUnitID=" + rentUnitID + ", equipment=" + equipment + ", category=" + category
				+ ", hourRate=" + hourRate + ", rentStartDate=" + rentStartDate + ", renterID=" + renterID + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((equipment == null) ? 0 : equipment.hashCode());
		result = prime * result + ((hourRate == null) ? 0 : hourRate.hashCode());
		result = prime * result + ((rentStartDate == null) ? 0 : rentStartDate.hashCode());
		result = prime * result + ((rentUnitID == null) ? 0 : rentUnitID.hashCode());
		result = prime * result + ((renterID == null) ? 0 : renterID.hashCode());
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
		if (!(obj instanceof RentUnit)) {
			return false;
		}
		RentUnit other = (RentUnit) obj;
		if (category != other.category) {
			return false;
		}
		if (equipment == null) {
			if (other.equipment != null) {
				return false;
			}
		} else if (!equipment.equals(other.equipment)) {
			return false;
		}
		if (hourRate == null) {
			if (other.hourRate != null) {
				return false;
			}
		} else if (!hourRate.equals(other.hourRate)) {
			return false;
		}
		if (rentStartDate == null) {
			if (other.rentStartDate != null) {
				return false;
			}
		} else if (!rentStartDate.equals(other.rentStartDate)) {
			return false;
		}
		if (rentUnitID == null) {
			if (other.rentUnitID != null) {
				return false;
			}
		} else if (!rentUnitID.equals(other.rentUnitID)) {
			return false;
		}
		if (renterID == null) {
			if (other.renterID != null) {
				return false;
			}
		} else if (!renterID.equals(other.renterID)) {
			return false;
		}
		return true;
	}

}
