import java.util.List;

public class KingMovesGen extends MovesGenerator {
    /**
     * Constructor creates list of possible moves a king
     * can make which is later refined by PostMoveValidator.
     * Checks if king can move one square in any direction, or
     * castle. Any moves which are not on the board, or are
     * occupied by a friendly piece are removed from the list.
     * For castling, if squares in between King and Rook are
     * under attack the move is invalid and is removed.
     * Other than this special case, King checks are NOT
     * considered.
     */
    public KingMovesGen (Board board, Piece king) {
        // implementation
        // calls removeInvalid method from parent class to remove invalid moves
    }

    public List<Move> generate (Board board, Piece piece) {
        return null;
    }
}
