/**
 * 
 */
package proj;

/**
 * @author atp62
 *
 */
public class BusinessCustomer extends Customer {

	public BusinessCustomer(String myName) {
		super(myName);
		type = "business";
	}
	
	@Override
	int getCarsRequested() {
		return 3;
	}

	@Override
	int getDays() {
		return 7;
	}

}
