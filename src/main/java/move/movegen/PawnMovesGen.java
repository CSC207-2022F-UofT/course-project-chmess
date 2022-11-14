package move.movegen;

public class PawnMovesGen extends MovesGenerator {
    /**
     * Constructor creates list of possible moves a pawn
     * can make which is later refined by PostMoveValidator.
     * Checks if pawn can move one square, two squares,
     * capture diagonally, promote, or en passent and adds
     * them to the list of moves. Any moves which jump over
     * a piece, are not on the board, or are occupied are
     * removed from the list. King checks are NOT considered.
     */
    public PawnMovesGen (Board board, Piece pawn) {
        // implementation
        // calls removeInvalid method from parent class to remove invalid moves
    }
}
