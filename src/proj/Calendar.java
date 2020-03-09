/**
 * 
 */
package proj;

import java.util.ArrayList;

/**
 * @author Adam Pollins
 * A class for keeping track of the date, implements singleton and observer pattern
 */
public class Calendar implements Subject {

	private static Calendar uniqueInstance;
	private ArrayList<Observer> observers;
	private int date;
	
	private Calendar() {
		observers = new ArrayList<Observer>();
		date = 0;
	}
	
	/**
	 * Get instance method for Singleton pattern
	 */
	public static synchronized Calendar getInstance() {
		if(uniqueInstance == null)
			uniqueInstance = new Calendar();
		return uniqueInstance;
	}
	
	/**
	 * 
	 * @return the date
	 */
	public int getDate() {
		return date;
	}
	
	/**
	 * Move the date forward
	 */
	public void advanceDate() {
		date++;
		notifyObservers();
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
		for(Observer observer : observers)
			((CalendarObserver)observer).update();
	}
}
