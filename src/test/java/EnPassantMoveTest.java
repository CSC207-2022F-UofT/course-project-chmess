import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EnPassantMoveTest extends MoveTest {
    @Test
    public void GetAlgebraicNotation() {
        Board board = new Board();

        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        Player[] players = {p1, p2};
        board.setPlayers(players);

        createAndPlacePiece("pawn", p1, board, 0, 3);
        createAndPlacePiece("pawn", p2, board, 1, 3);

        int[] origin = {1, 3};
        int[] dest = {0, 2};
        Move move = new EnPassantMove(origin, dest);
        Assertions.assertEquals("b4xa3", move.getAlgebraicNotation(board, ""));
    }

    @Test
    public void GetAlgebraicNotationCheck() {
        Board board = new Board();

        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        Player[] players = {p1, p2};
        board.setPlayers(players);

        createAndPlacePiece("pawn", p1, board, 6, 5);
        createAndPlacePiece("pawn", p2, board, 7, 5);
        createAndPlacePiece("king", p2, board, 6, 6);

        int[] origin = {6, 5};
        int[] dest = {7, 6};
        Move move = new EnPassantMove(origin, dest);
        Assertions.assertEquals("g6xh7+", move.getAlgebraicNotation(board, "+"));
    }

    @Test
    public void GetAlgebraicNotationCheckmate() {
        Board board = new Board();

        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        Player[] players = {p1, p2};
        board.setPlayers(players);

        // .......k
        // ........
        // .....NpP
        // ......R.
        // etc.
        createAndPlacePiece("pawn", p1, board, 7, 5);
        createAndPlacePiece("rook", p1, board, 4, 0);
        createAndPlacePiece("knight", p1, board, 5, 5);
        createAndPlacePiece("pawn", p2, board, 6, 5);
        createAndPlacePiece("king", p2, board, 7, 7);

        int[] origin = {7, 5};
        int[] dest = {6, 6};
        Move move = new EnPassantMove(origin, dest);
        Assertions.assertEquals("h6xg7#", move.getAlgebraicNotation(board, "#"));
    }
}
