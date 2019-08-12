/**
 * A player who chooses a different strategy every N moves.
 * @author Kimberly Tao
 */
public class Mixer extends Recorder {
    private static final int NUM_STRATEGIES = 4;    // Number of available automated strategies.
    private static final int MAX_N = 5;     // Max default N value
    private final int N;      // How many rounds before switching to another strategy.
    private int currentN;   // How many rounds have been
    private Player[] strategies = {new Repeater(), new Rotator(), new Reflector(), new Randomizer()}; // Strategies
    private Player strategy;        // Current strategy

    /**
     * Creates a mixer.
     */
    public Mixer() {
        changeStrategy();
        N = (int)(Math.random() * MAX_N) + 1;   // Set N to a random number between 1 and MAX_N inclusive.
    }

    /**
     * Sets the mixer's move and updates the strategy.
     */
    public void setMove() {
        strategy.setMove();
        move = strategy.getMove();
        if (strategy instanceof Recorder) {
            ((Recorder) strategy).recordOpponentMove(previousOpponentMove);
        }
        updateStrategy();
    }

    /**
     * Gets the move.
     * @return the Mixer's move.
     */
    public Ruler.Move getMove() {
        return move;
    }

    /**
     * Updates how many rounds have been played with the given strategy and switches strategies if N is reached.
     */
    private void updateStrategy() {
        currentN++;
        if (currentN >= N) {
            changeStrategy();
            currentN = 0;
        }
    }

    /**
     * Changes the Mixer's strategy.
     */
    private void changeStrategy() {
        boolean isDifferentStrategy = false;
        int strategyNum = 0;

        // Look for new strategy
        while (!isDifferentStrategy) {
            strategyNum = (int)(Math.random() * NUM_STRATEGIES);
            if (strategy != strategies[strategyNum]) {
                isDifferentStrategy = true;
            }
        }

        strategy = strategies[strategyNum];     // Set new strategy
    }
}
