public class QueenMovesGen extends MovesGenerator {
    /**
     * Constructor creates list of possible moves a queen
     * can make which is later refined by PostMoveValidator.
     * Checks if queen can move seven squares vertically,
     * horizontally, or diagonally in either direction. Any
     * moves which jump over a piece, are not on the board,
     * or are occupied by a friendly piece are removed from
     * the list. King checks are NOT considered.
     */
    public QueenMovesGen (Board board, Piece queen) {
        // implementation
        // calls removeInvalid method from parent class to remove invalid moves
    }
}
