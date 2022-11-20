public class Move {
    public int[] origin;
    public int[] destination;
    public boolean isPawnDouble = false;
    public boolean isCapture = false;

    public Move (int[] origin, int[] destination) {
        this.origin = origin;
        this.destination = destination;
    }

    /**
     * Mutates board to reflect 'natural' move as opposed to
     * castling, promoting, etc. Piece located on origin square
     * is moved to destination square.
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
