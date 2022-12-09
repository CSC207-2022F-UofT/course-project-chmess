import engine.entities.Board;
import engine.entities.BoardCreator;
import engine.entities.Piece;
import engine.entities.Player;
import engine.move.Move;
import engine.movegen.BishopMovesGen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BishopMovesGenTest {
    @Test
    public void bishopCantMoveInitially() {
        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        BoardCreator bc = new BoardCreator(p1, p2);
        Board board = bc.create();
        Piece[] pieceList = {board.getPieceAtAbsCoords(2, 0), board.getPieceAtAbsCoords(5, 0),
                board.getPieceAtAbsCoords(2, 7), board.getPieceAtAbsCoords(5, 7)};
        BishopMovesGen mg = new BishopMovesGen();
        for(Piece bishop : pieceList){
            Assertions.assertTrue(mg.generate(board, bishop).isEmpty());
        }
    }
    @Test
    public void bishopBottomLeftCornerEmptyBoard() {
        Board board = createEmptyBoard();
        Piece bishop = new Piece();
        bishop.setColor(board.getPlayers()[0].getColor());
        board.setPieceAtAbsCoords(0, 0, bishop);

        BishopMovesGen mg = new BishopMovesGen();
        List<Move> moves = mg.generate(board, bishop);
        List<int[]> destCoords = new ArrayList<int[]>();
        for(Move move : moves){
            destCoords.add(move.destination);
        }
        int[][] expectedCoords = {{1,1}, {2,2}, {3,3}, {4,4}, {5,5}, {6,6}, {7,7}};
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
    public void bishopTopLeftCornerEmptyBoard() {
        Board board = createEmptyBoard();
        Piece bishop = new Piece();
        bishop.setColor(board.getPlayers()[0].getColor());
        board.setPieceAtAbsCoords(0, 7, bishop);

        BishopMovesGen mg = new BishopMovesGen();
        List<Move> moves = mg.generate(board, bishop);
        List<int[]> destCoords = new ArrayList<int[]>();
        for(Move move : moves){
            destCoords.add(move.destination);
        }
        int[][] expectedCoords = {{1,6}, {2,5}, {3,4}, {4,3}, {5,2}, {6,1}, {7,0}};

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
    public void bishopTopRightCornerEmptyBoard() {
        Board board = createEmptyBoard();
        Piece bishop = new Piece();
        bishop.setColor(board.getPlayers()[0].getColor());
        board.setPieceAtAbsCoords(7, 7, bishop);

        BishopMovesGen mg = new BishopMovesGen();
        List<Move> moves = mg.generate(board, bishop);
        List<int[]> destCoords = new ArrayList<int[]>();
        for(Move move : moves){
            destCoords.add(move.destination);
        }
        int[][] expectedCoords = {{6,6}, {5,5}, {4,4}, {3,3}, {2,2}, {1,1}, {0,0}};

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
    public void bishopBottomRightCornerEmptyBoard() {
        Board board = createEmptyBoard();
        Piece bishop = new Piece();
        bishop.setColor(board.getPlayers()[0].getColor());
        board.setPieceAtAbsCoords(7, 0, bishop);

        BishopMovesGen mg = new BishopMovesGen();
        List<Move> moves = mg.generate(board, bishop);
        List<int[]> destCoords = new ArrayList<int[]>();
        for(Move move : moves){
            destCoords.add(move.destination);
        }
        int[][] expectedCoords = {{6,1}, {5,2}, {4,3}, {3,4}, {2,5}, {1,6}, {0,7}};

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
    public void bishopNearBottomLeftCornerEnemyBlockingTopRight() {
        Board board = createEmptyBoard();
        Piece bishop = new Piece();
        bishop.setColor(board.getPlayers()[0].getColor());
        board.setPieceAtAbsCoords(1, 1, bishop);

        Piece blocker = new Piece();
        blocker.setColor(board.getPlayers()[1].getColor());
        board.setPieceAtAbsCoords(2, 2, blocker);

        BishopMovesGen mg = new BishopMovesGen();
        List<Move> moves = mg.generate(board, bishop);
        List<int[]> destCoords = new ArrayList<int[]>();
        for(Move move : moves){
            destCoords.add(move.destination);
        }
        int[][] expectedCoords = {{0,2}, {0,0}, {2,0}, {2,2}};

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
    public void bishopNearTopRightCornerFriendlyBlockingBottomLeft() {
        Board board = createEmptyBoard();
        Piece bishop = new Piece();
        bishop.setColor(board.getPlayers()[0].getColor());
        board.setPieceAtAbsCoords(6, 6, bishop);

        Piece blocker = new Piece();
        blocker.setColor(board.getPlayers()[0].getColor());
        board.setPieceAtAbsCoords(5, 5, blocker);

        BishopMovesGen mg = new BishopMovesGen();
        List<Move> moves = mg.generate(board, bishop);
        List<int[]> destCoords = new ArrayList<int[]>();
        for(Move move : moves){
            destCoords.add(move.destination);
        }
        int[][] expectedCoords = {{5,7}, {7,7}, {7,5}};

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
    public void bishopRandomMiddleNoBlockers() {
        Board board = createEmptyBoard();
        Piece bishop = new Piece();
        bishop.setColor(board.getPlayers()[1].getColor());
        board.setPieceAtAbsCoords(3, 4, bishop);

        BishopMovesGen mg = new BishopMovesGen();
        List<Move> moves = mg.generate(board, bishop);
        List<int[]> destCoords = new ArrayList<int[]>();
        for(Move move : moves){
            destCoords.add(move.destination);
        }
        int[][] expectedCoords = {{2,5}, {1,6}, {0,7}, {4,5}, {5,6}, {6,7}, {4,3}, {5,2}, {6,1}, {7,0},
                {2,3}, {1,2}, {0,1}};

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

    private Board createEmptyBoard() {
        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        Board board = new Board();
        Player[] players = {p1, p2};
        board.setPlayers(players);
        return board;
    }

}
