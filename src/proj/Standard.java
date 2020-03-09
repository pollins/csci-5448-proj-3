/**
 * 
 */
package proj;

/**
 * @author Adam Pollins
 *
 */
public class Standard extends Car {

	/**
	 * Constructor
	 */
	public Standard() {
		model = "Standard Car";
	}
	
	public Standard(Car car) {
		super(car);
	}

	
	/**
	 * Overridden cost method per Decorator pattern
	 */
	@Override
	public double cost() {
		return 24.00;
	}

}
