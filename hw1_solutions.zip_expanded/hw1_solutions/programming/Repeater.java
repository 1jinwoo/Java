/**
 * A player that throws the same move continuously.
 */
public class Repeater implements Player {
    private final Ruler.Move move;        // The move to throw

    /**
     * Creates a Repeater with a move to throw.
     */
    public Repeater() {
        Randomizer random = new Randomizer();
        random.setMove();
        move = random.getMove();  // Choose the repeater's move randomly.
    }

    /**
     * Do nothing implementation, move should not be modified.
     */
    public void setMove() {

    }

    /**
     * Returns the Repeater's move.
     * @return the Repeater's move.
     */
    public Ruler.Move getMove() {
        return move;
    }
}
