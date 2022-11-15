package engine.move.movegen;

public class RookMovesGen extends MovesGenerator {
    /**
     * Constructor creates list of possible moves a rook
     * can make which is later refined by PostMoveValidator.
     * Checks if rook can move seven squares vertically and
     * horizontally in either direction. Any moves which jump over
     * a piece, are not on the board, or are occupied by a
     * friendly piece are removed from the list. King checks
     * are NOT considered.
     */
    public RookMovesGen (Board board, Piece rook) {
        // implementation
        // calls removeInvalid method from parent class to remove invalid moves
    }
}
