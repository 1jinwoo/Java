package rpslk_Game;
import java.util.Scanner;

//what is necessary is done here; solution-oriented
/**
 * @author Jin Woo Won
 * HW1Runner contains main and executes user input to allow user to
 * play as a player, simulate against random thrower, or simulate
 * against AI.
 * 
 * Runner is the central class of this program and other classes 
 */
public class HW1Runner {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);	
		while (true) {
			String userThrow = Talker.takeUserInput(scanner);
			if((userThrow.equals("rock"))	//regular play mode
					||(userThrow.equals("paper"))
					||(userThrow.equals("scissors"))
					||(userThrow.equals("lizard"))
					||(userThrow.equals("spock"))) {
				Reporter.incrementTotal();
				String cpuThrow = Thrower.randomThrow();
				String result = determineResult(userThrow, cpuThrow);
				recordResult(result);
				roundReport(userThrow, cpuThrow, result);
			} else if(userThrow.equals("simple")) {	//simple simulation mode
				Simulator.simpleSimulate(100);
				Reporter.updatePercent();
				Reporter.reportStats();
			} else if(userThrow.equals("smart")) { //smart simulation mode
				Simulator.smartSimulate(100);
				Reporter.updatePercent();
				Reporter.reportStats();
			} else if(userThrow.equals("z")) {	//program termination
				System.out.println("z typed. Game over!");
				Reporter.updatePercent();
				Reporter.reportStats();
				break;
			}
		}
		scanner.close();
	}
	
	public static String userWins = "User wins!";
	public static String cpuWins = "Computer wins!";
	
	/**
	 * @param userThrow
	 * @param cpuThrow
	 * @return result
	 * This method determines the result of the game stored as String
	 * while taking the throws by both players.
	 */
	public static String determineResult(String userThrow, String cpuThrow) {
		String result = "";
		if (userThrow.equals(cpuThrow)) {
			result = "It's a draw!";
		} else if (userThrow.equals("rock")) {
			if (cpuThrow.equals("paper")) {
				result = cpuWins;
			} else if (cpuThrow.equals("scissors")) {
				result = userWins;
			} else if (cpuThrow.equals("lizard")) {
				result = userWins;
			} else if (cpuThrow.equals("spock")) {
				result = cpuWins;
			}
		} else if (userThrow.equals("paper")) {
			if (cpuThrow.equals("rock")) {
				result = userWins;
			} else if (cpuThrow.equals("scissors")) {
				result = cpuWins;
			} else if (cpuThrow.equals("lizard")) {
				result = cpuWins;
			} else if (cpuThrow.equals("spock")) {
				result = userWins;
			}
		} else if (userThrow.equals("scissors")) {
			if (cpuThrow == "rock") {
				result = cpuWins;
			} else if (cpuThrow.equals("paper")) {
				result = userWins;
			} else if (cpuThrow.equals("lizard")) {
				result = userWins;
			} else if (cpuThrow.equals("spock")) {
				result = cpuWins;
			}
		} else if (userThrow.equals("lizard")) {
			if (cpuThrow.equals("rock")) {
				result = cpuWins;
			} else if (cpuThrow.equals("paper")) {
				result = userWins;
			} else if (cpuThrow.equals("scissors")) {
				result = cpuWins;
			} else if (cpuThrow.equals("spock")) {
				result = userWins;
			}
		} else if (userThrow.equals("spock")) {
			if (cpuThrow.equals("rock")) {
				result = userWins;
			} else if (cpuThrow.equals("paper")) {
				result = cpuWins;
			} else if (cpuThrow.equals("scissors")) {
				result = userWins;
			} else if (cpuThrow.equals("lizard")) {
				result = cpuWins;
			}
		}
		return result;
	}
	/**
	 * @param result
	 * This method calls Reporter's functions in order to
	 * properly record the result of each round.
	 */
	public static void recordResult(String result) {
		if(result.equals("User wins!")) {
			Reporter.incrementUserWin();
		} else if(result.equals("Computer wins!")) {
			Reporter.incrementCpuWin();
		} else if(result.equals("It's a draw!")) {
			Reporter.incrementDraw();
		}
	}
	
	/**
	 * @param userThrow
	 * @param cpuThrow
	 * @param decision
	 * This method reports the result at the end of each round.
	 */
	private static void roundReport(String userThrow, String cpuThrow, String decision) {
		System.out.println("User:" + userThrow
				+ " Computer: " + cpuThrow
				+ "\n" + decision);
	}
	
}
