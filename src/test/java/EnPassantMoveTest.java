import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EnPassantMoveTest extends MoveTest {
    @Test
    public void GetAlgebraicNotation() {
        Board board = createEmptyBoard('B');
        Player p1 = board.getPlayers()[0];
        Player p2 = board.getPlayers()[1];

        createAndPlacePiece("pawn", p1, board, 0, 3);
        createAndPlacePiece("pawn", p2, board, 1, 3);

        int[] origin = {1, 3};
        int[] dest = {0, 2};
        Move move = new EnPassantMove(origin, dest);
        Assertions.assertEquals("b4xa3", move.getAlgebraicNotation(board));
    }
}
