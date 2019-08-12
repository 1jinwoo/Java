package rpslk_Game;

/**
 * @author Jin Woo Won
 * This class simulates human so that the program can play a
 * lot of games quickly to obtain adequate data to improve and test the
 * AI functionality of the program. Simulation mode: throws the same
 * until it loses, then throws the next one in the sequence of RPSLK.
 * Enough for testing: 100
 */
public class Simulator {

	/**
	 * @param numberOfRounds
	 * This method simulates a human who throws the same until he loses. Once he
	 * loses he moves on to next character in the sequence of RPSLK. Human simulator
	 * goes through the number of rounds specified by the parameter numberOfRounds.
	 */
	public static void simpleSimulate(int numberOfRounds) {
		String userThrow = Thrower.randomThrow();
		String cpuThrow = Thrower.randomThrow();
		Reporter.incrementTotal();
		String result = HW1Runner.determineResult(userThrow, cpuThrow);
		System.out.println("No.1 userThrow: " + userThrow + " cpuThrow: " + cpuThrow + " " + result);
		HW1Runner.recordResult(result);
		for (int i = 1; i < numberOfRounds;) {
			if (result.equals(HW1Runner.userWins)) {//user continues until user loses
				while (result.equals(HW1Runner.userWins)) {
					i++;
					cpuThrow = Thrower.randomThrow();
					Reporter.incrementTotal();
					result = HW1Runner.determineResult(userThrow, cpuThrow);
					System.out.println("No." + i + " userThrow: " + userThrow + " cpuThrow: " + cpuThrow + " " + result);
					HW1Runner.recordResult(result);
					if(i >= numberOfRounds) {
						break;
					}
				}
			} else {//user lost so moves on to next character
				i++;
				userThrow = getNextCharacter(userThrow);
				cpuThrow = Thrower.randomThrow();
				result = HW1Runner.determineResult(userThrow, cpuThrow);
				System.out.println("No." + i + " userThrow: " + userThrow + " cpuThrow: " + cpuThrow + " " + result);
				Reporter.incrementTotal();
				HW1Runner.recordResult(result);
			}
		}
	}
	
	/**
	 * @param numberOfRounds
	 * This simulation is similar to simpleSimulate() but it calls
	 * Thinker class' methods to implement AI features.
	 */
	public static void smartSimulate(int numberOfRounds) {
		String userThrow = Thrower.randomThrow();
		String cpuThrow = Thrower.randomThrow();
		Reporter.incrementTotal();
		String result = HW1Runner.determineResult(userThrow, cpuThrow);
		System.out.println("No.1 userThrow: " + userThrow + " cpuThrow: " + cpuThrow + " " + result);
		HW1Runner.recordResult(result);
		for (int i = 1; i < numberOfRounds;) {
			if (result.equals(HW1Runner.userWins)) {//user continues until user loses
				while (result.equals(HW1Runner.userWins)) {
					cpuThrow = Thinker.decideCharacter(userThrow);
					Reporter.incrementTotal();
					result = HW1Runner.determineResult(userThrow, cpuThrow);
					i++;
					System.out.println("No." + i + " userThrow: " + userThrow + " cpuThrow: " + cpuThrow + " " + result);
					HW1Runner.recordResult(result);
					if(i >= numberOfRounds) {//to prevent endless rounds when user continues to win
						break;
					}
				}
			} else {//user lost so moves on to next character
				userThrow = getNextCharacter(userThrow);
				cpuThrow = Thinker.decideCharacter(userThrow);
				result = HW1Runner.determineResult(userThrow, cpuThrow);
				i++;
				System.out.println("No." + i + " userThrow: " + userThrow + " cpuThrow: " + cpuThrow + " " + result);
				Reporter.incrementTotal();
				HW1Runner.recordResult(result);
			}
		}
	}
	
	private static final String[] characterSequence = { "rock", "paper", "scissors", "lizard", "spock" };

	/**
	 * Takes in the latest character played
	 * and returns the next character in the sequence RPSLK
	 */
	public static String getNextCharacter(String input) {
		String output = "";
		int length = characterSequence.length;
		for(int i = 0; i < length; i++) {
			if(characterSequence[i] == input) {
				int nextIndex = ((i + 1) % length);
				output = characterSequence[nextIndex];
				}
			}
		return output;
	}
}
