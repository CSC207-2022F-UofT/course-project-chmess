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
        // TODO
        return null;
    }

    /**
     * Assigns the given piece to the tile with the given absolute coordinates.
     * Absolute coordinates have "white" in row y=0 and "black" in row y=7.
     * The x-coordinate is from left-to-right as usual.
     */
    public void setPieceAtAbsCoords(int x, int y, Piece piece) {
        board[y][x] = piece;
    }

    public Piece getPieceAtAbsCoords(int x, int y) {
        return board[y][x];
    }

    /**
     * Assigns the given piece to the tile with the given mirror coordinates.
     * Mirror coordinates have "white" in row y=7 and "black" in row y=0.
     * The x-coordinate is from left-to-right as usual.
     */
    public void setPieceAtMirrorCoords(int x, int y, Piece piece) {
        mirror[y][x] = piece;
    }

    public Piece getPieceAtMirrorCoords(int x, int y) {
        return mirror[y][x];
    }

    /**
     * Assigns the given piece to the tile with the given relative coordinates.
     * Relative coordinates are either absolute or mirror, depending on the selected POV.
     *
     * @see Board#setPieceAtAbsCoords(int, int, Piece)    setPieceAtAbsCoords
     * @see Board#setPieceAtMirrorCoords(int, int, Piece) setPieceAtMirrorCoords
     * @see Board#selectDefaultPov() selectDefaultPov
     * @see Board#selectMirrorPov()  selectMirrorPov
     */
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
     * Returns whether absolute coordinates are on the board.
     * This means that the x and y coordinates each lie in the appropriate range 0-7.
     *
     * @return whether the coordinates are on the Board
     */
    public boolean containsAbsCoords(int x, int y) {
        // TODO
        return true;
    }

    /**
     * Returns whether mirror coordinates are on the board.
     * This means that the absolute coordinates are on the board.
     *
     * @see    Board#containsAbsCoords(int, int) containsAbsCoords
     * @return whether the coordinates are on the Board
     */
    public boolean containsMirrorCoords(int x, int y) {
        // TODO
        return true;
    }

    /**
     * Returns whether relative coordinates are on the board.
     * This means that the absolute coordinates are on the board.
     *
     * @see    Board#containsAbsCoords(int, int) containsAbsCoords
     * @return whether the coordinates are on the Board
     */
    public boolean containsRelCoords(int x, int y) {
        // TODO
        return true;
    }

    /**
     * Returns the Board object which immediately precedes this one in history.
     *
     * @return the preceding Board object
     */
    public Board getPreviousBoard() {
        // TODO
        return null;
    }

    /**
     * Returns the Move object which turned the previous Board object into this one.
     *
     * @return the preceding Move object
     */
    public Move getPreviousMove() {
        // TODO
        return null;
    }

    /**
     * Interpret all relative coordinates as absolute coordinates.
     *
     * @see Board#setPieceAtRelCoords(int, int, Piece) setPieceAtRelCoords
     * @see Board#setPieceAtAbsCoords(int, int, Piece) setPieceAtAbsCoords
     */
    public void selectDefaultPov() {
        this.relativeBoard = board;
    }

    /**
     * Interpret all relative coordinates as mirror coordinates.
     *
     * @see Board#setPieceAtRelCoords(int, int, Piece)    setPieceAtRelCoords
     * @see Board#setPieceAtMirrorCoords(int, int, Piece) setPieceAtMirrorCoords
     */
    public void selectMirrorPov() {
        this.relativeBoard = mirror;
    }

    /**
     * Returns the absolute coordinates corresponding to the relative coordinates
     *
     * @see Board#setPieceAtRelCoords(int, int, Piece) setPieceAtRelCoords
     */
    public int[] getAbsCoordsFromRelCoords(int x, int y) {
        int[] absCoords = {x, y};
        if (relativeBoard != board) absCoords[1] = HEIGHT - 1 - y;

        return absCoords;
    }
}
