/**
 * 
 */
package proj;

/**
 * @author Adam Pollins
 *
 */
public class SUV extends Car {

	/**
	 * Constructor
	 */
	public SUV() {
		model = "SUV";
	}
	
	public SUV(Car car) {
		super(car);
	}

	/**
	 * Overridden cost method per Decorator pattern
	 */
	@Override
	public double cost() {
		return 30.00;
	}

}
