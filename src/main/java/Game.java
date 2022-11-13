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
     * Returns a char representing the board state.
     * This should be '$' for stalemate or '#' for checkmate.
     * No character is designated for the case of neither.
     *
     * Note: Should maybe be replaced with isStalemate, isCheckmate
     */
    public char getBoardState() {
        // placeholder
        return '$';
    }

    /**
     * Return the Player object corresponding to
     * the player whose turn it is to make a move.
     *
     * @return the Player object
     */
    public Player getCurrentPlayer() {
        // placeholder
        return null;
    }
}
