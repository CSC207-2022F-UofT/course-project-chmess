public class PieceCopier {
    /**
     * Returns a deep clone of the given Board instance.
     *
     * @see Piece#copy() Board.copy()
     *
     * @param piece the board to be cloned
     * @return a clone of the board
     */

    private Piece newPiece;
    private Piece oldPiece = new Piece();

    public PieceCopier(Piece oldPiece) {
        this.oldPiece = oldPiece;
    }

    public Piece createCopy(Piece piece) {
        //TODO!!!
        return this.newPiece;
    }

}
