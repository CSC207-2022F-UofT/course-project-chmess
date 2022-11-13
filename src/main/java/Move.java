public class Move {
    public int[] origin;
    public int[] destination;
    public boolean isPawnDouble = false;
    public boolean isCapture = false;

    public Move (int[] origin, int[] destination) {
        this.origin = origin;
        this.destination = destination;
    }
    public void Try (Board board) {
        // mutates board to reflect 'natural' move as opposed to castling, etc
        // piece located on origin square is moved to destination square
    }
}
