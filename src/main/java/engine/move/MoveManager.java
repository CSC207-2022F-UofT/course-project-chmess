package engine.move;

import engine.MoveExecutor;
import engine.entities.Board;
import engine.entities.Game;
import engine.entities.copy.BoardCopier;
import engine.move.*;

public class MoveManager {
    public MoveManager() {}

    /**
     * Makes the given move on the given game.
     * This includes updating the board reference in Game,
     * updating players and their points and pieces captured,
     * and updating the Game state (stalemate/checkmate/neither).
     * Note: In the current implementation, players are stored only in boards.
     *
     * @param game
     * @param move
     */
    public static void makeMove(Game game, Move move) {
        // make new board
        Board oldBoard = game.getBoard();
        game.setBoard(BoardCopier.createCopy(oldBoard));
        game.getBoard().setPreviousBoard(oldBoard);
        // mutate board with move
        MoveExecutor.execute(game.getBoard(), move);
        // TODO update gamestate
        // TODO update points, pieces captured
    }

    /**
     * Undoes the last move on the given game.
     * This includes updating the board reference in Game,
     * updating players and their points and pieces captured,
     * and updating the Game state (stalemate/checkmate/neither).
     * Note: In the current implementation, players are stored only in boards.
     *
     * @param game
     */
    public static void undoLastMove(Game game) {
        game.setBoard(game.getBoard().getPreviousBoard());
        // TODO update points, pieces, gamestate?
    }

    /**
     * Converts algebraic notation to move instance and returns
     * that move instance.
     *
     * @param moveString String representing algebraic notation of move
     * @return move instance
     */
    public static Move getMoveFromNotation(Game game, String moveString) {
        // TODO
        // calls Move constructor to create new instance of move
        int[] ori = new int[2];
        int[] dest = new int[2];
        ori[0] = moveString.charAt(0);
        ori[1] = moveString.charAt(1);
        dest[0] = moveString.charAt(3);
        dest[1] = moveString.charAt(4);
        return new Move (ori, dest);
/*
        String[] pieceStrings = {"k", "q", "r", "b", "n"};
        String[] moveParams = moveString.split("");

        Board board = game.getBoard();

        if ("O-O".equals(moveString)) {
            if (board.getCurrentPlayer().getColor() == 'W') {
                CastleMove castle = new CastleMove(new int[]{4, 7}, new int[]{6, 7});
            } else {
                CastleMove castle = new CastleMove(new int[]{4, 0}, new int[]{6, 0});
            }
        } else if ("O-O-O".equals(moveString)) {
            if (board.getCurrentPlayer().getColor() == 'W') {
                CastleMove castle = new CastleMove(new int[]{4, 7}, new int[]{6, 7});
            } else {
                CastleMove castle = new CastleMove(new int[]{4, 0}, new int[]{6, 0});
            }
        } else if (moveString.contains("=")) {
            throw new java.lang.UnsupportedOperationException("Not supported yet.");
            //Move move = new PromoteMove();

        } else if (moveString.contains("x")) {
            throw new java.lang.UnsupportedOperationException("Not supported yet.");
            //Move move = new Move();

        } else {
            throw new java.lang.UnsupportedOperationException("Not supported yet.");
            //Move move = new Move();
        }

        return null; */

    }
}
