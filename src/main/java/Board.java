public class Board {
    private int WIDTH = 8;
    private int HEIGHT = 8;
    private Piece[][] board;

    public Board() {
        board = new Piece[WIDTH][HEIGHT];
    }
    public void setPieceAtCoords(int x, int y, Piece piece) {
        board[x][y] = piece;
    }

    public Piece getPieceAtCoords(int x, int y) {
        return board[x][y];
    }
}
