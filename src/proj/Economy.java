/**
 * 
 */
package proj;

/**
 * @author Adam Pollins
 *
 */
public class Economy extends Car {
	
	
	public Economy() {
		model = "Economy Car";
	}
	
	public Economy(Car car) {
		super(car);
	}
	
	/**
	 * Overridden cost method per Decorator pattern
	 */
	@Override
	public double cost() {
		return 20.00;
	}

}