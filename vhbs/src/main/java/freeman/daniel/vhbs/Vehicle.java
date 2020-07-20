package freeman.daniel.vhbs;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Vehicle {
	/** Mapping of vehicle categories to their pricing */
	private static final Map<VehicleCategory, Integer> prices = new HashMap<VehicleCategory, Integer>();
	static
	{
		prices.put(VehicleCategory.SmallCar, 25);
		prices.put(VehicleCategory.EstateCar, 35);
		prices.put(VehicleCategory.Van, 50);
	}
	
	/** The vehicle registration */
	private final String reg;
	/** The type of this vehicle */
	private final VehicleCategory category;
	/** The make of this vehicle */
	private final String make;
	/** The model of this vehicle */
	private final String model;
	/** The fuel type of this vehicle */
	private final Fuel fuelType;
	/** The cost to hire this vehicle per day */
	private final int pricePerDay;

	/** The customer who is currently hiring this vehicle */
	private Customer customer;
	
	public Vehicle(String reg, VehicleCategory category, String make, String model, Fuel fuelType) {
		this.reg = reg;
		this.category = category;
		this.make = make;
		this.model = model;
		this.fuelType = fuelType;
		
		this.pricePerDay = prices.get(category);
	}
	
	/**
	 * Calculates the cost of hiring this vehicle between the given dates.
	 * Vehicles can be hired to a minimum of 1 day, and only for entire days.
	 * This method calculates the value for the number of days between the given range -
	 * if the end date is earlier than the start date, this will be handled as if the end
	 * date was the start date and the start date was the end date.
	 * 
	 * @param startDate the start date of the date range
	 * @param endDate the end date of the date range
	 * @return the cost for hiring the vehicle for the number of days in the given date range
	 */
	public long calculateHireCost(Date startDate, Date endDate) {
		// Handle negative values where the start & end date have been passed the unexpected way around
		long millisBetween = Math.abs(endDate.getTime() - startDate.getTime());
		long daysBetween = TimeUnit.MILLISECONDS.toDays(millisBetween);
		
		// Add 1 to the days between as the minimum time a vehicle can be hired for is 1 day,
		// and only for whole days
		return pricePerDay * (daysBetween + 1);
	}
	
	public VehicleCategory getCategory() {
		return category;
	}
	
	public String getRegistration() {
		return reg;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public Fuel getFuelType() {
		return fuelType;
	}
	
	public String getMake() {
		return make;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public int getPricePerDay() {
		return pricePerDay;
	}
}