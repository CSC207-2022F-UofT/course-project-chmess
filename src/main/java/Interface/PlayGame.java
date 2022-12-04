package Interface;

import engine.entities.Game;
import engine.entities.Player;
import engine.move.MoveManager;

/**
 * Plays the current game. Calls TurnTaker to have users take turns
 * and checks win condition variable in Game to check if game is over, after
 * every TurnTaker call. If game has ended calls EndScreen.
 */
public class PlayGame {
    Player curPlayer;
    public static void play(Game game) {
        while (game.getGameState() != '$' && game.getGameState() != '#') {
            TurnTaker.takeTurn(game);
            }
        DisplayEndInt dis = new DisplayEnd();
        dis.display(game.getBoard().getCurrentPlayer().name, game.getGameState());
        }
    /**
     * Reverts game to before the latest move was made.
     */
    public static void undoMove(Game game) {
        MoveManager.undoLastMove(game);
        PlayGame.play(game);
    }
}
