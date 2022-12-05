import engine.entities.Board;
import engine.entities.BoardCreator;
import engine.entities.Piece;
import engine.entities.Player;
import engine.move.Move;
import engine.movegen.RookMovesGen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class KnightMovesGenTest {
    @Test
    public void rookCantMoveInitially() {
        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        BoardCreator bc = new BoardCreator(p1, p2);
        Board board = bc.create();
        Piece[] pieceList = {board.getPieceAtAbsCoords(0, 0), board.getPieceAtAbsCoords(7, 0),
                board.getPieceAtAbsCoords(0, 7), board.getPieceAtAbsCoords(7, 7)};
        RookMovesGen mg = new RookMovesGen();
        for (Piece rook : pieceList) {
            Assertions.assertTrue(mg.generate(board, rook).isEmpty());
        }
    }

    private Board CreateEmptyBoard() {
        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        Board board = new Board();
        Player[] players = {p1, p2};
        board.setPlayers(players);
        return board;
    }
}