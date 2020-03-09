/**
 * 
 */
package proj;

/**
 * @author Adam Pollins
 *
 */
public class SatelliteRadio extends CarDecorator {
	
	private Car car;
	
	/**
	 * Concrete decorator constructor
	 */
	public SatelliteRadio(Car myCar) {
		car = myCar;
	}

	/**
	 * Description override as per Decorator
	 */
	@Override
	public String getDescription() {
		return car.getDescription() + ", Satellite radio";
	}

	/**
	 * Cost override as per Decorator
	 */
	@Override
	public double cost() {
		return car.cost() + 5.00;
	}

}
