import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {
    @Test
    public void GameConstructor() {
        Game game = new Game();
        Assertions.assertEquals(game.getBoard(), null);
        Assertions.assertEquals(game.getPlayers(), null);
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
        Player p1 = new Player();
        Player p2 = new Player();
        Player[] players = {p1, p2};
        game.setPlayers(players);
        Assertions.assertEquals(game.getPlayers()[0], players[0]);
        Assertions.assertEquals(game.getPlayers()[1], players[1]);
    }
}