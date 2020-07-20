package freeman.daniel.vhbs;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Represents a customer who has hired a vehicle
 * @author freeman_d
 *
 */
public class Customer {
	/** The customer's name */
	private final String name;
	/** The date that the customer's vehicle hire will end **/
	private Date returnDate;
	
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