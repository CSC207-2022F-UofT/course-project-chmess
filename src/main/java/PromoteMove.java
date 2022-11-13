public class PromoteMove extends Move {
    public Piece piecePromoted;
    public PromoteMove(int[] origin, int[] destination, Piece piecePromoted) {
        super(origin, destination);
        this.piecePromoted = piecePromoted;
    }
    public void Try (Board board) {
        // mutates board to reflect promotion
        // removes pawn being promoted and places piecePromoted at destination
    }
}