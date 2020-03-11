/**
 * 
 */
package proj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @author Adam Pollins
 *
 */
public class Simulation {

	/**
	 * The main method to run the simulation
	 * @param args
	 */
	public static void main(String[] args) {
		CarRentalStore store = CarRentalStore.getInstance(); // singleton pattern
		Calendar calendar = Calendar.getInstance();
		Random rand = new Random();
		ArrayList<Customer> customers = new ArrayList<Customer>();
		customers.add(new CasualCustomer("Charles"));
		customers.add(new CasualCustomer("Cory"));
		customers.add(new CasualCustomer("Carl"));
		customers.add(new CasualCustomer("Callie"));
		customers.add(new RegularCustomer("Rachel"));
		customers.add(new RegularCustomer("Richard"));
		customers.add(new RegularCustomer("Rob"));
		customers.add(new RegularCustomer("Rose"));
		customers.add(new BusinessCustomer("Ben"));
		customers.add(new BusinessCustomer("Bill"));
		customers.add(new BusinessCustomer("Betty"));
		customers.add(new BusinessCustomer("Barbara"));
		
		while(calendar.getDate() < 35) {
			System.out.println("Day " + (int)(calendar.getDate() + 1));
			Collections.shuffle(customers); // takes a random number of customers and sends them to the store
			int numCust = rand.nextInt(customers.size() + 1);
			for(int i = 0; i < numCust; i++) {
				Customer customer = customers.get(i);
				customer.rent();
			}
			calendar.advanceDate();
			}
		store.printCount();
		store.printTotalIncome();
		}
	}
