public class PromoteMove extends Move {
    public Piece piecePromoted;
    public PromoteMove(int[] origin, int[] destination, Piece piecePromoted) {
        super(origin, destination);
        this.piecePromoted = piecePromoted;
    }
    /**
     * Mutates board to reflect promotion. Removes pawn
     * being promoted and places piecePromoted at destination.
     */
    public void Try (Board board) {

    }
}