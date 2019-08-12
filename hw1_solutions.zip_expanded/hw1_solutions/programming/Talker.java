import java.util.Scanner;
import java.util.InputMismatchException;	// Used to handle integer scanner exceptions.

/**
 * Communicates with the user via the command prompt.
 * <p>
 * The Talker is responsible for getting user input and producing all text output for the user.
 * It can ask for the user's move and the number of rounds to play. It says the introduction, the round statistics, and
 * the end statistics.
 * @author Kimberly Tao
 */
public class Talker {
	private static final int NUM_PLAYERS = 2;
	private Scanner scanner;				// Gets the user's scanner.
	private Statistics statistics;
	
	/**
	 * Constructs a Talker with the given statistics.
	 * @param statistics the game statistics.
	 */
	public Talker(Statistics statistics) {
		scanner = new Scanner(System.in);
		this.statistics = statistics;
	}
	
	/**
	 * Prompts the user to enter the players and returns the players.
	 * @return the game players.
	 */
	public Player[] getPlayers() {
		Player [] players = new Player[NUM_PLAYERS];
		int numSelectedPlayers = 0;

		System.out.println("Please enter two players.");
		while (numSelectedPlayers != NUM_PLAYERS) {
			System.out.println("Enter player " + (numSelectedPlayers + 1) +
					"(H = human, AU = automated user, AI = intelligent computer).");
			String input = scanner.nextLine();

			if (input.equalsIgnoreCase("H")) {
				players[numSelectedPlayers++] = new Human(this);
			}
			else if (input.equalsIgnoreCase("AU")) {
				// Get automated user
				boolean isValidInput = false;

				// Loop until valid
				while (!isValidInput) {
					System.out.println("Enter type(repeater, rotator, reflector, randomizer," +
							" mixer).");
					input = scanner.nextLine();

					if (input.equalsIgnoreCase("repeater")) {
						players[numSelectedPlayers++] = new Repeater();
						isValidInput = true;
					}
					else if (input.equalsIgnoreCase("rotator")) {
						players[numSelectedPlayers++] = new Rotator();
						isValidInput = true;
					}
					else if (input.equalsIgnoreCase("reflector")) {
						players[numSelectedPlayers++] = new Reflector();
						isValidInput = true;
					}
					else if (input.equalsIgnoreCase("randomizer")) {
						players[numSelectedPlayers++] = new Randomizer();
						isValidInput = true;
					}
					else if (input.equalsIgnoreCase("mixer")) {
						players[numSelectedPlayers++] = new Mixer();
						isValidInput = true;
					}
					else {
						System.out.println("Invalid AU entered. Please try again.");
					}
				}
			}
			else if (input.equalsIgnoreCase("AI")) {
				players[numSelectedPlayers++] = new AI();
			}
			else {
				System.out.println("Invalid player type entered. Please try again.");
			}
		}
		return players;
	}

	/**
	 * Returns the human user's move.
	 * @return the human user's move.
	 */
	public Ruler.Move getUserMove() {
		// Loop until valid user input is given.
		while (true) {
			System.out.println("Please enter a move (r, p, s, l, k, z).");
			String choice = scanner.nextLine();

			// Check valid user input
			if (choice.equalsIgnoreCase(Ruler.Move.QUIT.toString())) {
				return Ruler.Move.QUIT;
			}
			for (Ruler.Move move: Ruler.Move.allMoves()) {
				if (choice.equalsIgnoreCase(move.toString())) {
					return move;
				}
			}

			System.out.println("Invalid input. Please enter one of the valid inputs given in the instructions. \n");
		}
	}

	/**
	 * Returns the number of rounds played.
	 * @return the number of rounds played.
	 */
	public int getNumRounds() {
		boolean isValidChoice = false;
		int numRounds = 0;

		// Prompt user until they enter a valid number of rounds.
		while(!isValidChoice) {
			try {
				System.out.println("Please enter the number of rounds you would like to be played.");
				numRounds = scanner.nextInt();
				
				if (numRounds <= 0) {
					throw new IllegalArgumentException();
				}
				
				isValidChoice = true;
			}
			catch(InputMismatchException e) {
				System.out.println("A number was not given. Enter a positive integer.");

			}
			catch (IllegalArgumentException e) {
				System.out.println("Number cannot be negative or 0. Enter a positive integer.");
			}
			finally {
				// Advances to the next line to take the next scanner if the previous scanner was invalid.
				scanner.nextLine();
				System.out.println();
			}
		}

		return numRounds;
	}
	
	/**
	 * Welcomes the user and states the rules of the game.
	 */
	public void printRules() {
		System.out.println("Welcome to a game of rock paper scissors lizard spock!");
		System.out.println("This is a modification of the game of rock paper scissors. The rules are: \n");
		System.out.println("Move \t \t Wins against \t \t Loses against");
		System.out.println("Rock \t \t Lizard, Scissors \t Paper,Spock");
		System.out.println("Paper \t \t Rock, Spock \t \t Lizard, Scissors");
		System.out.println("Scissors \t Paper, Lizard \t \t Rock, Spock");
		System.out.println("Lizard \t \t Spock, Paper \t \t Scissors, Rock");
		System.out.println("Spock \t \t Scissors, Rock \t Lizard, Paper \n");
		System.out.println("To give your move, enter the corresponding letter.");
		System.out.println("Rock: \t \t r");
		System.out.println("Paper: \t \t p");
		System.out.println("Scissors: \t s");
		System.out.println("Lizard: \t l");
		System.out.println("Spock: \t \t k");
		System.out.println("Exit game: \t z");
		System.out.println("The moves and the winner will be shown at the end of each round.");
		System.out.println("When you exit the game, you'll be given the final statistics.");
		System.out.println("Have fun!\n");
	}

	/**
	 * Prints the statistics for a round.
	 * @param p1Choice player 1's choice.
	 * @param p2Choice player 2's choice
	 * @param result the result for this round.
	 */
	public void printStatistics(Ruler.Move p1Choice, Ruler.Move p2Choice, Ruler.Result result) {
		System.out.println("\nP1: " + p1Choice + ", " + "P2: " + p2Choice);
		if (!result.toString().equalsIgnoreCase("Tie")) {
			System.out.println("Winner: " + result.toString());
		}
		else {
			System.out.println(result.toString());
		}
		System.out.println();
	}
	
	/**
	 * Prints the final statistics for the game when the user ends the game or all the rounds have been completed.
	 */
	public void printEndResults() {
		System.out.println("\tWins\tWin Rate(%)");
		System.out.printf("P1\t%d\t\t%.2f\n", statistics.getNumP1Wins(), statistics.getPercentageP1Wins());
		System.out.printf("P2\t%d\t\t%.2f\n", statistics.getNumP2Wins(), statistics.getPercentageP2Wins());
		System.out.println("Ties: " + statistics.getNumTies());
		System.out.printf("Tie percentage: %.2f\n", statistics.getPercentageTies());
		System.out.println("Note: Although 'tie' should occur in games versus random approximately 1/5 of the time, " +
				"the number of ties is probably less than that.");
		System.out.println("Thank you for playing!");
	}
}
