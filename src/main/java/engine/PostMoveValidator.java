package engine;

import java.util.List;

import engine.entities.Board;
import engine.move.Move;

public class PostMoveValidator {
    public PostMoveValidator () {}

    /**
     * Returns whether the move given will, if made,
     * puts the moving player in check.
     *
     * @param board the board with respect to which the move should be validated
     * @param move a move to be validated
     */
    public boolean moveIsValid(Board board, Move move) {
        return false;
    }

    /**
     * Removes all invalid moves from a list of semivalid moves.
     * In particular, moves which will put the moving player
     * in check will be omitted.
     *
     * @param board the board with respect to moves should be validated
     * @param semiValidMoves a collection of semivalid moves to be validated
     */
    public List<Move> getValidMoves(Board board, List<Move> semiValidMoves) {
        // due to King checks. In more detail, calls MoveTryer for
        // each move in semiValidMoves, creating a cloned board for
        // every move. Calls MovesGenerator on this cloned board for
        // every piece belonging to opposing player, and if any of these
        // moves capture the King, the original move is invalid and is removed.
        return null;
    }
}
