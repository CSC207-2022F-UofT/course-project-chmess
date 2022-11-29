import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PieceCopierTest {
    @Test
    public void PieceDetailsCopied() {
        Piece p = new Piece();
        p.setType("pawn");
        p.setColor('W');
        p.setCoords(0,0);
        Piece p2 = p.copy();

        Assertions.assertSame("pawn", p2.getType());
        Assertions.assertSame('W', p2.getColor());
        Assertions.assertSame(0, p2.getCoords()[0]);
        Assertions.assertSame(0, p2.getCoords()[1]);
    }

    @Test
    public void PieceMemoryDifferent() {
        Piece p = new Piece();
        p.setType("pawn");
        p.setColor('W');
        p.setCoords(0,0);
        Piece p2 = p.copy();

        Assertions.assertNotSame(p, p2);
    }
}
