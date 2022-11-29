package engine.move;

import engine.entities.Board;
import engine.entities.Piece;

/**
 * A representation of a castling move.
 */
public class CastleMove extends Move {
    /**
     * Creates a CastleMove object with the given coordinate pairs.
     *
     * @param origin      the origin of the piece to be moved
     * @param destination the destination of the piece to be moved
     */
    public CastleMove(int[] origin, int[] destination) {
        super(origin, destination);
    }

    /**
     * Mutates the given board (as well as players and pieces within the board)
     * to reflect the state of the board after this move is made.
     * Moves both the king and the relevant rook.
     *
     * @param board the board on which this move should be executed
     */
    @Override
    public void execute(Board board) {
        // No need to worry about a piece at the destination
        // CastleMove objects are never created/used for this case
        // Move king
        movePiece(board, origin, destination);
        int[] rookDest;
        // Move rook
        if (destination[0] > origin[0]) {
            int[] rookO = {7, origin[1]};
            int[] rookD = {5, destination[1]};
            rookDest = rookD;
            movePiece(board, rookO, rookD);
        } else {
            int[] rookO = {0, origin[1]};
            int[] rookD = {3, destination[1]};
            rookDest = rookD;
            movePiece(board, rookO, rookD);
        }
        Piece king = board.getPieceAtAbsCoords(destination[0], destination[1]);
        Piece rook = board.getPieceAtAbsCoords(rookDest[0], rookDest[1]);
        king.setHasMadeFirstMove();
        rook.setHasMadeFirstMove();
        board.advanceCurrentPlayer();
    }

    /**
     * Returns the algebraic notation representing this move,
     * provided a board on which the move is being made.
     * The game state (check, checkmate) is omitted.
     *
     * @param board     the board on which this move is made
     * @return the (expanded) algebraic notation for a given move
     */
    @Override
    public String getAlgebraicNotation(Board board) {
        if (destination[0] > origin[0]) {
            // Moving right (toward H file) is a kingside castle
            return "0-0";
        } else {
            // Moving left (toward H file) is a queenside castle
            return "0-0-0";
        }
    }
}
