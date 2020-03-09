/**
 * 
 */
package proj;

import java.util.HashSet;
import java.util.Stack;

/**
 * @author Adam Pollins
 *
 * CarFactory class with Simple Factory pattern
 */
public class CarFactory {

	private Stack<Plate> plates;
	
	/**
	 * Constructor for the CarFactory; generates an inventory of 24 random plates.
	 * Have to be made in the factory to avoid redundancy.
	 * In a real implementation beyond the scope of this project, we'd probably get a stack of Plates from a PlateFactory,
	 * rather than having this redundant set in the constructor for the sake of the contains() method.
	 */
	public CarFactory() {
		plates = new Stack<Plate>();
		HashSet<Plate> plateSet = new HashSet<Plate>();
		while(plates.size() < 24) {
			Plate plate = new Plate();
			if(!plateSet.contains(plate)) {
				plateSet.add(plate);
				plates.add(plate);
			}
		}
		
	}

	/**
	 * Create method for Factory pattern
	 * 
	 * @param type
	 * @return a car
	 */
	public Car createCar(String type) {
		Car car;
		if(type.equals("economy"))
			car = new Economy();
		else if(type.equals("standard"))
			car = new Standard();
		else if(type.equals("luxury"))
			car = new Luxury();
		else if(type.equals("suv"))
			car = new SUV();
		else
			car = new Minivan();
		car.setPlate(plates.pop());
		return car;
	}

}