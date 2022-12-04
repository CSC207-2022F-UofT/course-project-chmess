package engine.move;

import engine.entities.Board;
import engine.entities.Game;
import engine.move.*;

class MoveManager {
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
    public void makeMove(Game game, Move move) {
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
    public void undoLastMove(Game game) {
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
        // AHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH
        // HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH
        // HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH
        // HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH

        if ("O-O".equals(moveString)) {
            if (board.getCurrentPlayer().getColor() == 'W') {
                CastleMove castle = new CastleMove({4, 7} , {6, 7});
            } else {
                CastleMove castle = new CastleMove({4, 0}, {6, 0});
            }
        } else if ("O-O-O".equals(moveString)) {
            if (board.getCurrentPlayer().getColor() == 'W') {
                CastleMove castle = new CastleMove({4, 7} , {6, 7});
            } else {
                CastleMove castle = new CastleMove({4, 0}, {6, 0});
            }
        } else if (moveString.contains("=")) {
            Move move = new PromotionMove();

        } else if (moveString.contains("x")) {
            Move move = new Move();

        } else {
            Move move = new Move();
        }

        return null;
    }
}
