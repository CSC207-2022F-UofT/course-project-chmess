package Interface;

import engine.entities.Board;
import engine.entities.Game;
import engine.entities.Piece;
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

        /*Board board=game.getBoard();
        for (int y = Board.HEIGHT-1; y>=0; y--) {
            for (int x=0; x<Board.WIDTH; x++) {
                Piece piece = board.getPieceAtRelCoords(x, y);
                if (piece == null) {
                    System.out.print(".");
                } else {
                    String type = piece.getType();
                    char pieceChar;
                    switch (type) {
                        case "pawn":
                            pieceChar = 'p';
                            break;
                        case "knight":
                            pieceChar = 'n';
                            break;
                        case "bishop":
                            pieceChar = 'b';
                            break;
                        case "rook":
                            pieceChar = 'r';
                            break;
                        case "queen":
                            pieceChar = 'q';
                            break;
                        case "king":
                            pieceChar = 'k';
                            break;
                        default:
                            pieceChar = '.';
                            break;
                    }
                    if (piece.getColor() == 'W') {
                        System.out.print(Character.toUpperCase(pieceChar));
                    } else {
                        System.out.print(pieceChar);
                    }
                }
            }
            System.out.print("\n");
        }*/




        if (Objects.equals(inputtedMove, "U")) {
            MoveManager.undoLastMove(game);
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
