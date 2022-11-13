public class Game {
    private Board board;
    private char gameState;

    public Game() {}

    public void setBoard(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return this.board;
    }

    public void setPlayers(Player[] players) {
        this.board.setPlayers(players);
    }

    public Player[] getPlayers() {
        return this.board.getPlayers();
    }

    public void setGameState(char gameState) {
        this.gameState = gameState;
    }

    /**
     * Returns a char representing the game state.
     * This should be '$' for stalemate or '#' for checkmate.
     * No particular character is designated for the case of neither.
     * Note: Should maybe be replaced with isStalemate, isCheckmate
     */
    public char getGameState() {
        return this.gameState;
    }
}
