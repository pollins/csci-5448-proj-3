/**
 * 
 */
package proj;

import java.util.Random;

/**
 * @author Adam Pollins
 *
 */
public class Plate {

	private String number;
	
	/**
	 * Constructs a plate of three letters and three numbers.
	 */
	public Plate() {
		Random rand = new Random();
		String part1 = "";
		String part2 = "";
		for(int i = 0; i < 3; i++) {
			part1 += (char)(rand.nextInt(26) + 'A');
			part2 += Integer.toString(rand.nextInt(10));
		}
		number = part1 + part2;
	}

	/**
	 * Number accessor
	 * @return the plate number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Equals method for when contains() is invoked in the CarFactory constructor
	 * @param plate
	 * @return boolean equals value
	 */
	public boolean equals(Plate plate) {
		return getNumber().equals(plate.getNumber());
	}
}
