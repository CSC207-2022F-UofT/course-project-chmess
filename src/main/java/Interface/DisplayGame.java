package Interface;

import engine.entities.Game;
import engine.entities.Board;
import engine.entities.Piece;
import engine.entities.Player;
import engine.move.Move;

import java.util.List;
import java.util.ArrayList;

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

        Player[] players = game.getPlayers();
        Player player1 = players[0];
        Player player2 = players[1];
        
        System.out.println(player1.getColor() + ": " + player1.getName() + " " + player1.getPoints());
        System.out.println(player2.getColor() + ": " + player2.getName() + " " + player2.getPoints());
        
        Player currentPlayer = board.getCurrentPlayer();
        
        if (currentPlayer.getColor() == 'W') {
            System.out.println("White to move...");
        } else {
            System.out.println("Black to move...");
        }

        List<Move> moves = currentPlayer.generatePlayerMoves();

        System.out.println("Possible moves:");
        for (Move move : moves) {
            System.out.print(move + " ");
        }




    }
}
