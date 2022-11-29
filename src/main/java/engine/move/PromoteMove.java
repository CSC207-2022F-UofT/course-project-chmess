package engine.move;

import engine.entities.Piece;
import engine.entities.Board;

/**
 * A representation of a (pawn) promotion move.
 */
public class PromoteMove extends Move {
    private String promotedType;

    /**
     * Creates a PromoteMove object with the given coordinate pairs.
     * The provided string is the type the moved piece should have.
     *
     * @param origin      the origin of the piece to be moved
     * @param destination the destination of the piece to be moved
     */
    public PromoteMove(int[] origin, int[] destination, String promotedType) {
        super(origin, destination);
        this.promotedType = promotedType;
    }

    /**
     * Mutates the given board (as well as players and pieces within the board)
     * to reflect the state of the board after this move is made.
     * The moved piece should be replaced with a piece of the new type.
     *
     * @param board the board on which this move should be executed
     */
    @Override
    public void execute(Board board) {
        Piece pawn = board.getPieceAtAbsCoords(origin[0], origin[1]);
        // (No captures)
        // Move pawn to row
        movePiece(board, origin, destination);
        // Promote to new type
        pawn.setType(promotedType);
        pawn.setHasMadeFirstMove();
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
        String originCoords = getChessCoords(origin);
        String destCoords = getChessCoords(destination);
        Piece piece = board.getPieceAtAbsCoords(origin[0], origin[1]);
        char color = piece.getColor();
        char promotedPieceSymbol = getPieceChar(promotedType, color);
        return originCoords + destCoords + promotedPieceSymbol;
    }
}
