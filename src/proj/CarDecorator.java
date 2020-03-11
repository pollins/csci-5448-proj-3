/**
 * 
 */
package proj;

/**
 * @author Adam Pollins
 *
 */
public abstract class CarDecorator extends Car {
	
	public CarDecorator(Car car) {
		super(car);
	}
	
	/**
	 * Method declaration per Decorator pattern
	 */
	public abstract String getDescription();

}
