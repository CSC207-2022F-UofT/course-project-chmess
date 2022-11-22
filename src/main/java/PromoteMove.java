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
        // TODO
    }

    /**
     * Returns the algebraic notation representing this move,
     * provided some data external to the move.
     *
     * @param board     the board on which this move is made
     * @param postGameState
     * @return the (expanded) algebraic notation for a given move
     */
    @Override
    public String getAlgebraicNotation(Board board, String postGameState) {
        String originCoords = getChessCoords(origin);
        String destCoords = getChessCoords(destination);
        Piece piece = board.getPieceAtAbsCoords(origin[0], origin[1]);
        char color = piece.getColor();
        char promotedPieceSymbol = getPieceChar(promotedType, color);
        return originCoords + destCoords + promotedPieceSymbol + postGameState;
    }
}
