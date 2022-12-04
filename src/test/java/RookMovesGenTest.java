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

class RookMovesGenTest {
    @Test
    public void rookCantMoveInitially() {
        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        BoardCreator bc = new BoardCreator(p1, p2);
        Board board = bc.create();
        Piece[] pieceList = {board.getPieceAtAbsCoords(0, 0), board.getPieceAtAbsCoords(7, 0),
                board.getPieceAtAbsCoords(0, 7), board.getPieceAtAbsCoords(7, 7)};
        RookMovesGen mg = new RookMovesGen();
        for(Piece rook : pieceList){
            Assertions.assertTrue(mg.generate(board, rook).isEmpty());
        }
    }
    @Test
    public void rookBottomLeftCornerEmptyBoard() {
        Board board = CreateEmptyBoard();
        Piece rook = new Piece();
        rook.setColor(board.getPlayers()[0].getColor());
        board.setPieceAtAbsCoords(0, 0, rook);

        RookMovesGen mg = new RookMovesGen();
        List<Move> moves = mg.generate(board, rook);
        List<int[]> destCoords = new ArrayList<int[]>();
        for(Move move : moves){
            destCoords.add(move.destination);
        }
        int[][] expectedCoords = {{0,1}, {0,2}, {0,3}, {0,4}, {0,5}, {0,6}, {0,7},
                {1,0}, {2,0}, {3,0}, {4,0}, {5,0}, {6,0}, {7,0}};
        //Check that every generated destination exists in the expected destinations
        for(int[] dest : destCoords) {
            boolean isMatch = false;
            for (int[] expected : expectedCoords) {
                isMatch = Arrays.equals(dest, expected);
                if (isMatch) break;
            }
            Assertions.assertTrue(isMatch);
        }
        //Check that every expected destination exists in the generated destinations
        for(int[] expected : expectedCoords) {
            boolean isMatch = false;
            for (int[] dest : destCoords) {
                isMatch = Arrays.equals(dest, expected);
                if (isMatch) break;
            }
            Assertions.assertTrue(isMatch);
        }
    }
    @Test
    public void rookTopLeftCornerEmptyBoard() {
        Board board = CreateEmptyBoard();
        Piece rook = new Piece();
        rook.setColor(board.getPlayers()[0].getColor());
        board.setPieceAtAbsCoords(0, 7, rook);

        RookMovesGen mg = new RookMovesGen();
        List<Move> moves = mg.generate(board, rook);
        List<int[]> destCoords = new ArrayList<int[]>();
        for(Move move : moves){
            destCoords.add(move.destination);
        }
        int[][] expectedCoords = {{0,6}, {0,5}, {0,4}, {0,3}, {0,2}, {0,1}, {0,0},
                {1,7}, {2,7}, {3,7}, {4,7}, {5,7}, {6,7}, {7,7}};

        //Check that every generated destination exists in the expected destinations
        for(int[] dest : destCoords) {
            boolean isMatch = false;
            for (int[] expected : expectedCoords) {
                isMatch = Arrays.equals(dest, expected);
                if (isMatch) break;
            }
            Assertions.assertTrue(isMatch);
        }
        //Check that every expected destination exists in the generated destinations
        for(int[] expected : expectedCoords) {
            boolean isMatch = false;
            for (int[] dest : destCoords) {
                isMatch = Arrays.equals(dest, expected);
                if (isMatch) break;
            }
            Assertions.assertTrue(isMatch);
        }
    }
    @Test
    public void rookTopRightCornerEmptyBoard() {
        Board board = CreateEmptyBoard();
        Piece rook = new Piece();
        rook.setColor(board.getPlayers()[0].getColor());
        board.setPieceAtAbsCoords(7, 7, rook);

        RookMovesGen mg = new RookMovesGen();
        List<Move> moves = mg.generate(board, rook);
        List<int[]> destCoords = new ArrayList<int[]>();
        for(Move move : moves){
            destCoords.add(move.destination);
        }
        int[][] expectedCoords = {{7,6}, {7,5}, {7,4}, {7,3}, {7,2}, {7,1}, {7,0},
                {6,7}, {5,7}, {4,7}, {3,7}, {2,7}, {1,7}, {0,7}};

        //Check that every generated destination exists in the expected destinations
        for(int[] dest : destCoords) {
            boolean isMatch = false;
            for (int[] expected : expectedCoords) {
                isMatch = Arrays.equals(dest, expected);
                if (isMatch) break;
            }
            Assertions.assertTrue(isMatch);
        }
        //Check that every expected destination exists in the generated destinations
        for(int[] expected : expectedCoords) {
            boolean isMatch = false;
            for (int[] dest : destCoords) {
                isMatch = Arrays.equals(dest, expected);
                if (isMatch) break;
            }
            Assertions.assertTrue(isMatch);
        }
    }
    @Test
    public void rookBottomRightCornerEmptyBoard() {
        Board board = CreateEmptyBoard();
        Piece rook = new Piece();
        rook.setColor(board.getPlayers()[0].getColor());
        board.setPieceAtAbsCoords(7, 0, rook);

        RookMovesGen mg = new RookMovesGen();
        List<Move> moves = mg.generate(board, rook);
        List<int[]> destCoords = new ArrayList<int[]>();
        for(Move move : moves){
            destCoords.add(move.destination);
        }
        int[][] expectedCoords = {{6,0}, {5,0}, {4,0}, {3,0}, {2,0}, {1,0}, {0,0},
                {7,1}, {7,2}, {7,3}, {7,4}, {7,5}, {7,6}, {7,7}};

        //Check that every generated destination exists in the expected destinations
        for(int[] dest : destCoords) {
            boolean isMatch = false;
            for (int[] expected : expectedCoords) {
                isMatch = Arrays.equals(dest, expected);
                if (isMatch) break;
            }
            Assertions.assertTrue(isMatch);
        }
        //Check that every expected destination exists in the generated destinations
        for(int[] expected : expectedCoords) {
            boolean isMatch = false;
            for (int[] dest : destCoords) {
                isMatch = Arrays.equals(dest, expected);
                if (isMatch) break;
            }
            Assertions.assertTrue(isMatch);
        }
    }
    @Test
    public void rookNearTopLeftCornerEnemyBlockingRight() {
        Board board = CreateEmptyBoard();
        Piece rook = new Piece();
        rook.setColor(board.getPlayers()[0].getColor());
        board.setPieceAtAbsCoords(1, 6, rook);

        Piece blocker = new Piece();
        blocker.setColor(board.getPlayers()[1].getColor());
        board.setPieceAtAbsCoords(2, 6, blocker);

        RookMovesGen mg = new RookMovesGen();
        List<Move> moves = mg.generate(board, rook);
        List<int[]> destCoords = new ArrayList<int[]>();
        for(Move move : moves){
            destCoords.add(move.destination);
        }
        int[][] expectedCoords = {{2, 6}, {0, 6}, {1, 7}, {1, 5}, {1, 4}, {1, 3}, {1, 2}, {1, 1}, {1, 0}};

        //Check that every generated destination exists in the expected destinations
        for(int[] dest : destCoords) {
            boolean isMatch = false;
            for (int[] expected : expectedCoords) {
                isMatch = Arrays.equals(dest, expected);
                if (isMatch) break;
            }
            Assertions.assertTrue(isMatch);
        }
        //Check that every expected destination exists in the generated destinations
        for(int[] expected : expectedCoords) {
            boolean isMatch = false;
            for (int[] dest : destCoords) {
                isMatch = Arrays.equals(dest, expected);
                if (isMatch) break;
            }
            Assertions.assertTrue(isMatch);
        }
    }
    @Test
    public void rookNearBottomRightCornerFriendlyBlockingBottomAndLeft() {
        Board board = CreateEmptyBoard();
        Piece rook = new Piece();
        rook.setColor(board.getPlayers()[0].getColor());
        board.setPieceAtAbsCoords(6, 1, rook);

        Piece blocker1 = new Piece();
        blocker1.setColor(board.getPlayers()[0].getColor());
        board.setPieceAtAbsCoords(6, 0, blocker1);

        Piece blocker2 = new Piece();
        blocker2.setColor(board.getPlayers()[0].getColor());
        board.setPieceAtAbsCoords(5, 1, blocker2);

        RookMovesGen mg = new RookMovesGen();
        List<Move> moves = mg.generate(board, rook);
        List<int[]> destCoords = new ArrayList<int[]>();
        for(Move move : moves){
            destCoords.add(move.destination);
        }
        int[][] expectedCoords = {{7,1}, {6,2}, {6,3}, {6, 4}, {6, 5}, {6, 6}, {6, 7}};

        //Check that every generated destination exists in the expected destinations
        for(int[] dest : destCoords) {
            boolean isMatch = false;
            for (int[] expected : expectedCoords) {
                isMatch = Arrays.equals(dest, expected);
                if (isMatch) break;
            }
            Assertions.assertTrue(isMatch);
        }
        //Check that every expected destination exists in the generated destinations
        for(int[] expected : expectedCoords) {
            boolean isMatch = false;
            for (int[] dest : destCoords) {
                isMatch = Arrays.equals(dest, expected);
                if (isMatch) break;
            }
            Assertions.assertTrue(isMatch);
        }
    }
    @Test
    public void rookRandomMiddleNoBlockers() {
        Board board = CreateEmptyBoard();
        Piece rook = new Piece();
        rook.setColor(board.getPlayers()[1].getColor());
        board.setPieceAtAbsCoords(4, 3, rook);

        RookMovesGen mg = new RookMovesGen();
        List<Move> moves = mg.generate(board, rook);
        List<int[]> destCoords = new ArrayList<int[]>();
        for(Move move : moves){
            destCoords.add(move.destination);
        }
        int[][] expectedCoords = {{3, 3}, {2, 3}, {1, 3}, {0, 3}, {4, 4}, {4, 5}, {4, 6}, {4, 7}, {4, 2}, {4, 1},
                {4, 0}, {5, 3}, {6, 3}, {7, 3}};

        //Check that every generated destination exists in the expected destinations
        for(int[] dest : destCoords) {
            boolean isMatch = false;
            for (int[] expected : expectedCoords) {
                isMatch = Arrays.equals(dest, expected);
                if (isMatch) break;
            }
            Assertions.assertTrue(isMatch);
        }
        //Check that every expected destination exists in the generated destinations
        for(int[] expected : expectedCoords) {
            boolean isMatch = false;
            for (int[] dest : destCoords) {
                isMatch = Arrays.equals(dest, expected);
                if (isMatch) break;
            }
            Assertions.assertTrue(isMatch);
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
