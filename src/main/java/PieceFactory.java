public class PieceFactory {
    public PieceFactory() {}

    public Piece create(String type) {
        Piece piece = new Piece(type);

        // Based on type, do what's needed. Possible types:
        // "pawn", "knight", "bishop", "rook", "queen", "king"

        return piece;
    }
}
