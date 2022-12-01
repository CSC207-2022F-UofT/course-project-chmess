import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import engine.entities.Board;
import engine.entities.Piece;
import engine.entities.PieceFactory;

class BoardCopierTest {
    @Test
    void testCopy() {
        Board board = new Board();
        PieceFactory pf = new PieceFactory();

        Piece piece = pf.create("P", 'w', 0, 0);
        board.setPieceAtAbsCoords(0, 0, piece);

        Board copy = board.copy();

        Piece piece_original = board.getPieceAtAbsCoords(0, 0);
        Piece piece_copy = copy.getPieceAtAbsCoords(0, 0);

        Assertions.assertEquals(piece_original.getCoords(), piece_copy.getCoords());
    }

    @Test
    void testNewInstance() {
        Board board = new Board();
        PieceFactory pf = new PieceFactory();

        Piece piece = pf.create("P", 'w', 0, 0);
        board.setPieceAtAbsCoords(0, 0, piece);

        Board copy = board.copy();

        Assertions.assertNotSame(board, copy);
    }

    @Test
    void testPieceNewInstance() {
        Board board = new Board();
        PieceFactory pf = new PieceFactory();

        Piece piece = pf.create("P", 'w', 0, 0);
        board.setPieceAtAbsCoords(0, 0, piece);

        Board copy = board.copy();
        
        Assertions.assertNotSame(board.getPieceAtAbsCoords(0,0), copy.getPieceAtAbsCoords(0,0));
    }
}
