package engine.entities;

import engine.entities.Game;
import engine.entities.Board;
import engine.entities.BoardCreator;
import engine.entities.Player;

/**
 * A creator for a new Game instance, representing
 * a chess match in which no moves have been made.
 */
public class GameCreator {
    public GameCreator() {}

    /**
     * Create a new Game instance, including a new Board instance
     * (with pieces placed according to the rules of chess by default)
     * and new Player instances.
     *
     * @param playerName1 the name of the white player
     * @param playerName2 the name of the black player
     * @return a new game
     */
    public Game create(String playerName1, String playerName2) {
        Game game = new Game();

        Player p1 = new Player(playerName1, 'W');
        Player p2 = new Player(playerName2, 'B');
        BoardCreator bc = new BoardCreator(p1, p2);
        Board board = bc.create();
        game.setBoard(board);

        return game;
    }

    public Game createImport(String playerName1, String playerName2, String boardString) {
        Game game = new Game();

        Player p1 = new Player(playerName1, 'W');
        Player p2 = new Player(playerName2, 'B');
        BoardCreator bc = new BoardCreator(p1, p2);
        bc.changeStartingPosition(boardString);
        Board board = bc.create();
        game.setBoard(board);

        return game;
    }
}
