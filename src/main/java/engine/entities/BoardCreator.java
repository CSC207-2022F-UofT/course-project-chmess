package engine.entities;


/**
 * A creator for the "typical" Board instance.
 * The created Board object will have new pieces placed
 * according to the standard chess layout, where no moves have been made.
 * Each BoardCreator instance is intended to be used once.
 */
public class BoardCreator {
    private final PieceFactory pf = new PieceFactory();
    private final Player p1;
    private final Player p2;
    // Board.getPieceAtAbsCoords(0,0) is the bottom-left square a1
    private String boardString =
            "RNBQKBNR"
            + "PPPPPPPP"
            + "........"
            + "........"
            + "........"
            + "........"
            + "pppppppp"
            + "rnbqkbnr";

    /**
     * Creates a new BoardCreator object.
     * With the parameters identify which player objects
     * should be used when creating a board.
     *
     * @param p1 the player object representing white
     * @param p2 the player object representing black
     */
    public BoardCreator(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    /**
     * Changes default starting position to board
     * as represented in startingPosition.
     *
     * @param startingPosition List of strings where each string represents one row of the board
     */
    public void changeStartingPosition(String startingPosition) {
        this.boardString = startingPosition;
    }

    /**
     * Gets the long-form piece type from a char shorthand,
     * according to algebraic notation, e.g., 'p' and 'P' correspond to "pawn".
     * Returns null if the given char has no corresponding type.
     *
     * @param c the char shorthand for a piece type
     * @return the piece type the char represents
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
     * @return a new Piece instance corresponding to the char
     */
    private Piece createPieceFromChar(char c) {
        String type = getTypeFromChar(c);
        char color;

        if (Character.isUpperCase(c)) {
            color = 'W';
        } else {
            color = 'B';
        }

        Piece piece = pf.create(type);
        piece.setColor(color);
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
     * Places all pieces on the board, according to layout in usual chess.
     *
     * @param board the board on which to place the pieces
     */
    private void placeAllPieces(Board board) {
        int width = board.WIDTH;
        int height = board.HEIGHT;
        // Iterate over the boardString, while imbuing it with 2D coords
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int index = y * width + x;
                char c = boardString.charAt(index);
                // If a char has no corresponding type, ignore it
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

        p1.setPieces(board.getAllPiecesForColor(p1.getColor()));
        p2.setPieces(board.getAllPiecesForColor(p2.getColor()));

        board.setPlayers(new Player[]{p1, p2});
        board.setCurrentPlayer(p1);
        return board;
    }
}
