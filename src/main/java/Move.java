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
     */
    public void execute(Board board, Piece piece) {

    }
}
