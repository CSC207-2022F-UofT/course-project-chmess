import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import engine.entities.*;
import engine.move.*;

public class PromoteMoveTest extends MoveTest {
    @Test
    public void ExecuteAdvancesCurrentPlayerWhiteToBlack() {
        Board board = createEmptyBoard('W');
        Player p1 = board.getPlayerFromChar('W');;

        createAndPlacePiece("pawn", 'W', board, 5, 6);

        int[] origin = {5, 6};
        int[] dest = {5, 7};
        Move move = new PromoteMove(origin, dest, "queen");
        move.execute(board);

        Assertions.assertEquals('B', board.getCurrentPlayer().getColor());
    }

    @Test
    public void ExecuteAdvancesCurrentPlayerBlackToWhite() {
        Board board = createEmptyBoard('B');
        Player p2 = board.getPlayerFromChar('B');;

        createAndPlacePiece("pawn", 'B', board, 2, 1);

        int[] origin = {2, 1};
        int[] dest = {2, 0};
        Move move = new PromoteMove(origin, dest, "knight");
        move.execute(board);

        Assertions.assertEquals('W', board.getCurrentPlayer().getColor());
    }

    @Test
    public void ExecuteRemovesPawn() {
        Board board = createEmptyBoard('W');
        Player p1 = board.getPlayerFromChar('W');;

        createAndPlacePiece("pawn", 'W', board, 0, 6);

        int[] origin = {0, 6};
        int[] dest = {0, 7};
        Move move = new PromoteMove(origin, dest, "rook");
        move.execute(board);

        Assertions.assertNull(board.getPieceAtAbsCoords(0, 6));
    }

    @Test
    public void PromotedPieceExists() {
        Board board = createEmptyBoard('W');
        Player p1 = board.getPlayerFromChar('W');;

        createAndPlacePiece("pawn", 'W', board, 0, 6);

        int[] origin = {0, 6};
        int[] dest = {0, 7};
        Move move = new PromoteMove(origin, dest, "rook");
        move.execute(board);

        Assertions.assertNotNull(board.getPieceAtAbsCoords(dest[0], dest[1]));
    }

    @Test
    public void PromotedPieceHasCorrectPointValue() {
        Board board = createEmptyBoard('W');
        Player p1 = board.getPlayerFromChar('W');;

        createAndPlacePiece("pawn", 'W', board, 0, 6);

        int[] origin = {0, 6};
        int[] dest = {0, 7};
        Move move = new PromoteMove(origin, dest, "rook");
        move.execute(board);

        Assertions.assertEquals(5, board.getPieceAtAbsCoords(dest[0], dest[1]).getPointValue());
    }

    @Test
    public void GetAlgebraicNotationBlackKnight() {
        Board board = createEmptyBoard('B');
        Player p2 = board.getPlayerFromChar('B');;

        createAndPlacePiece("pawn", 'B', board, 2, 6);

        int[] origin = {2, 6};
        int[] dest = {2, 7};
        Move move = new PromoteMove(origin, dest, "knight");
        Assertions.assertEquals("c2c1n", move.getAlgebraicNotation(board));
    }

    @Test
    public void GetAlgebraicNotationWhiteQueen() {
        Board board = createEmptyBoard('W');
        Player p1 = board.getPlayerFromChar('W');;

        createAndPlacePiece("pawn", 'W', board, 5, 1);

        int[] origin = {5, 1};
        int[] dest = {5, 0};
        Move move = new PromoteMove(origin, dest, "queen");
        Assertions.assertEquals("f7f8Q", move.getAlgebraicNotation(board));
    }
}
