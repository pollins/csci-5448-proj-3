/**
 * 
 */
package proj;

/**
 * @author Adam Pollins
 * subinterface to make up for the fact that interfaces cannot vary by parameters (not included in diagram)
 */
public interface CalendarObserver extends Observer {

	public abstract void update();

}
