public class Board {
    private int WIDTH = 8;
    private int HEIGHT = 8;
    private Piece[][] board;
    private Player[] players;

    public Board() {
        board = new Piece[WIDTH][HEIGHT];
    }

    public Board copy() {

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

    public boolean areCoordsOnBoard(int x, int y) {

    }

    public int[] getCoordsOfPiece(Piece piece) {

    }

    public Board getPreviousBoard() {

    }

    public Move getPreviousMove() {

    }
}