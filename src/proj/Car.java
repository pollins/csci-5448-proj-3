/**
 * 
 */
package proj;

/**
 * @author Adam Pollins
 *
 */
public abstract class Car {
	
	Plate plate;
	String model;

	/**
	 * Constructor
	 */
	public Car() {
		model = "Unknown model";
	}
	
	/**
	 * This copy constructor is a 'de-decorator', since the book contains no means of removing decorations,
	 * we simply construct a new object
	 * @param car
	 */
	public Car(Car car) {
		this.model = car.model;
		this.plate = car.plate;
	}
	
	/**
	 * Plate mutator method
	 * @param myPlate
	 */
	public void setPlate(Plate myPlate) {
		plate = myPlate;
	}
	
	/**
	 * return the Car model
	 */
	public String getModel() {
		return model;
	}
	
	/**
	 * Return a description of the car, in this case the model (overridden in decorated subclasses)
	 * @return description
	 */
	public String getDescription() {
		return getModel();
	}
	
	/**
	 * 
	 * @return the plate number of the car
	 */
	public String getPlateNumber() {
		return plate.getNumber();
	}
	
	/**
	 * Cost method for Decorator pattern
	 * @return the total cost of the car
	 */
	public abstract double cost();

}