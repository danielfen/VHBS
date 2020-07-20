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
	final String reg;
	final VehicleCategory category;
	final String make;
	final String model;
	final Fuel fuelType;
	Customer customer;
	int pricePerDay;
	
	public Vehicle(String reg, VehicleCategory category, String make, String model, Fuel fuelType) {
		this.reg = reg;
		this.category = category;
		this.make = make;
		this.model = model;
		this.fuelType = fuelType;
		
		this.pricePerDay = prices.get(category);
	}
	
	public long calculateHireCost(Date startDate, Date endDate)
	{
		long millisBetween = endDate.getTime() - startDate.getTime();
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
}