package freeman.daniel.vhbs;

import java.util.Collection;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class provides a REST API controller for the stock of available
 * and hired vehicles.
 * @author freeman_d
 *
 */
@RestController
public class StockController {
	/** The stock of vehicles */
	private final Stock stock = new Stock();

	/**
	 * @return the available vehicles for hire
	 */
	@CrossOrigin
	@GetMapping("/listForHire")
	public Collection<Vehicle> listForHire()
	{
		return stock.listAvailableVehicles();
	}
	
	/**
	 * @return the vehicles which are currently hired
	 */
	@CrossOrigin
	@GetMapping("/listHired")
	public Collection<Vehicle> listHired()
	{
		return stock.listHiredVehicles();
	}

	/**
	 * Calculates the cost to hire a specific vehicle between two dates
	 * @param reg the vehicle registration
	 * @param start the date to start hiring the vehicle from
	 * @param end the date to finish hiring the vehicle
	 * @return the cost of hiring the vehicle
	 */
	@CrossOrigin
	@GetMapping("/calculateCost")
	public long calculateHireCost(
			@RequestParam("reg") String reg,
			@RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date start,
			@RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date end)
	{
		long cost = 0;
		Vehicle vehicle = stock.getAvailableVehicle(reg);
		if (vehicle != null)
		{
			cost = vehicle.calculateHireCost(start, end);
		}
		return cost;
	}	
}