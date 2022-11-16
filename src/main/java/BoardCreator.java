public class BoardCreator {
    private final int WIDTH = 8;
    private final int HEIGHT = 8;
    private final PieceFactory pf = new PieceFactory();
    private final Player p1;
    private final Player p2;
    private final String boardString =
            "RNBQKBNR"
            + "PPPPPPPP"
            + "........"
            + "........"
            + "........"
            + "........"
            + "pppppppp"
            + "rnbqkbnr";

    public BoardCreator(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    /**
     * Gets the long-form piece type from a char shorthand,
     * according to algebraic notation, e.g., 'p' and 'P' correspond to "pawn".
     * Returns null if the given char has no corresponding type.
     *
     * @param c the char shorthand for a piece type
     */
    private String getTypeFromChar(char c) {
        switch (Character.toLowerCase(c)) {
            case 'p':
                return "pawn";
            case 'n':
                return "knight";
            case 'b':
                return "bishop";
            case 'r':
                return "rook";
            case 'q':
                return "queen";
            case 'k':
                return "king";
            default:
                return null;
        }
    }

    /**
     * Creates a Piece object of appropriate type and Player,
     * given its character representation it.
     *
     * @param c the character representation of the piece
     */
    private Piece createPieceFromChar(char c) {
        String type = getTypeFromChar(c);
        Player player;

        if (Character.isUpperCase(c)) {
            player = p1;
        } else {
            player = p2;
        }

        Piece piece = pf.create(type);
        piece.setPlayer(player);
        return piece;
    }

    /**
     * Places a Piece object on the Board, setting its Player and coordinates.
     * Also put the Piece object in the Board object.
     * (This method mutates the given Board and Piece objects.)
     *
     * @param board  the board
     * @param piece   the piece to be placed
     * @param x      the x-coordinate at which to place the piece
     * @param y      the y-coordinate at which to place the piece
     */
    private void placePiece(Board board, Piece piece, int x, int y) {
        piece.setCoords(x, y);
        board.setPieceAtAbsCoords(x, y, piece);
    }

    /**
     * Places a Piece object on the Board, setting its Player and coordinates.
     * Also put the Piece object in the Board object.
     * (This method mutates the given Board and Piece objects.)
     */
    private char[][] getCharArrayFromGridString(String gridString, int width, int height) {
        char[][] charArray = new char[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int index = y * width + x;
                charArray[x][y] = gridString.charAt(index);
            }
        }
        return charArray;
    }

    /**
     * Places all pieces on the board, according to layout in usual chess.
     *
     * @param board the board on which to place the pieces
     */
    private void placeAllPieces(Board board) {
        char[][] charArray = getCharArrayFromGridString(boardString, WIDTH, HEIGHT);
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                char c = charArray[x][y];
                if (getTypeFromChar(c) != null) {
                    Piece piece = createPieceFromChar(c);
                    placePiece(board, piece, x, y);
                }
            }
        }
    }

    /**
     * Creates a new Board instance, on which no moves have been made.
     * Pieces will be pre-placed according to the usual rules of chess.
     *
     * @return a new board
     */
    public Board create() {
        Board board = new Board();
        placeAllPieces(board);
        return board;
    }
}
