import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CastleMoveTest extends MoveTest {
    @Test
    public void WhiteKingsideAdvancesCurrentPlayerWhiteToBlack() {
        Board board = createEmptyBoard('W');
        Player p1 = board.getPlayers()[0];

        createAndPlacePiece("king", p1, board, 4, 0);
        createAndPlacePiece("rook", p1, board, 7, 0);

        int[] origin = {4, 0};
        int[] dest = {6, 0};
        Move move = new CastleMove(origin, dest);
        move.execute(board);

        Assertions.assertEquals('B', board.getCurrentPlayer().getColor());
    }

    @Test
    public void BlackQueensideAdvancesCurrentPlayerBlackToWhite() {
        Board board = createEmptyBoard('B');
        Player p1 = board.getPlayers()[0];

        createAndPlacePiece("king", p1, board, 4, 7);
        createAndPlacePiece("rook", p1, board, 0, 7);

        int[] origin = {4, 7};
        int[] dest = {2, 7};
        Move move = new CastleMove(origin, dest);
        move.execute(board);

        Assertions.assertEquals('W', board.getCurrentPlayer().getColor());
    }

    @Test
    public void WhiteKingsideMovesKingAndRook() {
        Board board = createEmptyBoard('B');
        Player p1 = board.getPlayers()[0];

        Piece k = createAndPlacePiece("king", p1, board, 4, 0);
        Piece r = createAndPlacePiece("rook", p1, board, 7, 0);

        int[] origin = {4, 0};
        int[] dest = {6, 0};
        Move move = new CastleMove(origin, dest);
        move.execute(board);

        Assertions.assertEquals(k, board.getPieceAtAbsCoords(6, 0));
        Assertions.assertEquals(r, board.getPieceAtAbsCoords(5, 0));
        Assertions.assertNull(board.getPieceAtAbsCoords(4, 0));
        Assertions.assertNull(board.getPieceAtAbsCoords(7, 0));
    }

    @Test
    public void BlackQueensideMovesKingAndRook() {
        Board board = createEmptyBoard('B');
        Player p1 = board.getPlayers()[0];

        Piece k = createAndPlacePiece("king", p1, board, 4, 7);
        Piece r = createAndPlacePiece("rook", p1, board, 0, 7);

        int[] origin = {4, 7};
        int[] dest = {2, 7};
        Move move = new CastleMove(origin, dest);
        move.execute(board);

        Assertions.assertEquals(k, board.getPieceAtAbsCoords(2, 7));
        Assertions.assertEquals(r, board.getPieceAtAbsCoords(3, 7));
        Assertions.assertNull(board.getPieceAtAbsCoords(4, 7));
        Assertions.assertNull(board.getPieceAtAbsCoords(0, 7));
    }

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
