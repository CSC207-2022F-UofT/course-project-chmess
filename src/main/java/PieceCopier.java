public class PieceCopier {
    /**
     * Returns a deep clone of the given Board instance.
     *
     * @see Piece#copy() Board.copy()
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
        Player player = this.oldPiece.getPlayer();
        int[] coords = this.oldPiece.getCoords();
        int pointValue = this.oldPiece.getPointValue();
        MovesGenerator mg = this.oldPiece.getMovesGenerator();

        this.newPiece.setType(type);
        this.newPiece.setPlayer(player);
        this.newPiece.setCoords(coords[0], coords[1]);
        this.newPiece.setPointValue(pointValue);
        this.newPiece.setMovesGenerator(mg);

        return this.newPiece;
    }
}
