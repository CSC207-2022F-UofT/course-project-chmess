package Interface;

import engine.entities.Game;
import engine.move.Move;
import engine.move.MoveManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Takes a turn.
 */
public class TurnTaker {
    public static void takeTurn(Game game) {
        if (game.getBoard() != null) {
            List<Move> moves = game.getBoard().getCurrentPlayer().generatePlayerMoves(game.getBoard());
            //List<Move> moves = game.getBoard().generatePlayerMoves(game.getBoard().getCurrentPlayer());
        }
        List<Move> moves = game.getBoard().getCurrentPlayer().generatePlayerMoves(game.getBoard());
        List<String> movesString = new ArrayList<>();
        for (Move m: moves) {


            movesString.add(m.getAlgebraicNotation(game.getBoard()));
        }
        // generate moves using method in player
        // display game by calling DisplayGameInt
        DisplayGameInt gameDisplay = new DisplayGame();
        gameDisplay.display(game, movesString);
        // input move by calling InputMoveInt
        InputMoveInt moveInput = new InputMove();
        String inputtedMove = moveInput.input(movesString,game.getBoard().hasMoved());
        if (Objects.equals(inputtedMove, "U")) {
            PlayGame.undoMove(game);
        }
        else {
            MoveManager.makeMove(game, moves.get(movesString.indexOf(inputtedMove)));
        }
        // makes move by calling makeMove in MoveManager


        //movestring must contain inputtedmove
        //MoveManager.makeMove(game, moves.get(movesString.indexOf(inputtedMove)));
        //System.out.println("Move succ");
        //MoveManager.makeMove(game, Move.getMoveFromNotation(inputtedMove));
    }
}
