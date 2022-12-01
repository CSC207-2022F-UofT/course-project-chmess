package engine.entities.copy;

import engine.entities.Piece;
import engine.entities.PieceFactory;
import engine.movegen.MovesGenerator;

public class PieceCopier {
    public PieceCopier() {}

    /**
     * Returns a deep clone of the given Piece instance.
     *
     * @param oldPiece the piece to be cloned
     * @return a (deep) clone of the piece
     */
    public Piece createCopy(Piece oldPiece) {
        PieceFactory pf = new PieceFactory();

        String type = oldPiece.getType();
        char color = oldPiece.getColor();
        int[] coords = oldPiece.getCoords();

        // This is the minimum amount of information needed
        // to build a copy with all the same values.
        Piece newPiece = pf.create(type, color);
        newPiece.setCoords(coords[0], coords[1]);

        return newPiece;
    }
}
