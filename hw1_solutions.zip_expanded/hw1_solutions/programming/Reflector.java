/**
 * A player that plays the move the opponent played last.
 */
public class Reflector extends Recorder {
    /**
     * Sets the Reflector's move.
     */
    public void setMove() {
        if (previousOpponentMove != null) {
            move = previousOpponentMove;
        }
        else {
            Randomizer random = new Randomizer();
            random.setMove();
            move = random.getMove();
        }
    }
    /**
     * Returns the opponent's previous move. If there is no previous move, play randomly.
     * @return the opponent's previous move. If there is no previous move, play randomly.
     */
    public Ruler.Move getMove() {
        return move;
    }
}
