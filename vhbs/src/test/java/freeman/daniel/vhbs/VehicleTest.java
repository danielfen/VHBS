package freeman.daniel.vhbs;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void testCalculateHireCost_ReturnsCorrectPrice_ForSmallCar() {
		testCalculateHireCost(VehicleCategory.SmallCar);
	}
	
	@Test
	public void testCalculateHireCost_ReturnsCorrectPrice_ForEstateCar() {
		testCalculateHireCost(VehicleCategory.EstateCar);
	}
	
	@Test
	public void testCalculateHireCost_ReturnsCorrectPrice_ForVan() {
		testCalculateHireCost(VehicleCategory.Van);
	}
	
	private void testCalculateHireCost(VehicleCategory category)
	{
		Vehicle testClass = new Vehicle("testReg", category, "skoda", "citigo", Fuel.Petrol); 
		int price = 0;
		switch (category)
		{
		case SmallCar:
			price = 25;
			break;
		case EstateCar:
			price = 35;
			break;
		case Van:
			price = 50;
			break;
		}
		
		GregorianCalendar startDate = new GregorianCalendar();
		GregorianCalendar endDate = (GregorianCalendar) startDate.clone();
		int days = 1;
		// subtract 1 from the days added to the calendar. Cars are hired for entire days,
		// and even the first day should count.
		// E.g. a small car hired starting and ending 20/07/2020 would still cost £25
		endDate.add(Calendar.DAY_OF_YEAR, days-1);
		assertEquals(price*days, testClass.calculateHireCost(startDate.getTime(), endDate.getTime()));
		
		endDate = (GregorianCalendar) startDate.clone();
		days = 5;
		endDate.add(Calendar.DAY_OF_YEAR, days-1);
		assertEquals(price*days, testClass.calculateHireCost(startDate.getTime(), endDate.getTime()));
		
		endDate = (GregorianCalendar) startDate.clone();
		days = 12;
		endDate.add(Calendar.DAY_OF_YEAR, days-1);
		assertEquals(price*days, testClass.calculateHireCost(startDate.getTime(), endDate.getTime()));
		
		endDate = (GregorianCalendar) startDate.clone();
		days = 366;
		endDate.add(Calendar.DAY_OF_YEAR, days-1);
		assertEquals(price*days, testClass.calculateHireCost(startDate.getTime(), endDate.getTime()));
		
		endDate = (GregorianCalendar) startDate.clone();
		days = 3650;
		endDate.add(Calendar.DAY_OF_YEAR, days-1);
		assertEquals(price*days, testClass.calculateHireCost(startDate.getTime(), endDate.getTime()));
	}
}
