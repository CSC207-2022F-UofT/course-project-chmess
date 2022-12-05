import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import engine.CheckChecker;
import engine.entities.*;

class CheckCheckerTest {
    private PieceFactory pf = new PieceFactory();
    private CheckChecker cc = new CheckChecker();
    /*
    @Test
    public void DefaultBoard() {
        Player p1 = new Player("p1", 'W');
        Player p2 = new Player("p1", 'B');
        Board board = (new BoardCreator(p1, p2)).create();
        System.out.println(board.getPieceAtAbsCoords(0, 0).getType());

        Assertions.assertFalse(cc.isPlayerInCheck(board, 'W'));
        Assertions.assertFalse(cc.isPlayerInCheck(board, 'B'));
    }
    */

    @Test
    public void SimpleCheck() {
        Board board = createEmptyBoard('W');
        createAndPlacePiece("king", 'W', board, 0, 0);
        createAndPlacePiece("rook", 'B', board, 0, 7);
        Assertions.assertTrue(cc.isPlayerInCheck(board, 'W'));
    }

    protected Piece createAndPlacePiece(String type, char color, Board board, int x, int y) {
        Piece piece = pf.create(type);
        piece.setColor(color);
        board.setPieceAtAbsCoords(x, y, piece);
        piece.setCoords(x, y);
        return piece;
    }

    protected Board createEmptyBoard(char currentPlayerColor) {
        Board board = new Board();
        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        Player[] players = {p1, p2};
        board.setPlayers(players);
        if (currentPlayerColor == 'W') {
            board.setCurrentPlayer(p1);
        } else {
            board.setCurrentPlayer(p2);
        }

        return board;
    }
}
