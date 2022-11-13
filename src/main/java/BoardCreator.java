public class BoardCreator {
    private PieceFactory pf = new PieceFactory();
    private Player p1;
    private Player p2;

    public BoardCreator(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    /**
     * Place a Piece object on the Board, setting its Player and coordinates.
     * Also put the Piece object in the Board object.
     * The Piece should not already be on the Board.
     * (This method mutates the supplied Board and Piece objects.)
     *
     * @param board  the board
     * @param piece  the piece to be placed on the board
     * @param player the player to which the piece belongs
     * @param c      the coordinates at which to place the piece
     */
    private void placePiece(Board board, Piece piece, Player player, int[] c) {
        piece.setPlayer(player);
        piece.setCoords(c[0], c[1]);
        board.setPieceAtCoords(c[0], c[1], piece);
    }

    /**
     * Convert relative coordinates for a given player
     * to absolute coordinates on the board.
     * For the "first" player, this equals the supplied coordinates.
     * For the "second" player, this equals the supplied coordinates
     * with the y-coordinate flipped.
     *
     * @param x      the board
     * @param y      the piece to be placed on the board
     * @param player the player to which the piece belongs
     * @return       the absolute board coordinates
     */
    private int[] getCoordsPlayerAware(int x, int y, Player player) {
        int[] coords = new int[2];
        coords[0] = x;
        if (player == p1)
            coords[1] = y;
        else
            coords[1] = 7 - y;
        return coords;
    }

    private void placePawns(Board board, Player player) {
        for (int i = 0; i < 8; i++) {
            int[] coords = getCoordsPlayerAware(i, 1, player);
            Piece pawn = pf.create("pawn");
            placePiece(board, pawn, player, coords);
        }
    }

    private void placeAllPieces(Board board, Player player) {
        this.placePawns(board, player);
    }

    /**
     * Create a new Board instance, on which no moves have been made.
     * Pieces will be pre-placed according to the usual rules of chess.
     *
     * @return a new board
     */
    public Board create() {
        Board board = new Board();

        placeAllPieces(board, p1);
        placeAllPieces(board, p2);
        return board;
    }
}
