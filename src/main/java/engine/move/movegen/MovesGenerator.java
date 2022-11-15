package engine.move.movegen;

import java.util.List;
/**
 * Abstract class containing useful methods used in
 * its subclasses. Each subclass will generate a
 * list of possible moves according to the piece
 * it's related to, and will then call this method
 * removeInvalid to remove moves not on board or
 * occupied by friendly pieces.
 */
public abstract class MovesGenerator {
    public List<Move> moves;
    /**
     * Mutates list of moves by removing moves not on
     * board or occupied by friendly pieces.
     */
    public void removeInvalid (List<Move> moves) {
        // implementation: will use methods isOnBoard and isOccupiedByFriendly
    }
    /**
     * Checks to see whether destination of move is on the board.
     */
    private boolean isOnBoard (Move move) {
        // implementation
        return true;
    }
    /**
     * Checks to see whether destination of move is already
     * occupied by a friendly piece.
     */
    private boolean isOccupiedByFriendly (Move move) {
        // implementation
        return true;
    }
}
