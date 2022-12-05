package engine.move;

import engine.entities.Board;
import engine.entities.Game;
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
        // TODO
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
        // TODO
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

        return null;
    }
}
