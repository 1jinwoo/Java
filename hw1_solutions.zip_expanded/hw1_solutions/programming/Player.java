/**
 * Represents a player in an RPSLK game.
 */
public interface Player {
    void setMove();
    /**
     * Returns the player's move.
     * @return the player's move.
     */
    Ruler.Move getMove();
}
