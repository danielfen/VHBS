package freeman.daniel.vhbs;

import java.util.Date;
import java.util.GregorianCalendar;

public class Customer {
	String name;
	Date returnDate;
	
	public Customer(String name, GregorianCalendar returnDate) {
		this.name = name;
		this.returnDate = returnDate.getTime();
	}
	
	public String getName() {
		return name;
	}
	
	public Date getReturnDate() {
		return returnDate;
	}
}