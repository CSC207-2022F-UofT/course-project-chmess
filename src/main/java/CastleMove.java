public class CastleMove extends Move {
    public CastleMove(int[] origin, int[] destination) {
        super(origin, destination);
    }

    /**
     * Mutates board to reflect castling in which both the
     * rook and king are moved. Origin and destination represent
     * the King's origin and destination.
     */
    @Override
    public void execute(Board board, Piece piece) {
        // this can be implemented by calling the Try method from
        // super class 2 times (once to move king and once to move rook)
    }
}
