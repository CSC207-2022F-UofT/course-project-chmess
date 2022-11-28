public class PieceCopier {
    /**
     * Returns a deep clone of the given Board instance.
     *
     * @see Piece#copy() Board.copy()
     *
     * @param piece the board to be cloned
     * @return a clone of the board
     */

    public PieceCopier() {}

    public Piece createCopy(Piece oldPiece) {
        Piece newPiece = new Piece();

        String type = oldPiece.getType();
        char color = oldPiece.getColor();
        int[] coords = oldPiece.getCoords();
        int pointValue = oldPiece.getPointValue();
        MovesGenerator mg = oldPiece.getMovesGenerator();

        newPiece.setType(type);
        newPiece.setColor(color);
        newPiece.setCoords(coords[0], coords[1]);
        newPiece.setPointValue(pointValue);
        newPiece.setMovesGenerator(mg);

        return this.newPiece;
    }
}
