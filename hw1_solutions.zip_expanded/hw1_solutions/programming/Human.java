/**
 * Represents a human player who can choose their own moves.
 * @author Kimberly Tao
 */
public class Human implements Player {
    private Talker talker;      // Interacts with user
    public Ruler.Move move;

    /**
     * Creates a human player with a Talker to communicate.
     * @param talker the Talker that interacts with the user.
     */
    public Human(Talker talker) {
        this.talker = talker;
    }

    public void setMove() {
        move = talker.getUserMove();
    }

    /**
     * Returns the human user's move.
     * @return the human user's move.
     */
    public Ruler.Move getMove() {
        return move;
    }
}
