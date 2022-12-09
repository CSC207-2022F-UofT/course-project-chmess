import engine.PostMoveValidator;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import engine.move.*;
import engine.movegen.*;
import engine.entities.*;

public class PostMoveValidatorTest {
    protected PieceFactory pf = new PieceFactory();
    private PostMoveValidator pmv = new PostMoveValidator();

    @Test
    public void DirectCheckIsInvalid() {
        Board board = createEmptyBoard('W');

        createAndPlacePiece("king", 'W', board, 1, 0);
        createAndPlacePiece("rook", 'B', board, 0, 7);


        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        linkPlayerAndBoard(p1,p2,board);

        Move move = new Move(new int[]{1, 0}, new int[]{0, 0});

        Assertions.assertFalse(pmv.moveIsValid(board, move));
    }

    @Test
    public void DiscoveredCheckIsInvalid() {
        Board board = createEmptyBoard('W');

        createAndPlacePiece("king", 'W', board, 0, 0);
        createAndPlacePiece("rook", 'W', board, 0, 1);
        createAndPlacePiece("rook", 'B', board, 0, 7);

        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        linkPlayerAndBoard(p1,p2,board);

        Move move = new Move(new int[]{0, 1}, new int[]{1, 1});

        Assertions.assertFalse(pmv.moveIsValid(board, move));
    }

    @Test
    public void DirectCheckToDirectCheckIsInvalid() {
        Board board = createEmptyBoard('W');

        createAndPlacePiece("king", 'W', board, 0, 0);
        createAndPlacePiece("rook", 'B', board, 7, 0);
        createAndPlacePiece("rook", 'B', board, 1, 7);


        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        linkPlayerAndBoard(p1,p2,board);

        Move move = new Move(new int[]{0, 0}, new int[]{1, 1});

        Assertions.assertFalse(pmv.moveIsValid(board, move));
    }

    @Test
    public void DirectCheckDoNothingRelevantIsInvalid() {
        Board board = createEmptyBoard('W');

        createAndPlacePiece("king", 'W', board, 0, 0);
        createAndPlacePiece("knight", 'W', board, 7, 0);
        createAndPlacePiece("rook", 'B', board, 0, 7);


        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        linkPlayerAndBoard(p1,p2,board);

        Move move = new Move(new int[]{7, 0}, new int[]{5, 1});

        Assertions.assertFalse(pmv.moveIsValid(board, move));
    }

    @Test
    public void DodgeDirectCheckValid() {
        Board board = createEmptyBoard('W');

        createAndPlacePiece("king", 'W', board, 0, 0);
        createAndPlacePiece("knight", 'B', board, 1, 2);

        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        linkPlayerAndBoard(p1,p2,board);

        Move move = new Move(new int[]{0, 0}, new int[]{1, 0});

        Assertions.assertTrue(pmv.moveIsValid(board, move));
    }

    @Test
    public void BlockDirectCheckIsValid() {
        Board board = createEmptyBoard('W');

        createAndPlacePiece("king", 'W', board, 0, 0);
        createAndPlacePiece("rook", 'W', board, 1, 1);
        createAndPlacePiece("rook", 'B', board, 0, 7);

        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        linkPlayerAndBoard(p1,p2,board);

        Move move = new Move(new int[]{1, 1}, new int[]{0, 1});

        Assertions.assertTrue(pmv.moveIsValid(board, move));
    }

    @Test
    public void CaptureDirectCheckIsValid() {
        Board board = createEmptyBoard('W');

        createAndPlacePiece("king", 'W', board, 0, 0);
        createAndPlacePiece("bishop", 'W', board, 1, 1);
        createAndPlacePiece("bishop", 'B', board, 2, 2);


        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        linkPlayerAndBoard(p1,p2,board);

        Move move = new Move(new int[]{1, 1}, new int[]{2, 2});

        Assertions.assertTrue(pmv.moveIsValid(board, move));
    }

    @Test
    public void KingCaptureDirectCheckIsValid() {
        Board board = createEmptyBoard('W');

        createAndPlacePiece("king", 'W', board, 0, 0);
        createAndPlacePiece("bishop", 'B', board, 1, 1);

        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        linkPlayerAndBoard(p1,p2,board);

        Move move = new Move(new int[]{0, 0}, new int[]{1, 1});

        Assertions.assertTrue(pmv.moveIsValid(board, move));
    }

    @Test
    public void KingInStalemateHasNoValidMove() {
        Board board = createEmptyBoard('W');

        Piece king = createAndPlacePiece("king", 'W', board, 0, 0);
        createAndPlacePiece("queen", 'B', board, 2, 1);

        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        linkPlayerAndBoard(p1,p2,board);

        MovesGenerator kg = new KingMovesGen();
        List<Move> semiValidMoves = kg.generate(board, king);
        List<Move> validMoves = pmv.getValidMoves(board, semiValidMoves);
        Assertions.assertEquals(0, validMoves.size());
    }

    protected Piece createAndPlacePiece(String type, char color, Board board, int x, int y) {
        Piece piece = pf.create(type);
        piece.setColor(color);
        board.setPieceAtAbsCoords(x, y, piece);
        piece.setCoords(x, y);


        return piece;
    }


    protected void linkPlayerAndBoard(Player p1,Player p2, Board board) {
        Player[] players = {p1, p2};
        board.setPlayers(players);

        board.getPlayers()[0].setPieces(board.getAllPiecesForColor(board.getPlayers()[0].getColor()));
        board.getPlayers()[1].setPieces(board.getAllPiecesForColor(board.getPlayers()[1].getColor()));
    }

    protected Board createEmptyBoard(char currentPlayerColor) {
        Board board = new Board();
        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        Player[] players = {p1, p2};
        board.setPlayers(players);
        if (currentPlayerColor == 'W') {
            board.setCurrentPlayer(0);
        } else {
            board.setCurrentPlayer(1);
        }

        return board;
    }
}
