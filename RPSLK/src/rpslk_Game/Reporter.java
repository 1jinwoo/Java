package rpslk_Game;

/**
 * @author Jin Woo Won
 * This class returns statistics when the game ends
 */
public class Reporter {
	private static int cpuWin = 0;
	private static int userWin = 0;
	private static int draw = 0;
	private static int total = 0;
	private static float userWinPercent = 0;
	private static float drawPercent = 0;
	private static float cpuWinPercent = 0;
	
	
	/**
	 * Updates the variables in order to reflect current numbers
	 */
	public static void updatePercent() {
		getCpuWinPercent();
		getUserWinPercent();
		getDrawPercent();
	}
	
	/**
	 * Prints the whole report for every round played until the termination of the game
	 */
	public static void reportStats() {
		System.out.println("Total Rounds Played: " + total + "\n"
				+ "User Wins: " + userWin + "\n"
				+ "Computer Wins: " + cpuWin + "\n"
				+ "Draws: " + draw + "\n"
				+ "% User Wins: " + userWinPercent + "%" + "\n"
				+ "% Computer Wins: " + cpuWinPercent + "%" + "\n"
				+ "% Draw: " + drawPercent + "%"
				);
	}
	
	public static void incrementCpuWin() {
		cpuWin++;
	}
	
	public static void incrementUserWin() {
		userWin++;
	}
	
	public static void incrementDraw() {
		draw++;
	}
	
	public static void incrementTotal() {
		total++;
	}
	
	public static float getUserWinPercent() {
		userWinPercent = (float)userWin / (float)total * 100;  
		return userWinPercent;
	}
	
	public static float getCpuWinPercent() {
		cpuWinPercent = (float)cpuWin / (float)total * 100;
		return cpuWinPercent;
	}
	
	public static float getDrawPercent() {
		drawPercent = (float)draw / (float)total * 100;
		return drawPercent;
	}
}
