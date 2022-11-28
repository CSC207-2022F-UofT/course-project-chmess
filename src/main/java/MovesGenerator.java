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
    public abstract List<Move> generate (Board board, Piece piece);
    /**
     * Mutates list of moves by removing moves not on
     * board or occupied by friendly pieces.
     */
    public void removeInvalid (List<Move> moves, Board board) {
        // TODO: will use checkTile method
    }
    /**
     * Returns true if the destination of move is on
     * board and is NOT occupied by friendly piece.
     */
    public boolean checkTile (Move move, Board board) {
        // TODO: will use methods containsAbsCoords from board class and isOccupiedByFriendly and
        return true;
    }
    /**
     * Checks to see whether destination of move is already
     * occupied by a friendly piece using absolute coordinates.
     */
    public boolean isOccupiedByFriendly (Move move, Board board) {
        return true;
    }

    /**
     * Checks to see whether destination of move is already
     * occupied by an enemy piece using absolute coordinates.
     */
    public boolean isOccupiedByEnemy (Move move, Board board) {
        return true;
    }
}
