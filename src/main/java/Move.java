/**
 * A representation of the most common move type.
 * Contrast with the anomalies
 * (1) castling, where multiple pieces move;
 * (2) promoting, where the moved piece changes type;
 * (3) en passant, where the captured piece's coordinates
 * do not match the capturing piece's destination.
 */
public class Move {
    protected int[] origin;
    protected int[] destination;

    /**
     * Creates a Move object with the given coordinate pairs.
     *
     * @param origin      the origin of the piece to be moved
     * @param destination the destination of the piece to be moved
     */
    public Move (int[] origin, int[] destination) {
        this.origin = origin;
        this.destination = destination;
    }

    /**
     * Returns the coordinates of the piece which is to be moved.
     *
     * @return the origin for this move
     */
    public int[] getOrigin() {
        return this.origin;
    }

    /**
     * Returns the destination coordinates of the piece which is to be moved.
     *
     * @return the destination for this move
     */
    public int[] getDestination() {
        return this.destination;
    }

    /**
     * Mutates the given board (as well as players and pieces within the board)
     * to reflect the state of the board after this move is made.
     *
     * @param board the board on which this move should be executed
     */
    public void execute(Board board) {
        Piece piece = board.getPieceAtAbsCoords(origin[0], origin[1]);
        board.setPieceAtAbsCoords(origin[0], origin[1], null);
        Piece captured = board.getPieceAtAbsCoords(destination[0], destination[1]);
        if (captured != null) {
            piece.getPlayer().addCapturedPiece(captured);
        }
        board.setPieceAtAbsCoords(destination[0], destination[1], piece);
    }
}
