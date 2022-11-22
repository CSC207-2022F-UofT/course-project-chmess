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

        Assertions.assertTrue(p2.getType() == "pawn");
        Assertions.assertTrue(p2.getColor() == 'W');
        Assertions.assertTrue(p2.getCoords()[0] == 0);
        Assertions.assertTrue(p2.getCoords()[1] == 0);
    }

    @Test
    public void PieceMemoryDifferent() {
        Piece p = new Piece();
        p.setType("pawn");
        p.setColor('W');
        p.setCoords(0,0);
        Piece p2 = p.copy();

        Assertions.assertFalse(p == p2);
    }

}