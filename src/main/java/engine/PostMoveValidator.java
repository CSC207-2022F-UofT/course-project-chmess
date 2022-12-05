package engine;

import java.util.List;
import java.util.ArrayList;

import engine.entities.Piece;
import engine.entities.Player;
import engine.entities.Board;
import engine.move.Move;

public class PostMoveValidator {
    private MoveExecutor mex = new MoveExecutor();
    private CheckChecker cc = new CheckChecker();

    public PostMoveValidator () {}

    /**
     * Returns whether the move given will, if made,
     * puts the moving player in check.
     *
     * @param board the board with respect to which the move should be validated
     * @param move a move to be validated
     */
    public boolean moveIsValid(Board board, Move move) {
        // Need to figure this out before the board mutates
        char currentPlayerColor = getCurrentPlayerColor(board, move);
        // Execute on the board copy (the "shadow board") to see whether
        // the moving player will be in check after this is made
        Board shadowBoard = board.copy();
        mex.execute(shadowBoard, move);
        return !cc.isPlayerInCheck(shadowBoard, currentPlayerColor);
    }

    private char getCurrentPlayerColor(Board board, Move move) {
        int[] origin = move.getOrigin();
        Piece movingPiece = board.getPieceAtAbsCoords(origin[0], origin[1]);
        return movingPiece.getColor();
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
        List<Move> validMoves = new ArrayList<>();
        for (Move move : semiValidMoves) {
            if (moveIsValid(board, move)) validMoves.add(move);
        }
        return validMoves;
    }
}
