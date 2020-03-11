/**
 * 
 */
package proj;

import java.util.HashSet;
import java.util.Random;

/**
 * @author Adam Pollins
 *
 */
public abstract class Customer {

	static final int MAX_CARS = 3;
	HashSet<Car> cars;
	CarRentalStore store;
	String name;
	String type;
	Calendar calendar;
	
	/**
	 * Customer, Observer pattern (taken from Freeman)
	 * The subclasses also kind of have the Template pattern, however, it was more efficient to put the primitive method
	 * in the class and the template methods in the subclasses.
	 * If the subclass sets minCarsRequested equal to zero, then only the max is returned.
	 */
	public Customer(String myName) {
		cars = new HashSet<Car>();
		store = CarRentalStore.getInstance();
		calendar = Calendar.getInstance();
		name = myName;
		type = "Unknown customer type";
	}
	
	/**
	 * Rents cars as per subclass
	 */
	public void rent() {
		int carsLeft = store.getCarsLeft();
		int carsRequested = getCarsRequested();
		int carsAllowed = Math.min(carsLeft, MAX_CARS - cars.size());
		// this if statement is included here because it is assumed that if the store doesn't have the number of cars requested the customer will just rent from somewhere else that we don't record
		if(carsAllowed > 0 && carsRequested <= carsAllowed)
		{
			int days = getDays();
			RentalRecord record = new RentalRecord(days, this);
			for(int i = 0; i < carsRequested; i++) {
				Car car;
				car = store.pollRandomCar();
				store.count(type); // add this rental to the count
				double cost = car.cost() * (days - 1.0); // first we charge the base cost of the car for all days but the first
				car = decorate(car);
				cost += car.cost(); // then we charge for the first day, which includes the accessories
				pay(cost);
				record.addCar(car);
				cars.add(car);
			}
			store.fileRecord(record);
		}
	}
	
	/**
	 * Return all cars in a given record
	 * @param record
	 */
	public void ret(RentalRecord record) {
		for(Car car : record.getCars())
			returnCar(car);
		
	}
	
	/**
	 * Decorates the car as the assignment specifies
	 * @param car
	 * @return decorated car
	 */
	public Car decorate(Car car) {
		Random rand = new Random();
		if(rand.nextBoolean())
			car = new GPS(car);
		if(rand.nextBoolean())
			car = new SatelliteRadio(car);
		int r = rand.nextInt(4);
		for(int i = 0; i < r; i++)
			car = new SafetySeat(car);
		return car;
	}
	
	/**
	 * @return the number of cars the customer requests
	 */
	abstract int getCarsRequested();
	/**
	 * @return the number of days for which the customer requests the car
	 */
	abstract int getDays();
	
	/**
	 * Helper method for getCarsRequested() and getDays()
	 * @param min
	 * @param max
	 * @return a random integer from the range
	 */
	int getRandomIntFromRange(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(max - min) + min;
	}
	
	/**
	 * Returns the car to the store
	 * @param car
	 */
	void returnCar(Car car) {
		CarFactory factory = new CarFactory();
		cars.remove(car);
		String model = car.getModel();
		Plate plate = car.getPlate();
		Car cleanCar = null;
		if(model.equals("Economy Car")) // dedecorate car
			cleanCar = factory.createCar("economy", plate);
		else if(model.equals("Standard Car"))
			cleanCar = factory.createCar("standard", plate);
		else if(model.equals("Luxury Car"))
			cleanCar = factory.createCar("luxury", plate);
		else if(model.equals("SUV"))
			cleanCar = factory.createCar("suv", plate);
		else if(model.equals("Minivan"))
			cleanCar = factory.createCar("minivan", plate);
		if(cleanCar == null)
			throw new NullPointerException("Car is null");
		store.addCar(cleanCar);
	}
	
	/**
	 * Pays the store
	 * @param cost - amount paid to the store
	 */
	void pay(double cost) {
		store.addIncome(cost);
	}
	
	/**
	 * 
	 * @return the customer's name and type in the form "___ the ___ customer"
	 */
	public String getFullName() {
		return name + " the " + type + " customer";
	}
}
