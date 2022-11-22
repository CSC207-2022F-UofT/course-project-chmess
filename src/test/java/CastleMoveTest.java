import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CastleMoveTest extends MoveTest {
    @Test
    public void GetAlgebraicNotationWhiteKingSideCastle() {
        Board board = createEmptyBoard('W');
        Player p1 = board.getPlayers()[0];

        createAndPlacePiece("king", p1, board, 4, 0);
        createAndPlacePiece("rook", p1, board, 7, 0);

        int[] origin = {4, 0};
        int[] dest = {6, 0};
        Move move = new CastleMove(origin, dest);
        Assertions.assertEquals("0-0", move.getAlgebraicNotation(board));
    }

    @Test
    public void GetAlgebraicNotationWhiteQueenSideCastle() {
        Board board = createEmptyBoard('W');
        Player p1 = board.getPlayers()[0];
        Player p2 = board.getPlayers()[1];

        createAndPlacePiece("king", p1, board, 4, 0);
        createAndPlacePiece("rook", p1, board, 0, 0);

        int[] origin = {4, 0};
        int[] dest = {2, 0};
        Move move = new CastleMove(origin, dest);
        Assertions.assertEquals("0-0-0", move.getAlgebraicNotation(board));
    }

    @Test
    public void GetAlgebraicNotationBlackQueenSideCastle() {
        Board board = createEmptyBoard('B');
        Player p1 = board.getPlayers()[0];
        Player p2 = board.getPlayers()[1];

        createAndPlacePiece("king", p2, board, 4, 7);
        createAndPlacePiece("rook", p2, board, 0, 7);

        int[] origin = {4, 7};
        int[] dest = {2, 7};
        Move move = new CastleMove(origin, dest);
        Assertions.assertEquals("0-0-0", move.getAlgebraicNotation(board));
    }
}
