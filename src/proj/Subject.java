/**
 * 
 */
package proj;

/**
 * @author Adam Pollins
 * Subject interface for observer pattern
 */
public interface Subject {

	public abstract void registerObserver(Observer o);
	public abstract void removeObserver(Observer o);
	public abstract void notifyObservers();
	
}
