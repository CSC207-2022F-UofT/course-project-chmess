public class CLIOutput {
    public static void outputBoard (Board board, boolean symbol) {
        // Prints the board to the console
        
        Piece[][] pieceArray = board.getBoard();
        String[][] outputBoard = new String[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i + j % 2 == 0) {
                    outputBoard[i][j] = "■";
                } else {
                    outputBoard[i][j] = "□";
                }

            }
        }

        for (Piece[] pieceList : pieceArray) {
            for (Piece piece: pieceList) {
                if (piece!=null) {
                    if (symbol) {
                        outputBoard[piece.getCoords()[0]][piece.getCoords()[1]] = getPieceSymbol(piece);
                    } else {
                        outputBoard[piece.getCoords()[0]][piece.getCoords()[1]] = getPieceLetter(piece);
                    }
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(outputBoard[i][j]);
            }
            System.out.println();
        }
    }
    
    private static String getPieceSymbol (Piece piece) {
        // Returns the symbol for the piece

        if (piece.getColor() == 'w') {
            switch(piece.getType()){
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
            }
        } else {
            switch(piece.getType()){
                case "p":
                    return "♙";
                case "r":
                    return "♖";
                case "n":
                    return "♘";
                case "b":
                    return "♗";
                case "q":
                    return "♕";
                case "k":
                    return "♔";
            }
        }
        return " ";
    }
    private static String getPieceLetter (Piece piece) {
        // Returns the symbol for the piece

        if (piece.getColor() == 'w') {
            switch(piece.getType()){
                case "p":
                    return "P";
                case "r":
                    return "R";
                case "n":          
                    return "N";
                case "b":
                    return "B";
                case "q":
                    return "Q";
                case "k":
                    return "K";
            }
        } else {
            return piece.getType();
        }
        return " ";
    }
}