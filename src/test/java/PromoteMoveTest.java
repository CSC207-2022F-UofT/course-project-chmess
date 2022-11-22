import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PromoteMoveTest extends MoveTest {
    @Test
    public void GetAlgebraicNotationBlackKnight() {
        Board board = new Board();

        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        Player[] players = {p1, p2};
        board.setPlayers(players);

        createAndPlacePiece("pawn", p2, board, 2, 1);

        int[] origin = {2, 1};
        int[] dest = {2, 0};
        Move move = new PromoteMove(origin, dest, "knight");
        Assertions.assertEquals("c2c1n", move.getAlgebraicNotation(board, ""));
    }

    @Test
    public void GetAlgebraicNotationWhiteQueen() {
        Board board = new Board();

        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        Player[] players = {p1, p2};
        board.setPlayers(players);

        createAndPlacePiece("pawn", p1, board, 5, 6);

        int[] origin = {5, 6};
        int[] dest = {5, 7};
        Move move = new PromoteMove(origin, dest, "queen");
        Assertions.assertEquals("f7f8Q", move.getAlgebraicNotation(board, ""));
    }

    @Test
    public void GetAlgebraicNotationWhiteRookCheck() {
        Board board = new Board();

        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        Player[] players = {p1, p2};
        board.setPlayers(players);

        createAndPlacePiece("pawn", p1, board, 5, 6);
        createAndPlacePiece("king", p2, board, 7, 7);

        int[] origin = {5, 6};
        int[] dest = {5, 7};
        Move move = new PromoteMove(origin, dest, "rook");
        Assertions.assertEquals("f7f8R+", move.getAlgebraicNotation(board, "+"));
    }

    @Test
    public void GetAlgebraicNotationBlackQueenCheckmate() {
        Board board = new Board();

        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        Player[] players = {p1, p2};
        board.setPlayers(players);

        createAndPlacePiece("pawn", p2, board, 5, 1);
        createAndPlacePiece("knight", p2, board, 5, 2);
        createAndPlacePiece("king", p1, board, 0, 0);

        int[] origin = {5, 1};
        int[] dest = {5, 0};
        Move move = new PromoteMove(origin, dest, "queen");
        Assertions.assertEquals("f2f1q#", move.getAlgebraicNotation(board, "#"));
    }
}
