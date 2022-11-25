/**
 * A representation of an en passant move.
 */
public class EnPassantMove extends Move {
    /**
     * Creates an EnPassantMove object with the given coordinate pairs.
     *
     * @param origin      the origin of the piece to be moved
     * @param destination the destination of the piece to be moved
     */
    public EnPassantMove(int[] origin, int[] destination) {
        super(origin, destination);
    }

    /**
     * Mutates the given board (as well as players and pieces within the board)
     * to reflect the state of the board after this move is made.
     * Removes the captured pawn, despite its unusual location.
     *
     * @param board the board on which this move should be executed
     */
    @Override
    public void execute(Board board) {
        Piece pawn = board.getPieceAtAbsCoords(origin[0], origin[1]);
        int[] capturedPos = {destination[0], origin[1]};
        // With en passant, there will always be a captured piece
        // More specifically, the captured piece will be a pawn
        Piece captured = removePiece(board, capturedPos);
        pawn.getPlayer().addCapturedPiece(captured);
        movePiece(board, origin, destination);
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
        StringBuilder sb = new StringBuilder();
        sb.append(getChessCoords(origin));
        // en passant is always a capture
        sb.append('x');
        sb.append(getChessCoords(destination));
        return sb.toString();
    }
}
