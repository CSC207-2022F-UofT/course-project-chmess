package engine.entities;

import java.util.ArrayList;
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
    //private Player currentPlayer;
    //private Player lastPlayer;
    private int indexOfCurPlayer;
    private Board prevBoard;

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
        return this.prevBoard;
    }
    public void setPreviousBoard(Board board) {
        this.prevBoard = board;
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
    public void setCurrentPlayer(int index) {
        //this.currentPlayer = players[index];
        //this.lastPlayer = lastp;
        indexOfCurPlayer=index;
    }

    public int getIndexOfCurplayer() {
        //return this.currentPlayer;
        return indexOfCurPlayer;
    }
    /**
     * Return the Player object corresponding to
     * the player whose turn it is to make a move.
     *
     * @return the Player object
     */
    public Player getCurrentPlayer() {
        //return this.currentPlayer;
        return this.players[indexOfCurPlayer];
    }

    /**
     * Sets the current player to the next one in
     * the players array. If this is the "last" player,
     * wrap back around to the first one.
     * If the current player has yet to be set,
     * set it to the first player in the array.
     */
    public void advanceCurrentPlayer() {
        /*int i;
        for (i = 0; i < players.length; i++) {
            if (players[i] == currentPlayer) break;
        }
        int newIndex = (i + 1) % players.length;*/
        indexOfCurPlayer=(indexOfCurPlayer+1)% players.length;
        System.out.print("CCCCCCCCCCCCCCCCCC; ");
        //System.out.print(players[0] == currentPlayer);
        //System.out.print(players[1] == currentPlayer);
        System.out.print(indexOfCurPlayer);
        System.out.print( players.length);
        System.out.print(players[indexOfCurPlayer].getColor());
        System.out.print(players[0].getColor());
        System.out.println(players[1].getColor());
        /*Player temp=this.lastPlayer;
        this.lastPlayer=this.currentPlayer;*/
        //this.currentPlayer = players[newIndex];
    }

    /**
     * Assigns the given piece to the tile with the given absolute coordinates.
     * Absolute coordinates have "white" in row y=0 and "black" in row y=7.
     * The x-coordinate is from left-to-right as usual.
     * If piece is not null, also sets the coordinates of piece to match
     * the coordinates of the board tile on which it is placed.
     * (Ideally, this method should be abstracted away as it has multiple
     * responsibilities).
     */
    public void setPieceAtAbsCoords(int x, int y, Piece piece) {
        board[y][x] = piece;
        if(piece != null) {
            piece.setCoords(x, y);
        }
    }

    public Piece getPieceAtAbsCoords(int x, int y) {
        if (!(x < 0 || x > WIDTH - 1 || y < 0 || y > HEIGHT - 1)) {
            return board[y][x];
        }
        return null;
    }

    /**
     * Assigns the given piece to the tile with the given mirror coordinates.
     * Mirror coordinates have "white" in row y=7 and "black" in row y=0.
     * The x-coordinate is from left-to-right as usual.
     */
    public void setPieceAtRelativeCoords(int x, int y, Piece piece) {
        relativeBoard[y][x] = piece;
    }

    public Piece getPieceAtRelativeCoords(int x, int y) {
        return relativeBoard[y][x];
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
        return(0 <= x && 0 <= y && x < Board.WIDTH && y < Board.HEIGHT);
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
        int[] newCoords = new int[2];
        newCoords[0]=coord[0];
        newCoords[1]=coord[1];
        if (this.relativeBoard == this.board) newCoords[1] = HEIGHT - 1 - coord[1];
        //if (this.currentPlayer.getColor() == 'B') relCoords[1] = HEIGHT - 1 - coord[1];
        return newCoords;
    }
    /**
     * Returns list of all semivalid moves all pieces of given color
     * can make.
     */
    public List<Move> semiValidMovesForColor(char color) {
        List<Move> semiValidMoves = new ArrayList<>();
        for (Piece p : getAllPiecesForColor(color)) {
            for (Move m : p.generateMoves(this)) {
                semiValidMoves.add(m);
            }
        }
        return semiValidMoves;
    }
    /**
     * Returns list of pieces belonging to color passed in.
     */
    public List<Piece> getAllPiecesForColor(char color) {
        List<Piece> piecesForColor = new ArrayList<>();
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                if (getPieceAtAbsCoords(x, y) != null) {
                    if (getPieceAtAbsCoords(x, y).getColor() == color) {
                        piecesForColor.add(getPieceAtAbsCoords(x, y));
                    }
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

    public List<Move> generatePlayerMoves (Player player) {
        List<Move> moves = new ArrayList<Move>();
        for (Piece piece : getAllPiecesForColor(player.getColor())) {
            //System.out.println("HaHAHAHAHAA");
            moves.addAll(piece.generateMoves(this));
        }
        return moves;
    }

}
