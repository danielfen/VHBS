package freeman.daniel.vhbs;

import java.util.Collection;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {
	Stock stock = new Stock();

	@GetMapping("/listForHire")
	public Collection<Vehicle> listForHire()
	{
		return stock.listAvailableVehicles();
	}
	
	@GetMapping("/listHired")
	public Collection<Vehicle> listHired()
	{
		return stock.listHiredVehicles();
	}

	@GetMapping("/calculateCost")
	public long calculateHireCost(
			@RequestParam("reg") String reg,
			@RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date start,
			@RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date end)
	{
		Vehicle vehicle = stock.getAvailableVehicle(reg);
		return vehicle.calculateHireCost(start, end);
	}	
}