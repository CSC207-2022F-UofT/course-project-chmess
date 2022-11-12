public class PieceFactory {
    public PieceFactory() {}

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
