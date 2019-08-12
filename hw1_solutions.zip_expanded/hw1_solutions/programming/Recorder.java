/**
 * Represents a player that records the opponent's previous move.
 * @author Kimberly Tao
 */
public abstract class Recorder implements Player {
    protected Ruler.Move previousOpponentMove;      // Record of previous move used.
    protected Ruler.Move move;

    public void recordOpponentMove(Ruler.Move move) {
        previousOpponentMove = move;
    }
}
