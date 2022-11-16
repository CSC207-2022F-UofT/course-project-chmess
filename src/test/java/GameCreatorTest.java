import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameCreatorTest {
    @Test
    public void GameHasBoard() {
        GameCreator gc = new GameCreator();
        Game game = gc.create();
        Assertions.assertNotNull(game.getBoard());
    }
}
