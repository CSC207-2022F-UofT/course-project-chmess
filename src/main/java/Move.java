public class Move {
    public int[] origin;
    public int[] destination;
    // isPawnDouble and isCapture is not required
    public Move (int[] origin, int[] destination) {
        this.origin = origin;
        this.destination = destination;
    }
    /**
     * Mutates board to reflect 'natural' move as opposed to
     * castling, promoting, etc. Piece located on origin square
     * is moved to destination square. If destination square
     * contains an enemy piece that piece is captured.
     */
    public void Try(Board board) {

    }
}