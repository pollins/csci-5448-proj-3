/**
 * 
 */
package proj;

import java.util.HashMap;

/**
 * @author Adam Pollins
 * Simple factory pattern and singleton pattern taken from Freeman (2014)
 * As the instructions say, "the store keeps track of existing rental records
 * as well as the current inventory of the store", i.e., the class does two things
 * Therefore it has to serve both in the factory and observer patterns
 */
public class CarRentalStore implements CalendarObserver {

	private static CarRentalStore uniqueInstance;
	
	private Calendar calendar;
	private Inventory inventory;
	private CarFactory factory;
	private RecordsFile file;
	private ReceiptPrinter printer;
	private HashMap<String, Integer> counts;
	private double dailyIncome;
	private double totalIncome;
	
	
	
	/**
	 * Constructor, creates all 24 cars
	 */
	private CarRentalStore(CarFactory myFactory) {
		file = new RecordsFile();
		printer = new ReceiptPrinter(file);
		counts = new HashMap<String, Integer>();
		calendar = Calendar.getInstance();
		factory = myFactory;
		inventory = new Inventory();
		dailyIncome = 0;
		totalIncome = 0;
		calendar.registerObserver(this);
		
		for(int i = 0; i < 8; i++) {
			addCar(orderCar("economy"));
			addCar(orderCar("standard"));
		}
			
		for(int i = 0; i < 3; i++) {
			addCar(orderCar("minivan"));
			addCar(orderCar("suv"));
		}
		
		for(int i = 0; i < 2; i++)
			addCar(orderCar("luxury"));
			
	}
	
	/**
	 * adds a car to the inventory
	 * @param car
	 * @return whether operation was successful
	 */
	public boolean addCar(Car car) {
		return inventory.add(car);
	}
	
	/**
	 * Gets a random car from the inventory and returns it
	 * @return car
	 */
	public Car pollRandomCar() {
		return inventory.pollRandom();
		
	}
	
	/**
	 * Get instance method for Singleton pattern
	 */
	public static synchronized CarRentalStore getInstance() {
		if(uniqueInstance == null)
			uniqueInstance = new CarRentalStore(new CarFactory());
		return uniqueInstance;
	}
	
	/**
	 * Order car per Factory pattern
	 * @param type
	 * @return
	 */
	Car orderCar(String type) {
		Car car = factory.createCar(type);
		return car;
	}
	
	/**
	 * add a rental record to the list
	 * 
	 * @param record
	 * @return
	 */
	public void fileRecord(RentalRecord record) {
		file.fileRecord(record);
	}
	
	/**
	 * get the number of cars left in the store inventory
	 */
	public int getCarsLeft() {
		return inventory.getSize();
	}

	/**
	 * Removes a record from the file
	 * @param record
	 */
	void closeRecord(RentalRecord record) {
		Customer customer = record.getCustomer();
		customer.ret(record);
		file.removeRecord(record);
		// records.remove(record);
	}

	/**
	 * Adds a number to the daily income
	 * @param cost
	 */
	public void addIncome(double cost) {
		dailyIncome += cost;
	}
	
	/**
	 * Prints all the records in the file
	 */
	public void printRecords() {
		file.print();
	}
	
	/**
	 * prints all the cars in the inventory
	 */
	public void printInventory() {
		inventory.print();
	}
	
	/**
	 * Prints the current daily income
	 */
	public void printDailyIncome() {
		System.out.println("Income for the day was " + dailyIncome);
	}
	
	/**
	 * Prints the income for all previous days
	 */
	public void printTotalIncome() {
		System.out.println("Total income was " + totalIncome);
	}
	
	/**
	 * Prints counts of all rentals
	 */
	public void printCount() {
		int total = 0;
		for(HashMap.Entry<String, Integer> entry : counts.entrySet()) {
			String type = entry.getKey();
			int value = entry.getValue();
			System.out.println("Rentals from " + type + " customers:" + value);
			total += value;
		}
		System.out.println("Total rentals: " + total);
	}
	
	/**
	 * Adds a customer to the rental count
	 * @param customerType
	 */
	public void count(String customerType) {
		if(!counts.containsKey(customerType)) {
			counts.put(customerType, 1);
		}
		else {
			int value = counts.get(customerType);
			value++;
			counts.replace(customerType, value);
		}
	}
	
	/**
	 * Makes all necessary updates upon date change
	 */
	@Override
	public synchronized void update() {
		printInventory();
		printDailyIncome();
		totalIncome += dailyIncome;
		dailyIncome = 0;
		file.updateRecords();
		file.collectDue();
	}
	
	
	
}
