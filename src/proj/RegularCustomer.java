/**
 * 
 */
package proj;

/**
 * @author Adam Pollins
 * See Customer superclass for description of inherited methods
 */
public class RegularCustomer extends Customer {

	public RegularCustomer(String myName) {
		super(myName);
		type = "regular";
	}
	
	@Override
	int getCarsRequested() {
		return getRandomIntFromRange(1, 3);
	}

	@Override
	int getDays() {
		// TODO Auto-generated method stub
		return getRandomIntFromRange(3, 5);
	}

}
