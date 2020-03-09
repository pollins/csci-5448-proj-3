/**
 * 
 */
package proj;

/**
 * @author Adam Pollins
 *
 */
public class SafetySeat extends CarDecorator {

	private Car car;
	
	/**
	 * Concrete decorator constructor
	 */
	public SafetySeat(Car myCar) {
		car = myCar;
	}

	/**
	 * Description override as per Decorator
	 */
	@Override
	public String getDescription() {
		return car.getDescription() + ", Child safety seat";
	}

	/**
	 * Cost override as per Decorator
	 */
	@Override
	public double cost() {
		return car.cost() + 8.00;
	}

}
