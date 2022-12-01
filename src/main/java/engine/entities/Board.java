package engine.entities;

import java.util.List;

import engine.move.Move;
import engine.entities.copy.BoardCopier;
/**
 * A board of chess pieces.
 */
public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private final Piece[][] board;
    private final Piece[][] mirror;
    private Piece[][] relativeBoard;
    // the first player has color 'W' (white)
    // the second player has color 'B' (black)
    private Player[] players = new Player[2];
    private Player currentPlayer;

    /**
     * Creates an empty board with no players.
     */
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
        BoardCopier bc = new BoardCopier();
        return bc.createCopy(this);
    }

    /**
     * Set this board's players.
     * @param players
     */
    public void setPlayers(Player[] players) {
        this.players = players;
    }

    /**
     * Get this board's players.
     * @return players on this board
     */
    public Player[] getPlayers() {
        return this.players;
    }

    /**
     * Returns the player with the given color.
     *
     * @param color the color of the player in which we are interested
     * @return the player with the given color
     */
    public Player getPlayerFromChar(char color) {
        if (color == 'W') return players[0];
        else return players[1];
    }

    /**
     * Returns the player who owns the given piece.
     * @param piece the piece in which we are interested
     * @return the player object with the same color as the given piece
     */
    public Player getPlayerOfPiece(Piece piece) {
        return getPlayerFromChar(piece.getColor());
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
     * Sets current player to the given player.
     *
     * @param player the player whose turn it is to make a move
     */
    public void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }

    /**
     * Return the Player object corresponding to
     * the player whose turn it is to make a move.
     *
     * @return the Player object
     */
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    /**
     * Sets the current player to the next one in
     * the players array. If this is the "last" player,
     * wrap back around to the first one.
     * If the current player has yet to be set,
     * set it to the first player in the array.
     */
    public void advanceCurrentPlayer() {
        int i;
        for (i = 0; i < players.length; i++) {
            if (players[i] == currentPlayer) break;
        }
        int newIndex = (i + 1) % players.length;
        this.currentPlayer = players[newIndex];
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
     * or vice versa.
     *
     * @see Board#setPieceAtRelCoords(int, int, Piece) setPieceAtRelCoords
     */
    public int[] switchCoords(int[] coord) {
        int[] absCoords = coord;
        if (relativeBoard != board) absCoords[1] = HEIGHT - 1 - coord[1];

        return absCoords;
    }
    /**
     * Returns list of all semivalid moves all pieces of given color
     * can make.
     */
    public List<Move> semiValidMovesForColor(char color) {
        List<Move> semiValidMoves = null;
        for (Piece p : getAllPiecesForColor(color)) {
            for (Move m : p.generateMoves()) {
                semiValidMoves.add(m);
            }
        }
        return semiValidMoves;
    }
    /**
     * Returns list of pieces belonging to color passed in.
     */
    private List<Piece> getAllPiecesForColor(char color) {
        List<Piece> piecesForColor = null;
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                if (getPieceAtAbsCoords(x, y).getColor() == color) {
                    piecesForColor.add(getPieceAtAbsCoords(x, y));
                }
            }
        }
        return piecesForColor;
    }

    public List<Piece> getAllPieces() {
        List<Piece> pieces = new ArrayList<Piece>();
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                if (getPieceAtAbsCoords(x, y) != null) {
                    pieces.add(getPieceAtAbsCoords(x, y));
                }
            }
        }
        return pieces;
    }
}
