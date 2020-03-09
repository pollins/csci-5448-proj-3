/**
 * 
 */
package proj;

import java.util.ArrayList;
import java.util.Random;

/**
 * This is just a wrapper class for the car list, plus a special method
 * for polling a random car from the inventory
 * @author Adam Pollins
 */
public class Inventory {
	
	private ArrayList<Car> cars;
	
	/**
	 * Constructor
	 */
	public Inventory() {
		cars = new ArrayList<Car>();
	}
	
	/**
	 * wrapper method for add
	 * @param car
	 * @return boolean whether the operation was successful
	 */
	public boolean add(Car car) {
		return cars.add(car);
	}
	
	/**
	 * wrapper method for size
	 * @return number of cars in inventory
	 */
	public int getSize() {
		return cars.size();
	}
	
	/**
	 * Takes a random car from the inventory and removes it and returns it
	 * @return a random car from the inventory
	 */
	public Car pollRandom() {
		Random rand = new Random();
		
		int index = rand.nextInt(cars.size());
		Car car = cars.get(index);
		cars.remove(index);
		return car;
	}

	/**
	 * Prints the cars' model and plate number
	 */
	public void print() {
		for(Car car : cars) {
			if(car != null)
				System.out.println(car.getDescription() + ", " + car.getPlateNumber());
		}
	}

}
