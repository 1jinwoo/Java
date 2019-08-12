/**
 * Records all of the data from the game.
 * <p>
 * Records data for each round and updates the statistics. The results of a round are stated at the end of each round.
 * The final results for the game are stated at the end of the game.
 * @author Kimberly Tao
 */
public class Statistics {
	/**
	 * Represents a statistic in the game.
	 */
	public static enum Statistic {
		NUM_P1_WINS(0), NUM_P2_WINS(0), NUM_TIES(0), NUM_ROUNDS(0);
		private int value;

		Statistic(int count) {
			this.value = value;
		}

		/**
		 * Returns the statistic value.
		 * @return the statistic value.
		 */
		public int getValue() {
			return value;
		}

		/**
		 * Increments this statistic's value by 1.
		 */
		public void incrementValue() {
			value++;
		}
	}
	
	/**
	 * Updates the results.
	 * <p>
	 * Once a round is finished and the most recent results are recorded. It increments the tally and the number of
	 * rounds played.
	 * @param result the winner of the round.
	 */
	public void updateStatistics(Ruler.Result result) {
		// Increment tally
		if (result.toString().equalsIgnoreCase("P1")) {
			Statistic.NUM_P1_WINS.incrementValue();
		}
		else if (result.toString().equalsIgnoreCase("P2")) {
			Statistic.NUM_P2_WINS.incrementValue();
		}
		else {
			Statistic.NUM_TIES.incrementValue();
		}

		// Increment number of rounds played
		Statistic.NUM_ROUNDS.incrementValue();
	}
	
	/**
	 * Returns the number of player one's wins.
	 * @return the number of player one's wins.
	 */
	public int getNumP1Wins() {
		return Statistic.NUM_P1_WINS.getValue();
	}
	
	/**
	 * Returns the number of player two's wins
	 * @return the number of player two's wins.
	 */
	public int getNumP2Wins() {
		return Statistic.NUM_P2_WINS.getValue();
	}
	
	/**
	 * Returns the number of ties.
	 * @return the number of ties
	 */
	public int getNumTies() {
		return Statistic.NUM_TIES.getValue();
	}

	public int getNumRounds() {
		return Statistic.NUM_ROUNDS.getValue();
	}
	
	/**
	 * Returns the player 1's win percentage.
	 * @return the percentage of player 1's wins.
	 */
	public double getPercentageP1Wins() {
		if (getNumRounds() != 0) {
			return (double)getNumP1Wins() / getNumRounds() * 100;
		}
		return 0;
	}
	
	/**
	 * Returns the player 2's win percentage.
	 * @return the percentage of player 2's wins.
	 */
	public double getPercentageP2Wins() {
		if (getNumRounds() != 0) {
			return (double)getNumP2Wins() / getNumRounds() * 100;
		}
		return 0;
	}
	
	/**
	 * Returns the percentage of ties.
	 * @return the percentage of ties.
	 */
	public double getPercentageTies() {
		if (getNumRounds() != 0) {
			return (double)getNumTies() / getNumRounds() * 100;
		}
		return 0;
	}
}
