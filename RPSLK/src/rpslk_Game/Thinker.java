package rpslk_Game;

/**
 * @author Jin Woo Won
 * This class is where artificial intelligence of the computer player lies.
 * The AI is quite simple and it is designed to counter players that stick
 * to just one moves that won the previous round.
 * IMPORTANT DIFFERENCES: This AI is strong when simulated human relies on
 * the last move of himself. However, it is weak when that is not the case.
 * 
 * Result of testing:
 * 		simple simulation (or random computer thrower) produced:
 * 			43% human wins and 36% computer wins
 * 		smart simulation (or AI computer thrower) produced:
 * 			0% human wins and 99% computer wins
**/
public class Thinker {
	
	/**
	 * @param latestUserMove
	 * @return decision
	 * This method contains the AI, which counters the previous move made
	 * by the opponent.
	 */
	public static String decideCharacter(String latestUserMove) { //simply counters the latest move by user
		String decision = counterCharacter(latestUserMove);
		return decision;
	}
	/**
	 * @param moveToCounter
	 * @return counter
	 * This private method returns character that wins against the param.
	 */
	private static String counterCharacter(String moveToCounter) {
		String counter = "rock";
		String result = HW1Runner.determineResult(counter, moveToCounter);
		while(!(result.equals(HW1Runner.userWins))) {
			counter = Simulator.getNextCharacter(counter);
			result = HW1Runner.determineResult(counter, moveToCounter);
		}
		return counter;
	}
	
}
