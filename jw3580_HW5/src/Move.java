
/**
 * @author Jin Woo Won (jw3580) based on HW1_solutions by Kimberly Tao.
 * Stores constants of each moves with their corresponding values.
 *
 */
public enum Move {
	ROCK(0), PAPER(1), SCISSORS(2), LIZARD(3), SPOCK(4), QUIT(5);

	// Numerical representation of move
	private int value;
	
	/**
	 * @param value
	 * Constructor for constants.
	 * Each constants in this enum have values.
	 */
	Move(int value) {
		this.value = value;
	}
	
	/**
	 * @return value
	 * Getter for values for each constant.
	 */
	public int getValue() {
		return value;
	}
}
