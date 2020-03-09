/**
 * 
 */
package proj;

/**
 * @author Adam Pollins
 * Observer interface specifically for the RecordsFile class
 */
public interface RecordsFileObserver extends Observer {
	public abstract void update(RentalRecord record);
}
