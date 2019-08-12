/**
 * Represents a computer with basic artificial intelligence.
 * <p>
 * AI can play while learning the opponent's patterns. It chooses moves based on what moves the opponent
 * has played previously. It does so by keeping count of the opponent's moves.
 * <p>
 * As the user plays more rounds against the AI, the AI tends to start winning more (assuming that the user is not
 * already aware of the AI's algorithm).
 * <p>
 * The first several moves may not show any conclusive patterns in who wins more. However, as the AI
 * gathers data on the user's moves it can more accurately guess the user's next move and as a result, it tends to win
 * more. Ties also become more frequent in later rounds than in earlier rounds. The longer the game goes, the
 * higher the AI's win rate and the more likely it is to win.
 * @author Kimberly Tao
 */
public class AI extends Recorder {
	private int [] opponentMoves;
	private boolean roundPlayed;			// Keeps track of last move the user gave.
	private Ruler.Move move;

	/**
	 * Creates an AI player.
	 */
	public AI() {
		opponentMoves = new int[Ruler.Move.allMoves().size()];
	}

	/**
	 * Sets the AI's next move based on what the opponent has played previously.
	 */
	public void setMove() {
		// The AI needs at least 1 round to be played to start guessing the opponent's next move. If no rounds have
		// been played, it chooses randomly.
		if (roundPlayed) {
			int highestCount = 0;				// Count of most often played opponent move
			Ruler.Move opponentMove = Ruler.Move.ROCK;	// Opponent's move

			// Find most likely move.
			for(int i = 0; i < opponentMoves.length; i++) {
				if (opponentMoves[i] > highestCount) {
					highestCount = opponentMoves[i];
					opponentMove = Ruler.Move.allMoves().get(i);
				}
			}

			// Set counter move.
			if (opponentMove == Ruler.Move.ROCK) {
				move = Ruler.Move.PAPER;
			}
			else if (opponentMove == Ruler.Move.PAPER) {
				move = Ruler.Move.SCISSORS;
			}
			else if (opponentMove == Ruler.Move.SCISSORS) {
				move = Ruler.Move.SPOCK;
			}
			else if (opponentMove == Ruler.Move.LIZARD) {
				move = Ruler.Move.ROCK;
			}
			else if (opponentMove == Ruler.Move.SPOCK) {
				move = Ruler.Move.LIZARD;
			}

		}
		else {
			Randomizer random = new Randomizer();
			random.setMove();
			move = random.getMove();
		}
	}

	/**
	 * The computer chooses a move based on previous opponent data.
	 */
	public Ruler.Move getMove() {
		return move;
	}

	/**
	 * Records the opponent's move.
	 * <p>
	 * Records the opponent's choice for the last round.
	 * @param move the opponent's move.
	 */
	@Override
	public void recordOpponentMove(Ruler.Move move) {
		opponentMoves[move.getValue()]++;
		roundPlayed = true;
	}
}
