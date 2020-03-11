/**
 * 
 */
package proj;

/**
 * @author Adam Pollins
 *
 */
public class GPS extends CarDecorator {

	private Car car;
	
	/**
	 * Concrete decorator constructor
	 */
	public GPS(Car myCar) {
		super(myCar);
		car = myCar;
	}

	/**
	 * Description override as per Decorator
	 */
	@Override
	public String getDescription() {
		return car.getDescription() + ", GPS";
	}

	/**
	 * Cost override as per Decorator
	 */
	@Override
	public double cost() {
		return car.cost() + 15.00;
	}

}
