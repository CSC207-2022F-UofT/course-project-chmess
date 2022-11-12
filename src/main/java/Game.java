public class Game {
    private Board board;
    private Player[] players;

    public Game() {}

    public Board getBoard() {
        return this.board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player[] getPlayers() {
        return this.players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public char getBoardState() {
        // '$' for stalemate, '#' for checkmate, something else for neither
        // maybe should replace with isStalemate, isCheckmate
        // placeholder
        return '$';
    }

    public Player getCurrentPlayer() {
        // placeholder
        return null;
    }
}
