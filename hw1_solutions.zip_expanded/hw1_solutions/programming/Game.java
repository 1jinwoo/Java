/** 
 * Executes all of the steps necessary to play a game of Rock Paper Scissors Lizard Spock.
 * <p>
 * It first asks for a game mode and then starts the correct game mode based on user input.
 * It then controls the communication and interactions between the players, the ruler, and the statistics.
 * @author Kimberly Tao
 */
public class Game {
	private Ruler ruler;			// Contains the ruler and finds the winner.
	private Talker talker;			// Gets user input and provides output.
	private Statistics statistics;	// Keeps track of game stats.

	private Player p1;
	private Player p2;

	/** 
	 * Creates a Game object.
	 */
	public Game() {
		ruler = new Ruler();
		statistics = new Statistics();
		talker = new Talker(statistics);
	}
	
	/**
	 * Prints the rules, gets the players, and starts playing.
	 */
	public void start() {
		talker.printRules();
		Player[] players = talker.getPlayers();
		p1 = players[0];
		p2 = players[1];

		if (p1 instanceof Human || p2 instanceof Human) {
			playGame();
		}
		else {
			int numRounds = talker.getNumRounds();
			playGame(numRounds);
		}
	}

	/**
	 * Plays the game with at least one human user.
	 */
	public void playGame() {
		boolean isContinuing = true;

		while (isContinuing) {
			// Set and get moves
			p1.setMove();
			p2.setMove();
			Ruler.Move p1Move = p1.getMove();
			Ruler.Move p2Move = p2.getMove();

			// Check if quit is entered
			if (p1Move == Ruler.Move.QUIT || p2Move == Ruler.Move.QUIT) {
				isContinuing = false;
			}

			if (isContinuing) {
				// Get winner, update statistics, and print results.
				Ruler.Result result = ruler.getResult(p1Move, p2Move);
				statistics.updateStatistics(result);
				talker.printStatistics(p1Move, p2Move, result);

				// Record data if necessary
				if (p1 instanceof Recorder) {
					((Recorder) p1).recordOpponentMove(p2Move);
				}
				if (p2 instanceof Recorder) {
					((Recorder) p2).recordOpponentMove(p1Move);
				}
			}
		}

		talker.printEndResults();
	}

	/**
	 * Plays the game with two non-human players.
	 * @param numRounds the number of rounds to play.
	 */
	public void playGame(int numRounds) {
		while (numRounds > 0) {
			// Set and get moves
			p1.setMove();
			p2.setMove();
			Ruler.Move p1Move = p1.getMove();
			Ruler.Move p2Move = p2.getMove();

			// Get winner, update statistics, and print results.
			Ruler.Result result = ruler.getResult(p1Move, p2Move);
			statistics.updateStatistics(result);
			talker.printStatistics(p1Move, p2Move, result);

			// Record data if necessary
			if (p1 instanceof Recorder) {
				((Recorder) p1).recordOpponentMove(p2Move);
			}
			if (p2 instanceof Recorder) {
				((Recorder) p2).recordOpponentMove(p1Move);
			}

			numRounds--;
		}

		talker.printEndResults();
	}
}
