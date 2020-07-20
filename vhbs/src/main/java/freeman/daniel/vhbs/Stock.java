package freeman.daniel.vhbs;

import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class Stock {
	
	Map<String, Vehicle> available = new HashMap<>();
	Map<String, Vehicle> hired = new HashMap<>();
	
	public Stock() {
		// Pre populate the stock with initial data
		// Nominally this could be pulled in e.g. via database
		available.put("AB10 XYZ", new Vehicle("AB10 XYZ", VehicleCategory.SmallCar, "Skoda", "Citigo", Fuel.Petrol));
		available.put("AB11 XYZ", new Vehicle("AB11 XYZ", VehicleCategory.SmallCar, "Vauxhall", "Viva", Fuel.Petrol));
		available.put("AB12 XYZ", new Vehicle("AB12 XYZ", VehicleCategory.SmallCar, "Skoda", "Citigo", Fuel.Diesal));
		available.put("AB13 XYZ", new Vehicle("AB13 XYZ", VehicleCategory.EstateCar, "Ford", "Mondeo", Fuel.Petrol));
		available.put("AB14 XYZ", new Vehicle("AB14 XYZ", VehicleCategory.EstateCar, "Volkswagon", "Passat", Fuel.Petrol));
		available.put("AB18 XYZ", new Vehicle("AB18 XYZ", VehicleCategory.Van, "Ford", "Transit", Fuel.Diesal));
		available.put("HI10 ZYX", new Vehicle("HI10 ZYX", VehicleCategory.SmallCar, "Skoda", "Citigo", Fuel.Petrol));
		available.put("HI13 ZYX", new Vehicle("HI13 ZYX", VehicleCategory.EstateCar, "Ford", "Mondeo", Fuel.Petrol));
		available.put("HI18 ZYX", new Vehicle("HI18 ZYX", VehicleCategory.Van, "Ford", "Transit", Fuel.Diesal));
		available.put("HI19 ZYX", new Vehicle("HI19 ZYX", VehicleCategory.Van, "Peugeot", "Partner", Fuel.Diesal));

		vehicleHired("HI10 ZYX", new Customer("John Doe", new GregorianCalendar(2020, 07, 20)));
		vehicleHired("HI13 ZYX", new Customer("Jane Doe", new GregorianCalendar(2020, 07, 25)));
		vehicleHired("HI18 ZYX", new Customer("Smiths Ltd", new GregorianCalendar(2020, 10, 30)));
		vehicleHired("HI19 ZYX", new Customer("Smiths Ltd", new GregorianCalendar(2020, 010, 30)));	
	}
	
	
	public Collection<Vehicle> listAvailableVehicles()
	{
		return available.values();
	}
	
	public Collection<Vehicle> listHiredVehicles()
	{
		return hired.values();
	}
	
	public Vehicle getAvailableVehicle(String reg)
	{
		return available.get(reg);
	}
	
	public void vehicleHired(String reg, Customer customer)
	{
		if (available.containsKey(reg))
		{
			Vehicle vehicle = available.remove(reg);
			vehicle.setCustomer(customer);
			hired.put(reg, vehicle);
		}
		else
		{
			// TODO Perform error handling
		}
	}
	
	public void vehicleReturned(String reg)
	{
		if (available.containsKey(reg))
		{
			available.put(reg, hired.remove(reg));
		}
		else
		{
			// TODO Perform error handling
		}
	}
}