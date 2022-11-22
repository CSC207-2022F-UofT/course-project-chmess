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
        Assertions.assertEquals("b4xa3", move.getAlgebraicNotation(board));
    }
}
