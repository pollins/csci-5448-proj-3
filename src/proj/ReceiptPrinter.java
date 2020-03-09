/**
 * 
 */
package proj;

/**
 * @author Adam Pollins
 * This observer class prints rental records as they are created
 */
public class ReceiptPrinter implements RecordsFileObserver {

	RentalRecord record;
	RecordsFile file;
	
	public ReceiptPrinter(RecordsFile myFile) {
		file = myFile;
		file.registerObserver(this);
	}

	/**
	 * Updates the record and orders the printing of the receipt
	 */
	@Override
	public void update(RentalRecord myRecord) {
		record = myRecord;
		printReceipt();
	}
	
	/**
	 * Prints receipt from record sent by subject RecordsFile whenever a new one is added
	 */
	void printReceipt() {
		double cost = 0;
		System.out.println(record.getCustomer().getFullName() + " rented:");
		for(Car car : record.getCars()) {
			System.out.println("    " + car.getDescription());
			cost += car.cost();
		}
		System.out.println("for " + record.getDays() + " days at a total cost of $" + cost + ".");
	}

}
