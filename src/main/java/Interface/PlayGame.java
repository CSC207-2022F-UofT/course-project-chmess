package Interface;

import engine.entities.Game;
import engine.entities.Player;

/**
 * Plays the current game. Calls TurnTaker to have users take turns
 * and checks win condition variable in Game to check if game is over, after
 * every TurnTaker call. If game has ended calls EndScreen.
 */
public class PlayGame {
    Player curPlayer;
    public static void play(Game game) {
        // calls TurnTaker until game.gamestate is either $ or #
        // calls EndScreen
        // TODO
    }
    /**
     * Reverts game to before the latest move was made.
     */
    public void undoMove() {
        // TODO
    }
}
