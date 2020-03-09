/**
 * 
 */
package proj;

/**
 * @author Adam Pollins
 *
 */
public class Minivan extends Car {

	/**
	 * Minivan constructor
	 */
	public Minivan() {
		model = "Minivan";
	}
	
	public Minivan(Car car) {
		super(car);
	}
	
	/**
	 * Overridden cost method per Decorator pattern
	 */
	@Override
	public double cost() {
		return 28.00;
	}

}
