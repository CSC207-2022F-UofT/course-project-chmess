public class Move {
    public Piece piece;
    public int[] destination;
    public boolean isPawnDouble;
    public boolean isCapture;

    public Move (Piece piece, int[] destination) {
        this.piece = piece;
        this.destination = destination;
        this.isPawnDouble = False;
        this.isCapture = False;
    }

}
