import java.util.ArrayList;

/**
 * Ruler contains all of the rules of the game, including all the moves available. It also computes the winner of a
 * round.
 * <p>
 * @author Kimberly Tao
 */
public class Ruler {
	/**
	 * Contains all the combinations of results.
	 */
	private static Result[][] resultMatrix = {
												/* P1*/
				/*	Rock		Paper			Scissors		Lizard			Spock*/
			/*Rock*/	{ Result.TIE, Result.P1_WIN, Result.P2_WIN, Result.P2_WIN, Result.P1_WIN },
			/*Paper*/	{ Result.P2_WIN, Result.TIE, Result.P1_WIN, Result.P1_WIN, Result.P2_WIN },
	/*P2*/	/*Scissors*/{ Result.P1_WIN, Result.P2_WIN, Result.TIE, Result.P2_WIN, Result.P1_WIN },
			/*Lizard*/	{ Result.P1_WIN, Result.P2_WIN, Result.P1_WIN, Result.TIE, Result.P2_WIN },
			/*Spock*/	{ Result.P2_WIN, Result.P1_WIN, Result.P2_WIN, Result.P1_WIN, Result.TIE }
	};

	/**
	 * Represents each valid move with a name and associated integer.
	 */
	public enum Move {
		ROCK("r", 0), PAPER("p", 1), SCISSORS("s", 2), LIZARD("l", 3), SPOCK("k", 4), QUIT("z", 5);

		// Move name
		private String name;
		// Numerical representation
		private int value;

		Move(String name, int value) {
			this.name = name;
			this.value = value;
		}

		/**
		 * Returns the move's name.
		 * @return the move's name.
		 */
		public String toString() {
			return name;
		}

		/**
		 * Returns an ArrayList of all moves.
		 * @return an ArrayList of all moves.
		 */
		public static ArrayList<Move> allMoves() {
			ArrayList<Move> moves = new ArrayList<Move>();
			moves.add(ROCK);
			moves.add(PAPER);
			moves.add(SCISSORS);
			moves.add(LIZARD);
			moves.add(SPOCK);

			return moves;
		}

		/**
		 * Returns the move's integer representation.
		 * @return the move's integer representation.
		 */
		public int getValue() {
			return value;
		}
	}

	/**
	 * Represents the results of a game.
	 */
	public enum Result {
		P1_WIN("P1"), P2_WIN("P2"), TIE("Tie");
		private String resultString;

		Result(String resultString) {
			this.resultString = resultString;
		}

		/**
		 * Returns the string representation of this result.
		 * @return the string representation of this result.
		 */
		public String toString() {
			return resultString;
		}
	}

	/**
	 * Decides who wins the round or if it is a tie based on the rules of the game.
	 * @param p1Move player 1's move.
	 * @param p2Move player 2's move.
	 * @return the Result of the round.
	 */
	public Result getResult(Ruler.Move p1Move, Ruler.Move p2Move) {
		return resultMatrix[p2Move.getValue()][p1Move.getValue()];
	}
}
