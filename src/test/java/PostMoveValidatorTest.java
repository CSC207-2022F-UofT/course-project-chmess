import engine.PostMoveValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import engine.move.*;
import engine.entities.*;

public class PostMoveValidatorTest {
    protected PieceFactory pf = new PieceFactory();
    private PostMoveValidator pmv = new PostMoveValidator();

    @Test
    public void DirectCheckIsInvalid() {
        Board board = createEmptyBoard('W');

        createAndPlacePiece("king", 'W', board, 1, 0);
        createAndPlacePiece("rook", 'B', board, 0, 7);
        Move move = new Move(new int[]{1, 0}, new int[]{0, 0});

        Assertions.assertFalse(pmv.moveIsValid(board, move));
    }

    @Test
    public void DiscoveredCheckIsInvalid() {
        Board board = createEmptyBoard('W');

        createAndPlacePiece("king", 'W', board, 0, 0);
        createAndPlacePiece("rook", 'W', board, 0, 1);
        createAndPlacePiece("rook", 'B', board, 0, 7);
        Move move = new Move(new int[]{0, 1}, new int[]{1, 1});

        Assertions.assertFalse(pmv.moveIsValid(board, move));
    }

    @Test
    public void DirectCheckToDirectCheckIsInvalid() {
        Board board = createEmptyBoard('W');

        createAndPlacePiece("king", 'W', board, 0, 0);
        createAndPlacePiece("rook", 'B', board, 7, 0);
        createAndPlacePiece("rook", 'B', board, 1, 7);
        Move move = new Move(new int[]{0, 0}, new int[]{1, 1});

        Assertions.assertFalse(pmv.moveIsValid(board, move));
    }

    @Test
    public void DodgeDirectCheckValid() {
        Board board = createEmptyBoard('W');

        createAndPlacePiece("king", 'W', board, 0, 0);
        createAndPlacePiece("knight", 'B', board, 1, 2);
        Move move = new Move(new int[]{0, 0}, new int[]{1, 0});

        Assertions.assertTrue(pmv.moveIsValid(board, move));
    }

    @Test
    public void BlockDirectCheckIsValid() {
        Board board = createEmptyBoard('W');

        createAndPlacePiece("king", 'W', board, 0, 0);
        createAndPlacePiece("rook", 'W', board, 1, 1);
        createAndPlacePiece("rook", 'B', board, 0, 7);
        Move move = new Move(new int[]{1, 1}, new int[]{0, 1});

        Assertions.assertTrue(pmv.moveIsValid(board, move));
    }

    @Test
    public void CaptureDirectCheckIsValid() {
        Board board = createEmptyBoard('W');

        createAndPlacePiece("king", 'W', board, 0, 0);
        createAndPlacePiece("bishop", 'W', board, 1, 1);
        createAndPlacePiece("bishop", 'B', board, 2, 2);
        Move move = new Move(new int[]{1, 1}, new int[]{2, 2});

        Assertions.assertTrue(pmv.moveIsValid(board, move));
    }

    @Test
    public void KingCaptureDirectCheckIsValid() {
        Board board = createEmptyBoard('W');

        createAndPlacePiece("king", 'W', board, 0, 0);
        createAndPlacePiece("bishop", 'B', board, 1, 1);
        Move move = new Move(new int[]{0, 0}, new int[]{1, 1});

        Assertions.assertTrue(pmv.moveIsValid(board, move));
    }

    protected Piece createAndPlacePiece(String type, char color, Board board, int x, int y) {
        Piece piece = pf.create(type);
        piece.setColor(color);
        board.setPieceAtAbsCoords(x, y, piece);
        piece.setCoords(x, y);
        return piece;
    }

    protected Board createEmptyBoard(char currentPlayerColor) {
        Board board = new Board();
        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        Player[] players = {p1, p2};
        board.setPlayers(players);
        if (currentPlayerColor == 'W') {
            board.setCurrentPlayer(p1);
        } else {
            board.setCurrentPlayer(p2);
        }

        return board;
    }
}