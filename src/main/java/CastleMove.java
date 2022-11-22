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
        // TODO
        // one clever implementation might involve the creation and execution
        // of two regular moves (one to move the king and one to move the rook)
        // though, this might introduce subtle bugs is one is not careful
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
