public class PieceCopier {
    /**
     * Returns a deep clone of the given Piece instance.
     *
     * @see Piece#copy() Piece.copy()
     *
     * @param piece the board to be cloned
     * @return a clone of the board
     */

    private Piece newPiece = new Piece();
    private Piece oldPiece;

    public PieceCopier(Piece oldPiece) {
        this.oldPiece = oldPiece;
    }

    public Piece createCopy() {
        String type = this.oldPiece.getType();
        char color = this.oldPiece.getColor();
        int[] coords = this.oldPiece.getCoords();
        int pointValue = this.oldPiece.getPointValue();
        MovesGenerator mg = this.oldPiece.getMovesGenerator();

        this.newPiece.setType(type);
        this.newPiece.setColor(color);
        this.newPiece.setCoords(coords[0], coords[1]);
        this.newPiece.setPointValue(pointValue);
        this.newPiece.setMovesGenerator(mg);

        return this.newPiece;
    }
}
