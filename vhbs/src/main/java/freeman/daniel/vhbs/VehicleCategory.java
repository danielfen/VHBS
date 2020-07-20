package freeman.daniel.vhbs;

public enum VehicleCategory {
	SmallCar ("Small Car"),
	EstateCar ("Estate Car"),
	Van ("Van");
	
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
