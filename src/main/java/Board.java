public class Board {
    private int WIDTH = 8;
    private int HEIGHT = 8;
    private Piece[][] board;
    private Piece[][] mirror;
    private Piece[][] relativeBoard;
    private Player[] players;

    public Board() {
        board = new Piece[HEIGHT][WIDTH];
        mirror = new Piece[HEIGHT][];
        for (int i = 0; i < HEIGHT; i++) {
            mirror[HEIGHT - 1 - i] = board[i];
        }
        relativeBoard = board;
    }

    /**
     * Returns a deep clone of this Board instance.
     * More precisely, all arrays, Player instances, and Piece instances
     * must be replaced with clones. There should only exist one clone
     * of each of the Player instances, which should be appropriately replace
     * the references in the Piece instances.
     *
     * @return a clone of the board
     */
    public Board copy() {
        // placeholder
        return null;
    }

    public void setPieceAtAbsCoords(int x, int y, Piece piece) {
        board[y][x] = piece;
    }

    public Piece getPieceAtAbsCoords(int x, int y) {
        return board[y][x];
    }

    public void setPieceAtMirrorCoords(int x, int y, Piece piece) {
        mirror[y][x] = piece;
    }

    public Piece getPieceAtMirrorCoords(int x, int y) {
        return mirror[y][x];
    }

    public void setPieceAtRelCoords(int x, int y, Piece piece) {
        relativeBoard[y][x] = piece;
    }

    public Piece getPieceAtRelCoords(int x, int y) {
        return relativeBoard[y][x];
    }

    public Player[] getPlayers() {
        return this.players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    /**
     * Returns whether coordinates are on the board.
     * This means that the x and y coordinates each lie in the appropriate range 0-7.
     *
     * @return whether the coordinates are on the Board
     */
    public boolean areCoordsOnBoard(int x, int y) {
        // placeholder
        return true;
    }

    /**
     * Returns the Board object which immediately precedes this one in history.
     *
     * @return the preceding Board object
     */
    public Board getPreviousBoard() {
        // placeholder
        return null;
    }

    /**
     * Returns the Move object which turned the previous Board object into this one.
     *
     * @return the preceding Move object
     */
    public Move getPreviousMove() {
        // placeholder
        return null;
    }

    public void selectDefaultPov() {
        this.relativeBoard = board;
    }

    public void selectMirrorPov() {
        this.relativeBoard = mirror;
    }

    public int[] getAbsCoordsFromRelCoords(int[] coords) {
        int[] absCoords = new int[2];
        if (relativeBoard == board) {
            absCoords[0] = coords[0];
            absCoords[1] = coords[1];
        } else {
            absCoords[0] = coords[0];
            absCoords[1] = HEIGHT - 1 - coords[1];
        }
        return absCoords;
    }
}
