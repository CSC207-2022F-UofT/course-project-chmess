import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import engine.entities.Board;
import engine.entities.Piece;
import engine.entities.PieceFactory;

class PieceCopierTest {
    @Test
    public void PieceDetailsCopied() {
        PieceFactory pf = new PieceFactory();

        Piece p = pf.create("pawn", 'W');
        p.setCoords(0,0);

        Piece p2 = p.copy();

        Assertions.assertSame("pawn", p2.getType());
        Assertions.assertSame('W', p2.getColor());
        Assertions.assertSame(0, p2.getCoords()[0]);
        Assertions.assertSame(0, p2.getCoords()[1]);
    }

    @Test
    public void PieceMemoryDifferent() {
        PieceFactory pf = new PieceFactory();

        Piece p = pf.create("pawn", 'W');
        p.setCoords(0,0);

        Piece p2 = p.copy();

        Assertions.assertNotSame(p, p2);
    }
}
