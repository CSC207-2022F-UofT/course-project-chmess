public class Board {
    private int WIDTH = 8;
    private int HEIGHT = 8;
    private Piece[][] board;
    private Player[] players;

    public Board() {
        board = new Piece[WIDTH][HEIGHT];
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

    public void setPieceAtCoords(int x, int y, Piece piece) {
        board[x][y] = piece;
    }

    public Piece getPieceAtCoords(int x, int y) {
        return board[x][y];
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
}
