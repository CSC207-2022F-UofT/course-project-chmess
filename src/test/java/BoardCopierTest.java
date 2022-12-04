import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import engine.entities.Board;
import engine.entities.Piece;
import engine.entities.PieceFactory;
import engine.entities.Player;

class BoardCopierTest {
    @Test
    void testCopyPieces() {
        Board board = createEmptyBoard();
        PieceFactory pf = new PieceFactory();

        Piece piece = pf.create("pawn", 'W');
        piece.setCoords(0,0);
        board.setPieceAtAbsCoords(0, 0, piece);

        Board copy = board.copy();

        Piece piece_original = board.getPieceAtAbsCoords(0, 0);
        Piece piece_copy = copy.getPieceAtAbsCoords(0, 0);

        Assertions.assertSame(piece_original.getColor(), piece_original.getColor());
        Assertions.assertSame(piece_original.getCoords()[0], piece_copy.getCoords()[0]);
        Assertions.assertSame(piece_original.getCoords()[1], piece_copy.getCoords()[1]);
    }

    @Test
    void testNewInstance() {
        Board board = createEmptyBoard();
        PieceFactory pf = new PieceFactory();

        Piece piece = pf.create("pawn", 'W');
        piece.setCoords(0,0);
        board.setPieceAtAbsCoords(0, 0, piece);

        Board copy = board.copy();

        Assertions.assertNotSame(board, copy);
    }

    @Test
    void testPieceNewInstance() {
        Board board = createEmptyBoard();
        PieceFactory pf = new PieceFactory();

        Piece piece = pf.create("pawn", 'W');
        piece.setCoords(0,0);
        board.setPieceAtAbsCoords(0, 0, piece);

        Board copy = board.copy();
        
        Assertions.assertNotSame(board.getPieceAtAbsCoords(0,0), copy.getPieceAtAbsCoords(0,0));
    }

    public Board createEmptyBoard() {
        Board board = new Board();
        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        Player[] players = {p1, p2};
        board.setPlayers(players);
        return board;
    }
}
