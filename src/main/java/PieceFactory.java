public class PieceFactory {
    public PieceFactory() {}

    /**
     * Returns a Piece object based on the provided type.
     * The resulting object should have appropriate:
     * - type attribute,
     * - point value,
     * - move generator.
     *
     * @param type  the type of piece to be created
     * @return      the piece
     */
    public Piece create(String type) {
        Piece piece = new Piece();
        piece.setType(type);

        // Based on type, do what's needed. Possible types:
        // "pawn", "knight", "bishop", "rook", "queen", "king"
        switch (type) {
            case "pawn":
                piece.setPointValue(1);
                break;
        }

        return piece;
    }
}
