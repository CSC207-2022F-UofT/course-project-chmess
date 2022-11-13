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

    /**
     * Returns a char representing the game state.
     * This should be '$' for stalemate or '#' for checkmate.
     * No particular character is designated for the case of neither.
     *
     * Note: Should maybe be replaced with isStalemate, isCheckmate
     */
    public char getGameState() {
        // Note: Closely related to seeing if King is in check
        // both maybe should be moved to their own classes
        // TODO
        return '$';
    }
}
