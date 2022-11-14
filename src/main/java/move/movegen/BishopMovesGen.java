package move.movegen;

public class BishopMovesGen extends MovesGenerator {
    /**
     * Constructor creates list of possible moves a bishop
     * can make which is later refined by PostMoveValidator.
     * Checks if bishop can move seven squares diagonally in
     * either direction. Any moves which jump over a piece,
     * are not on the board, or are occupied by a friendly
     * piece are removed from the list. King checks are NOT
     * considered.
     */
    public BishopMovesGen (Board board, Piece bishop) {
        // implementation
        // calls removeInvalid method from parent class to remove invalid moves
    }
}
