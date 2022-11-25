import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import engine.CheckChecker;
import engine.entities.*;

class CheckCheckerTest {
    CheckChecker cc = new CheckChecker();
    @Test
    public void DefaultBoard() {
        Player p1 = new Player("p1", 'W');
        Player p2 = new Player("p1", 'B');
        Board board = (new BoardCreator(p1, p2)).create();
        System.out.println(board.getPieceAtAbsCoords(0, 0).getType());

        Assertions.assertFalse(cc.isPlayerInCheck(board,p1));
        Assertions.assertFalse(cc.isPlayerInCheck(board,p2));

    }

}
