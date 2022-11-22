import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BoardCopierTest {
    @Test
    public void BoardCheckDeepCopied() {
        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        BoardCreator bc = new BoardCreator(p1, p2);

        Board board = bc.create();

        Board board2 = board.copy();
        Assertions.assertNotSame(board, board2);
    }

    @Test
    public void BoardCheckPieceLocations() {
        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');

        BoardCreator bc = new BoardCreator(p1, p2);
        Board board = bc.create();

        Board board2 = board.copy();
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Piece p1Piece = board.getPieceAtAbsCoords(x, y);
                Piece p2Piece = board2.getPieceAtAbsCoords(x, y);
                if (p1Piece != null) {
                    Assertions.assertSame(p1Piece, p2Piece);
                    Assertions.assertSame(p1Piece.getColor(), p2Piece.getColor());
                    Assertions.assertSame(p1Piece.getCoords()[0], p2Piece.getCoords()[0]);
                    Assertions.assertSame(p1Piece.getCoords()[1], p2Piece.getCoords()[1]);
                    Assertions.assertNotSame(p1Piece, p2Piece);
                }
            }
        }
    }
}
