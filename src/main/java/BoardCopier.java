public class BoardCopier {
    /**
     * Returns a deep clone of the given Board instance.
     *
     * @see Board#copy() Board.copy()
     *
     * @param board the board to be cloned
     * @return a clone of the board
     */

    private Board newBoard;
    private Board oldBoard;

    public BoardCopier(Board oldBoard) {
        this.oldBoard = oldBoard;
    }

    public Board createCopy(Board board) {
        // TODO
        // copy to helper functions - must deep copy all classes.
        
        
        
        return null;
    }

    private Piece clonePiece(Piece piece) {
        // TODO: PIECE COPY MUST BE FINISHED
        Piece newPiece = piece.copy();

        return newPiece;
    }

    private void clonePlayer(Player[] players) {
        Player player1 = players[0].copy();
        Player player2 = players[1].copy();
        Player[] newPlayers = {player1, player2};
        this.newBoard.setPlayers(newPlayers);
    }
}
