/**
 * 
 */
package proj;


/**
 * @author Adam Pollins
 *
 */
public class CasualCustomer extends Customer {

	public CasualCustomer(String myName) {
		super(myName);
		type = "casual";
	}
	
	/**
	 * Returns the number of cars that the customer requests
	 */
	int getCarsRequested() {
		return 1;
	}
	
	/**
	 * Returns the number of days the customer wants to make the rental for
	 */
	int getDays() {
		return getRandomIntFromRange(1, 3);
	}

}
