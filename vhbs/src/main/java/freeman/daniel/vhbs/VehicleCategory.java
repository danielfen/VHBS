package freeman.daniel.vhbs;

/**
 * Categories of vehicles owned by the company.
 * @author freeman_d
 *
 */
public enum VehicleCategory {
	SmallCar ("Small Car"),
	EstateCar ("Estate Car"),
	Van ("Van");
	
	/** Textual representation of the vehicle category */
	String category;
	
	private VehicleCategory(String categoryName) {
		category = categoryName;
	}
	
	public String getCategory() {
		return category;
	}
	
	@Override
	public String toString() {
		return getCategory();
	}
}