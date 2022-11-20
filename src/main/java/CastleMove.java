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
}
