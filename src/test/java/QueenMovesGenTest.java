import engine.entities.Board;
import engine.entities.BoardCreator;
import engine.entities.Piece;
import engine.entities.Player;
import engine.move.Move;
import engine.movegen.QueenMovesGen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class QueenMovesGenTest {
    @Test
    public void queenCantMoveInitially() {
        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        BoardCreator bc = new BoardCreator(p1, p2);
        Board board = bc.create();
        Piece[] pieceList = {board.getPieceAtAbsCoords(3, 7), board.getPieceAtAbsCoords(3, 0)};
        QueenMovesGen mg = new QueenMovesGen();
        for(Piece rook : pieceList){
            Assertions.assertTrue(mg.generate(board, rook).isEmpty());
        }
    }
    @Test
    public void queenBottomRightCornerEmptyBoard() {
        Board board = createEmptyBoard();
        Piece queen = new Piece();
        queen.setColor(board.getPlayers()[0].getColor());
        board.setPieceAtAbsCoords(7, 0, queen);

        QueenMovesGen mg = new QueenMovesGen();
        List<Move> moves = mg.generate(board, queen);
        List<int[]> destCoords = new ArrayList<int[]>();
        for(Move move : moves){
            destCoords.add(move.destination);
        }
        int[][] expectedCoords = {{6, 0}, {5, 0}, {4, 0}, {3, 0}, {2, 0}, {1, 0}, {0, 0},
                {7, 1}, {7, 2}, {7, 3}, {7, 4}, {7, 5}, {7, 6}, {7, 7},
                {6, 1}, {5, 2}, {4, 3}, {3, 4}, {2, 5}, {1, 6}, {0, 7}};
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
    public void queenBottomLeftCornerEmptyBoard() {
        Board board = createEmptyBoard();
        Piece queen = new Piece();
        queen.setColor(board.getPlayers()[0].getColor());
        board.setPieceAtAbsCoords(0, 0, queen);

        QueenMovesGen mg = new QueenMovesGen();
        List<Move> moves = mg.generate(board, queen);
        List<int[]> destCoords = new ArrayList<int[]>();
        for(Move move : moves){
            destCoords.add(move.destination);
        }
        int[][] expectedCoords = {{7, 0}, {6, 0}, {5, 0}, {4, 0}, {3, 0}, {2, 0}, {1, 0},
                {0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}, {0, 6}, {0, 7},
                {1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}, {6, 6}, {7, 7}};

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
    public void queenTopLeftCornerEmptyBoard() {
        Board board = createEmptyBoard();
        Piece queen = new Piece();
        queen.setColor(board.getPlayers()[0].getColor());
        board.setPieceAtAbsCoords(0, 7, queen);

        QueenMovesGen mg = new QueenMovesGen();
        List<Move> moves = mg.generate(board, queen);
        List<int[]> destCoords = new ArrayList<int[]>();
        for(Move move : moves){
            destCoords.add(move.destination);
        }
        int[][] expectedCoords = {{7, 0}, {6, 1}, {5, 2}, {4, 3}, {3, 4}, {2, 5}, {1, 6},
                {1, 7}, {2, 7}, {3, 7}, {4, 7}, {5, 7}, {6, 7}, {7, 7},
                {0, 0}, {0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}, {0, 6}};

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
    public void queenTopRightCornerEmptyBoard() {
        Board board = createEmptyBoard();
        Piece queen = new Piece();
        queen.setColor(board.getPlayers()[0].getColor());
        board.setPieceAtAbsCoords(7, 7, queen);

        QueenMovesGen mg = new QueenMovesGen();
        List<Move> moves = mg.generate(board, queen);
        List<int[]> destCoords = new ArrayList<int[]>();
        for(Move move : moves){
            destCoords.add(move.destination);
        }
        int[][] expectedCoords = {{6,7}, {5,7}, {4,7}, {3,7}, {2,7}, {1,7}, {0,7},
                {7,0}, {7,1}, {7,2}, {7,3}, {7,4}, {7,5}, {7,6},
                {6, 6}, {5, 5}, {4, 4}, {3, 3}, {2, 2}, {1, 1}, {0, 0}};

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
    public void queenNearMidLeftSideEnemiesBlockingCompleteRightSide() {
        Board board = createEmptyBoard();
        Piece queen = new Piece();
        queen.setColor(board.getPlayers()[0].getColor());
        board.setPieceAtAbsCoords(1, 3, queen);

        Piece blocker1 = new Piece();
        blocker1.setColor(board.getPlayers()[1].getColor());
        board.setPieceAtAbsCoords(2, 4, blocker1);

        Piece blocker2 = new Piece();
        blocker2.setColor(board.getPlayers()[1].getColor());
        board.setPieceAtAbsCoords(2, 3, blocker2);

        Piece blocker3 = new Piece();
        blocker3.setColor(board.getPlayers()[1].getColor());
        board.setPieceAtAbsCoords(2, 2, blocker3);

        QueenMovesGen mg = new QueenMovesGen();
        List<Move> moves = mg.generate(board, queen);
        List<int[]> destCoords = new ArrayList<int[]>();
        for(Move move : moves){
            destCoords.add(move.destination);
        }
        int[][] expectedCoords = {{2, 4}, {2, 3}, {2, 2},
                {1, 2}, {1, 1}, {1, 0},
                {0, 2}, {0, 3}, {0, 4},
                {1, 4}, {1, 5}, {1, 6}, {1, 7}};

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
    public void queenNearBottomRightCornerFriendlyBlockingBottomAndRight() {
        Board board = createEmptyBoard();
        Piece queen = new Piece();
        queen.setColor(board.getPlayers()[0].getColor());
        board.setPieceAtAbsCoords(5, 2, queen);

        Piece blocker1 = new Piece();
        blocker1.setColor(board.getPlayers()[0].getColor());
        board.setPieceAtAbsCoords(6, 2, blocker1);

        Piece blocker2 = new Piece();
        blocker2.setColor(board.getPlayers()[0].getColor());
        board.setPieceAtAbsCoords(5, 1, blocker2);

        QueenMovesGen mg = new QueenMovesGen();
        List<Move> moves = mg.generate(board, queen);
        List<int[]> destCoords = new ArrayList<int[]>();
        for(Move move : moves){
            destCoords.add(move.destination);
        }
        int[][] expectedCoords = {{5, 3}, {5, 4}, {5, 5}, {5, 6}, {5, 7},
                {4, 3}, {3, 4}, {2, 5}, {1, 6}, {0, 7},
                {4, 2}, {3, 2}, {2, 2}, {1, 2}, {0, 2},
                {4, 1}, {3, 0},
                {6, 1}, {7, 0},
                {6, 3}, {7, 4}};

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
