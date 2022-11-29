import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import engine.entities.*;
import engine.move.*;

public class CastleMoveTest extends MoveTest {
    @Test
    public void WhiteKingsideAdvancesCurrentPlayerWhiteToBlack() {
        Board board = createEmptyBoard('W');
        Player p1 = board.getPlayerFromChar('W');;

        createAndPlacePiece("king", 'W', board, 4, 0);
        createAndPlacePiece("rook", 'W', board, 7, 0);

        int[] origin = {4, 0};
        int[] dest = {6, 0};
        Move move = new CastleMove(origin, dest);
        move.execute(board);

        Assertions.assertEquals('B', board.getCurrentPlayer().getColor());
    }

    @Test
    public void BlackQueensideAdvancesCurrentPlayerBlackToWhite() {
        Board board = createEmptyBoard('B');
        Player p1 = board.getPlayerFromChar('W');;

        createAndPlacePiece("king", 'W', board, 4, 7);
        createAndPlacePiece("rook", 'W', board, 0, 7);

        int[] origin = {4, 7};
        int[] dest = {2, 7};
        Move move = new CastleMove(origin, dest);
        move.execute(board);

        Assertions.assertEquals('W', board.getCurrentPlayer().getColor());
    }

    @Test
    public void WhiteKingsideMovesKingAndRook() {
        Board board = createEmptyBoard('B');
        Player p1 = board.getPlayerFromChar('W');;

        Piece k = createAndPlacePiece("king", 'W', board, 4, 0);
        Piece r = createAndPlacePiece("rook", 'W', board, 7, 0);

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
        Player p1 = board.getPlayerFromChar('W');;

        Piece k = createAndPlacePiece("king", 'W', board, 4, 7);
        Piece r = createAndPlacePiece("rook", 'W', board, 0, 7);

        int[] origin = {4, 7};
        int[] dest = {2, 7};
        Move move = new CastleMove(origin, dest);
        move.execute(board);

        // There should be a clarification of interface here
        // Does it matter that the piece objects are actually the same,
        // or do we only need that they look exactly as they should?
        // Most likely the latter, in which case we must modify these tests.
        // In any case, we should ensure this choice is consistent.
        Assertions.assertEquals(k, board.getPieceAtAbsCoords(2, 7));
        Assertions.assertEquals(r, board.getPieceAtAbsCoords(3, 7));
        Assertions.assertTrue(k.hasMadeFirstMove());
        Assertions.assertTrue(r.hasMadeFirstMove());
        Assertions.assertNull(board.getPieceAtAbsCoords(4, 7));
        Assertions.assertNull(board.getPieceAtAbsCoords(0, 7));
    }

    @Test
    public void GetAlgebraicNotationWhiteKingSideCastle() {
        Board board = createEmptyBoard('W');
        Player p1 = board.getPlayerFromChar('W');;

        createAndPlacePiece("king", 'W', board, 4, 0);
        createAndPlacePiece("rook", 'W', board, 7, 0);

        int[] origin = {4, 0};
        int[] dest = {6, 0};
        Move move = new CastleMove(origin, dest);
        Assertions.assertEquals("0-0", move.getAlgebraicNotation(board));
    }

    @Test
    public void GetAlgebraicNotationWhiteQueenSideCastle() {
        Board board = createEmptyBoard('W');
        Player p1 = board.getPlayerFromChar('W');;
        Player p2 = board.getPlayerFromChar('B');;

        createAndPlacePiece("king", 'W', board, 4, 0);
        createAndPlacePiece("rook", 'W', board, 0, 0);

        int[] origin = {4, 0};
        int[] dest = {2, 0};
        Move move = new CastleMove(origin, dest);
        Assertions.assertEquals("0-0-0", move.getAlgebraicNotation(board));
    }

    @Test
    public void GetAlgebraicNotationBlackQueenSideCastle() {
        Board board = createEmptyBoard('B');
        Player p1 = board.getPlayerFromChar('W');;
        Player p2 = board.getPlayerFromChar('B');;

        createAndPlacePiece("king", 'B', board, 4, 7);
        createAndPlacePiece("rook", 'B', board, 0, 7);

        int[] origin = {4, 7};
        int[] dest = {2, 7};
        Move move = new CastleMove(origin, dest);
        Assertions.assertEquals("0-0-0", move.getAlgebraicNotation(board));
    }
}
