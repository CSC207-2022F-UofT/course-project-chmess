package engine.move;

import engine.entities.Game;

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
}
