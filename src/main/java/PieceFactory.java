public class PieceFactory {
    public PieceFactory() {}

    /**
     * Returns a Piece object based on the provided type.
     * The resulting object should have appropriate:
     * - type attribute,
     * - point value,
     * - moves generator.
     *
     * @param type  the type of piece to be created
     * @return      the piece
     */
    //TODO: add new construct methods to add other parameters
    public Piece create(String type) {
        Piece piece = new Piece();
        piece.setType(type);

        // Based on type, do what's needed. Possible types:
        // "pawn", "knight", "bishop", "rook", "queen", "king"
        // TODO: Attach appropriate MovesGenerator for each type
        switch (type) {
            case "pawn":
                piece.setPointValue(1);
                break;
            case "knight":
                piece.setPointValue(3);
                break;
            case "bishop":
                piece.setPointValue(3);
                break;
            case "rook":
                piece.setPointValue(5);
                break;
            case "queen":
                piece.setPointValue(9);
                break;
            case "king":
                // King can never be captured so whatever
                piece.setPointValue(0);
                break;
            default:
                throw new IllegalArgumentException("Invalid piece type: " + type);
        }

        return piece;
    }

    /**
     * Returns a Piece object based on the provided type and color.
     * The resulting object should have appropriate:
     * - type attribute,
     * - color attribute,
     * - point value,
     * - moves generator.
     * 
     * @param type  the type of piece to be created
     * @param color the color of the piece to be created
     */ 
    public Piece create(String type, char color) {
        Piece piece = this.create(type);
        piece.setColor(color);
        return piece;
    }
}
