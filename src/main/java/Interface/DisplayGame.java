package Interface;

import engine.entities.Game;
import engine.entities.Board;
import engine.entities.Piece;
import engine.entities.Player;

public class DisplayGame implements DisplayGameInt{
    /**
     * Displays board, game state, which player's turn it is, and
     * list of possible moves
     */
    public void display(Game game) {
        Board board = game.getBoard();
        board.selectDefaultPov();
        for (int y=0; y<Board.HEIGHT; y++) {
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
        }
        Player currentPlayer = board.getCurrentPlayer();
        if (currentPlayer.getColor()=='W') {
            System.out.println("White to move...");
        } else {
            System.out.println("Black to move...");
        }
    }
}
