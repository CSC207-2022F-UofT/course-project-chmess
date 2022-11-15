package engine.move;
import java.util.List;

public class PostMoveValidator {
    public List<Move> validMoves;
    /**
     * Takes in a board instance and a list of semi valid moves
     * created by MoveGenerator and removes all invalid moves
     * due to King checks. In more detail, calls MoveTryer for
     * each move in semiValidMoves, creating a cloned board for
     * every move. Calls MovesGenerator on this cloned board for
     * every piece belonging to opposing player, and if any of these
     * moves capture the King, the original move is invalid and is removed.
     */
    public PostMoveValidator (Board board, List<Move> semiValidMoves) {

    }
}
