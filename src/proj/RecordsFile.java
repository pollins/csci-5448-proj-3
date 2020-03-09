/**
 * 
 */
package proj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * @author atp62
 *
 */
public class RecordsFile implements Subject {

	private ArrayList<Observer> observers;
	private List<RentalRecord> records;
	
	public RecordsFile() {
		observers = new ArrayList<Observer>();
		records = new ArrayList<RentalRecord>();
	}
	
	@Override
	public synchronized void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public synchronized void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if(i >= 0)
			observers.remove(i);

	}

	@Override
	public synchronized void notifyObservers() {
		for (Observer observer : observers)
			((RecordsFileObserver) observer).update(records.get(records.size() - 1));
	}

	/**
	 * Adds a record to the file and notifies the printer
	 * @param record
	 */
	public synchronized void fileRecord(RentalRecord record) {
		synchronized(records) {
			records.add(record);
		}
		notifyObservers();
	}
	
	/**
	 * Removes a record from the file
	 * @param record
	 */
	public synchronized void removeRecord(RentalRecord record) {
		int i = records.indexOf(record);
		if(i >= 0)
			synchronized(records) {
				records.remove(i);
			}
	}
	
	/**
	 * prints all records
	 */
	public synchronized void print() {
		System.out.println("Current rentals");
		synchronized(records) {
			for(RentalRecord record : records) {
				System.out.println(record.getCustomer().getFullName() + " has:");
				for(Car car : record.getCars())
					System.out.println("    " + car.getModel() + ", plate no. " + car.getPlateNumber());
			}
		}
	}

	/**
	 * Collects all due records
	 */
	public void collectDue() {
		RentalRecord[] recordArray = new RentalRecord[records.size()]; // only way that worked to avoid ConcurrentModificationException
		for(int i = 0; i < recordArray.length; i++)
			recordArray[i] = records.get(i);
		for(RentalRecord record : recordArray) {
			if(record.getDays() < 1) {
				Customer customer = record.getCustomer();
				customer.ret(record);
				removeRecord(record);
			}
		}
	}

	/**
	 * Updates every record when the day is changed
	 */
	public void updateRecords() {
		synchronized(records) {
			for(RentalRecord record : records) {
				record.decDays();
			}
		}
	}
	
}