import java.util.*;
import java.io.*;

Class CLIOutput {
    public static void outputBoard (Board board, boolean symbol) {
        // Prints the board to the console
        
        Pieces pieceList = board.getPieces();
        String[][] outputBoard = new String[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (pieceCoord[0]+pieceCoord[1] % 2 == 0) {
                    outputBoard[i][j] = "■";
                } else {
                    outputBoard[i][j] = "□";
                }

            }
        }

        for (Piece piece : pieceList) {
            outputBoard[piece.getCoords()[0]][piece.getCoords()[1]] = piece.toString();
        }

        if (!symbol) {
            for (int i = 0; i < pieceList.size(); i++) {
                Piece piece = pieceList.get(i);
                System.out.println(piece.getType());
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(outputBoard[i][j]);
            }
            System.out.println();
        }
    }
    
    private static getPieceSymbol (String pieceLetter, int[] pieceCoord) {
        // Returns the symbol for the piece
        
        //TODO: Figure out of piece if white or black!!!

        switch(pieceLetter){
            case "P":
                return "♙";
            case "R":
                return "♖";
            case "N":
                return "♘";
            case "B":
                return "♗";
            case "Q":
                return "♕";
            case "K":
                return "♔";
            case "p":
                return "♟";
            case "r":
                return "♜";
            case "n":          
                return "♞";
            case "b":
                return "♝";
            case "q":
                return "♛";
            case "k":
                return "♚";
            default:
                if (pieceCoord[0]+pieceCoord[1] % 2 == 0) {
                    return "■";
                } else {
                    return "□";
                }
        }

    }
}