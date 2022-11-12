import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BoardCreatorTest {
    @Test
    public void BoardCreatorPawnsExist() {
        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        BoardCreator bc = new BoardCreator(p1, p2);
        Board board = bc.create();
        for (int x = 0; x < 8; x++) {
            Assertions.assertTrue(board.getPieceAtCoords(x, 1).getType() == "pawn");
            Assertions.assertTrue(board.getPieceAtCoords(x, 6).getType() == "pawn");
        }
    }

    @Test
    public void BoardCreatorAllPiecesExist() {
        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        BoardCreator bc = new BoardCreator(p1, p2);
        Board board = bc.create();

        for (int x = 0; x < 8; x++) {
            Assertions.assertNotNull(board.getPieceAtCoords(x, 0));
            Assertions.assertNotNull(board.getPieceAtCoords(x, 1));
            Assertions.assertNotNull(board.getPieceAtCoords(x, 6));
            Assertions.assertNotNull(board.getPieceAtCoords(x, 7));
        }
    }

    @Test
    public void BoardCreatorPiecesBelongToCorrectPlayers() {
        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        BoardCreator bc = new BoardCreator(p1, p2);
        Board board = bc.create();

        for (int x = 0; x < 8; x++) {
            Assertions.assertEquals(board.getPieceAtCoords(x, 0).getPlayer(), p1);
            Assertions.assertEquals(board.getPieceAtCoords(x, 0).getPlayer(), p1);
            Assertions.assertEquals(board.getPieceAtCoords(x, 6).getPlayer(), p2);
            Assertions.assertEquals(board.getPieceAtCoords(x, 7).getPlayer(), p2);
        }
    }
}
