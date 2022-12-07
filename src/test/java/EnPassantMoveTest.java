import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import engine.entities.*;
import engine.move.*;

public class EnPassantMoveTest extends MoveTest {
    @Test
    public void ExecuteAdvancesCurrentPlayerWhiteToBlack() {
        Board board = createEmptyBoard('W');
        Player p1 = board.getPlayerFromChar('W');;
        Player p2 = board.getPlayerFromChar('B');;

        Piece pawn1 = createAndPlacePiece("pawn", 'W', board, 1, 4);
        createAndPlacePiece("pawn", 'B', board, 0, 4);

        int[] origin = {1, 4};
        int[] dest = {0, 5};
        Move move = new EnPassantMove(origin, dest);
        move.execute(board);

        Assertions.assertEquals('B', board.getCurrentPlayer().getColor());
    }

    @Test
    public void ExecuteMovesPawn() {
        Board board = createEmptyBoard('W');
        Player p1 = board.getPlayerFromChar('W');;
        Player p2 = board.getPlayerFromChar('B');;

        Piece pawn1 = createAndPlacePiece("pawn", 'W', board, 1, 4);
        createAndPlacePiece("pawn", 'B', board, 0, 4);

        int[] origin = {1, 4};
        int[] dest = {0, 5};
        Move move = new EnPassantMove(origin, dest);
        move.execute(board);
        Assertions.assertNull(board.getPieceAtAbsCoords(1, 4));
        Assertions.assertEquals(pawn1, board.getPieceAtAbsCoords(0, 5));
    }

    @Test
    public void ExecuteRemovesCapturedPawn() {
        Board board = createEmptyBoard('W');
        Player p1 = board.getPlayerFromChar('W');;
        Player p2 = board.getPlayerFromChar('B');;

        createAndPlacePiece("pawn", 'W', board, 6, 4);
        createAndPlacePiece("pawn", 'B', board, 7, 4);

        int[] origin = {6, 4};
        int[] dest = {7, 5};
        Move move = new EnPassantMove(origin, dest);
        move.execute(board);
        Assertions.assertNull(board.getPieceAtAbsCoords(7, 4));
    }

    @Test
    public void ExecuteWithCaptureUpdatesCapturedPieces() {
        Board board = createEmptyBoard('B');
        Player p1 = board.getPlayerFromChar('W');;
        Player p2 = board.getPlayerFromChar('B');;

        createAndPlacePiece("pawn", 'W', board, 0, 3);
        createAndPlacePiece("pawn", 'B', board, 1, 3);

        int[] origin = {1, 3};
        int[] dest = {0, 2};
        Move move = new EnPassantMove(origin, dest);
        move.execute(board);
        Assertions.assertEquals(1, p2.getCapturedPieces().size());
    }

    @Test
    public void GetAlgebraicNotation() {
        Board board = createEmptyBoard('B');
        Player p1 = board.getPlayerFromChar('W');;
        Player p2 = board.getPlayerFromChar('B');;

        createAndPlacePiece("pawn", 'W', board, 0, 3);
        createAndPlacePiece("pawn", 'B', board, 1, 3);

        int[] origin = {1, 3};
        int[] dest = {0, 2};
        Move move = new EnPassantMove(origin, dest);
        Assertions.assertEquals("b4xa3", move.getAlgebraicNotation(board));
    }
}
