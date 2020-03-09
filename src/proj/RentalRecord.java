/**
 * 
 */
package proj;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Adam Pollins
 * A class for the rental record. Publishes to the agent
 */
public class RentalRecord {
	
	private HashSet<Car> cars;
	private int days;
	private Customer customer;
	
	/**
	 * Constructor
	 * @param due date of this rental
	 */
	public RentalRecord(int myDays, Customer myCustomer) {
		cars = new HashSet<Car>();
		days = myDays;
		customer = myCustomer;
	}

	/**
	 * Adds a car to the record
	 * @param car
	 * @return whether the operation was successful
	 */
	public boolean addCar(Car car) {
		return cars.add(car);
	}
	
	/**
	 * Removes a car from the record
	 * @param car
	 * @return whether the operation was successful
	 */
	public boolean removeCar(Car car) {
		return cars.remove(car);
	}
	
	/**
	 * 
	 * @return a set of all cars in the record
	 */
	public HashSet<Car> getCars() {
		return cars;
	}
	
	/**
	 * 
	 * @return the record's customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	
	/**
	 * 
	 * @return the number of days left in the record
	 */
	public int getDays() {
		return days;
	}
	
	/**
	 * Update the record when the day changes
	 */
	public void decDays() {
		days--;
	}

}
