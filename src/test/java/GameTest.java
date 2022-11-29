import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import engine.entities.*;

class GameTest {
    @Test
    public void GameConstructorNoBoard() {
        Game game = new Game();
        Assertions.assertNull(game.getBoard());
    }

    @Test
    public void GameBoard() {
        Game game = new Game();
        Board board = new Board();
        game.setBoard(board);
        Assertions.assertEquals(game.getBoard(), board);
    }

    @Test
    public void GamePlayers() {
        Game game = new Game();
        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        Board board = new Board();
        game.setBoard(board);
        Player[] players = {p1, p2};
        game.setPlayers(players);
        Assertions.assertEquals(game.getPlayers()[0].getName(), players[0].getName());
        Assertions.assertEquals(game.getPlayers()[0].getColor(), players[0].getColor());
        Assertions.assertEquals(game.getPlayers()[1].getName(), players[1].getName());
        Assertions.assertEquals(game.getPlayers()[1].getColor(), players[1].getColor());
    }
}
