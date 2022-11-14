package move.movegen;

public class KnightMovesGen extends MovesGenerator {
    /**
     * Constructor creates list of possible moves a knight
     * can make which is later refined by PostMoveValidator.
     * Checks if knight can move in an L-shape vertically or
     * horizontally in either direction. Any moves which are
     * not on the board or are occupied by a friendly piece
     * are removed from the list. King checks are NOT considered.
     */
    public KnightMovesGen (Board board, Piece knight) {
        // implementation
        // calls removeInvalid method from parent class to remove invalid moves
    }
}
