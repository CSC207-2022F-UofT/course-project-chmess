public class Move {
    public Piece piece;
    public int[] destination;
    public boolean isPawnDouble;
    public boolean isCapture;

    public Move (Piece piece, int[] destination, boolean isPawnDouble, boolean isCapture) {
        this.piece = piece;
        this.destination = destination;
        this.isPawnDouble = isPawnDouble;
        this.isCapture = isCapture;
    }

}
