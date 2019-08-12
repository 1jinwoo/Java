import java.util.ArrayList;

/**
 * A player that throws cyclically.
 * @author Kimberly Tao
 */
public class Rotator implements Player {
    private int moveIndex = 0;              // Index of current move.
    private ArrayList<Ruler.Move> moves = Ruler.Move.allMoves();    // All possible moves.
    private Ruler.Move move;    // Current move

    /**
     * Creates a Rotator that starts on a random move.
     */
    public Rotator() {
        moveIndex = (int)(Math.random() * moves.size());
    }

    /**
     * Sets the move and updates to the next move.
     */
    public void setMove() {
        move = moves.get(moveIndex);
        updateMoveIndex();
    }

    /**
     * Returns the Rotator's move and updates to the next move.
     * @return the Rotator's move.
     */
    public Ruler.Move getMove() {
        return move;
    }

    /**
     * Updates the Rotator's move.
     */
    private void updateMoveIndex() {
        moveIndex = (moveIndex + 1) % moves.size();
    }
}
