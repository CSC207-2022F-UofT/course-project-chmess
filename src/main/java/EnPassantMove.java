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
        // TODO
    }
}
