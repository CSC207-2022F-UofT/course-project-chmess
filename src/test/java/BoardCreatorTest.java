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
            Assertions.assertTrue(board.getPieceAtAbsCoords(x, 1).getType() == "pawn");
            Assertions.assertTrue(board.getPieceAtAbsCoords(x, 6).getType() == "pawn");
        }
    }

    @Test
    public void BoardCreatorKnightsExist() {
        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        BoardCreator bc = new BoardCreator(p1, p2);
        Board board = bc.create();
        int[][] coordsPairs = {{1, 0}, {6, 0}, {1, 7}, {6, 7}};
        for (int[] coords : coordsPairs) {
            Assertions.assertTrue(board.getPieceAtAbsCoords(coords[0], coords[1]).getType() == "knight");
        }
    }

    @Test
    public void BoardCreatorBishopsExist() {
        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        BoardCreator bc = new BoardCreator(p1, p2);
        Board board = bc.create();
        int[][] coordsPairs = {{2, 0}, {5, 0}, {2, 7}, {5, 7}};
        for (int[] coords : coordsPairs) {
            Assertions.assertTrue(board.getPieceAtAbsCoords(coords[0], coords[1]).getType() == "bishop");
        }
    }

    @Test
    public void BoardCreatorRooksExist() {
        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        BoardCreator bc = new BoardCreator(p1, p2);
        Board board = bc.create();
        int[][] coordsPairs = {{0, 0}, {7, 0}, {0, 7}, {7, 7}};
        for (int[] coords : coordsPairs) {
            Assertions.assertTrue(board.getPieceAtAbsCoords(coords[0], coords[1]).getType() == "rook");
        }
    }

    @Test
    public void BoardCreatorQueensExist() {
        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        BoardCreator bc = new BoardCreator(p1, p2);
        Board board = bc.create();
        int[][] coordsPairs = {{3, 0}, {3, 7}};
        for (int[] coords : coordsPairs) {
            Assertions.assertTrue(board.getPieceAtAbsCoords(coords[0], coords[1]).getType() == "queen");
        }
    }

    @Test
    public void BoardCreatorMostlyEmpty() {
        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        BoardCreator bc = new BoardCreator(p1, p2);
        Board board = bc.create();
        for (int y = 2; y < 6; y++) {
            for (int x = 0; x < 8; x++) {
                Assertions.assertNull(board.getPieceAtAbsCoords(x, y));
            }
        }
    }

    @Test
    public void BoardCreatorAllPiecesExist() {
        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        BoardCreator bc = new BoardCreator(p1, p2);
        Board board = bc.create();

        for (int x = 0; x < 8; x++) {
            Assertions.assertNotNull(board.getPieceAtAbsCoords(x, 0));
            Assertions.assertNotNull(board.getPieceAtAbsCoords(x, 1));
            Assertions.assertNotNull(board.getPieceAtAbsCoords(x, 6));
            Assertions.assertNotNull(board.getPieceAtAbsCoords(x, 7));
        }
    }

    @Test
    public void BoardCreatorPiecesBelongToCorrectPlayers() {
        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        BoardCreator bc = new BoardCreator(p1, p2);
        Board board = bc.create();

        for (int x = 0; x < 8; x++) {
            Assertions.assertEquals(board.getPieceAtAbsCoords(x, 0).getPlayer(), p1);
            Assertions.assertEquals(board.getPieceAtAbsCoords(x, 1).getPlayer(), p1);
            Assertions.assertEquals(board.getPieceAtAbsCoords(x, 6).getPlayer(), p2);
            Assertions.assertEquals(board.getPieceAtAbsCoords(x, 7).getPlayer(), p2);
        }
    }
}
