/**
 * 
 */
package proj;

/**
 * @author Adam Pollins
 *
 */
public class Luxury extends Car {

	/**
	 * Constructor
	 */
	public Luxury() {
		model = "Luxury Car";
	}
	
	public Luxury(Car car) {
		super(car);
	}
	
	/**
	 * Overridden cost method per Decorator pattern
	 */
	@Override
	public double cost() {
		return 110.00;
	}

}
