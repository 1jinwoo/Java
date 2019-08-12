import java.util.ArrayList;

/**
 * Chooses random moves for the computer to use in the game.
 * @author Kimberly Tao 
 */
public class Randomizer implements Player {
	private Ruler.Move move;

	/**
	 * Sets the next move randomly.
	 */
	public void setMove() {
		ArrayList<Ruler.Move> allMoves = Ruler.Move.allMoves();
		int totalNumChoices = allMoves.size();
		int randomChoice = (int)(Math.random() * totalNumChoices);
		move = allMoves.get(randomChoice);
	}

	/**
	 * Returns the random choice.
	 * @return the random choice.
	 */
	public Ruler.Move getMove() {

		return move;
	}
}
