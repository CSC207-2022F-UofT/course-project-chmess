public class BoardCreator {
    private PieceFactory pf = new PieceFactory();
    private Player p1;
    private Player p2;

    public BoardCreator(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    private void placePiece(Board board, Piece piece, Player player, int[] c) {
        piece.setPlayer(player);
        piece.setCoords(c[0], c[1]);
        board.setPieceAtCoords(c[0], c[1], piece);
    }

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

    public Board create() {
        Board board = new Board();

        placeAllPieces(board, p1);
        placeAllPieces(board, p2);
        return board;
    }
}
