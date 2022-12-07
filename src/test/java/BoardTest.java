import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import engine.entities.*;

class BoardTest {
    PieceFactory pf = new PieceFactory();

    @Test
    public void BoardConstructor() {
        Board board = new Board();
        Assertions.assertNull(board.getPieceAtAbsCoords(0, 0));
        Assertions.assertNull(board.getPieceAtAbsCoords(7, 7));
    }

    @Test
    public void BoardSetterMatchesGetter() {
        Board board = new Board();
        Piece pawn = pf.create("pawn");
        board.setPieceAtAbsCoords(0, 1, pawn);
        Assertions.assertNull(board.getPieceAtAbsCoords(1, 0));
        Assertions.assertEquals(board.getPieceAtAbsCoords(0, 1), pawn);
    }

    @Test
    public void BoardDefaultPovIsAbsolute() {
        Board board = new Board();
        Piece pawn = pf.create("pawn");
        board.setPieceAtAbsCoords(0, 1, pawn);
        Assertions.assertEquals(board.getPieceAtRelCoords(0, 1), pawn);
    }

    @Test
    public void BoardSelectDefaultPov() {
        Board board = new Board();
        Piece pawn = pf.create("pawn");
        board.setPieceAtAbsCoords(0, 1, pawn);
        board.selectDefaultPov();
        Assertions.assertEquals(board.getPieceAtRelCoords(0, 1), pawn);
    }

    @Test
    public void BoardSelectMirrorPov() {
        Board board = new Board();
        Piece pawn = pf.create("pawn");
        board.setPieceAtAbsCoords(0, 1, pawn);
        board.selectMirrorPov();
        Assertions.assertEquals(board.getPieceAtRelCoords(0, 7 - 1), pawn);
    }

    @Test
    public void BoardSelectMirrorPovThenSelectDefaultPov() {
        Board board = new Board();
        Piece pawn = pf.create("pawn");
        board.setPieceAtAbsCoords(0, 1, pawn);
        board.selectMirrorPov();
        board.selectDefaultPov();
        Assertions.assertEquals(board.getPieceAtRelCoords(0, 1), pawn);
    }

    @Test
    public void BoardMirrorReversesRowsFixesColumns() {
        Board board = new Board();
        Piece p1 = pf.create("pawn");
        board.setPieceAtAbsCoords(0, 1, p1);
        Piece p2 = pf.create("pawn");
        board.setPieceAtAbsCoords(1, 3, p2);
        Assertions.assertEquals(board.getPieceAtMirrorCoords(0, 7 - 1), p1);
        Assertions.assertEquals(board.getPieceAtMirrorCoords(1, 7 - 3), p2);
    }

    @Test
    public void AdvanceCurrentPlayer() {
        Board board = new Board();
        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        Player[] players = {p1, p2};
        board.setPlayers(players);
        board.setCurrentPlayer(0);
        board.advanceCurrentPlayer();
        Assertions.assertEquals(p2, board.getCurrentPlayer());
    }
}
