import engine.PostMoveValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import engine.move.*;
import engine.entities.*;

public class PostMoveValidatorTest extends MoveTest {
    private PostMoveValidator pmv = new PostMoveValidator();

    @Test
    public void DirectCheckIsInvalid() {
        Board board = createEmptyBoard('W');

        createAndPlacePiece("king", 'W', board, 1, 0);
        createAndPlacePiece("rook", 'B', board, 0, 7);
        Move move = new Move(new int[]{1, 0}, new int[]{0, 0});

        Assertions.assertFalse(pmv.moveIsValid(board, move));
    }
}
