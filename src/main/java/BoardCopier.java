/**
 * A deep cloner for Board instances.
 */
public class BoardCopier {
    /**
     * Returns a deep clone of the given Board instance.
     *
     * @see Board#copy() Board.copy()
     *
     * @param board the board to be cloned
     * @return a clone of the board
     */

    private Board oldBoard;
    private Board newBoard;
    
    public BoardCopier() {}

    public Board createCopy(Board oldBoard) {
        private Board newBoard = new Board();

        this.oldBoard = oldBoard;
        this.newBoard = newBoard;

        Player[] oldPlayers = oldBoard.getPlayers();
        clonePlayer(oldPlayers);

        clonePieces();

        return this.newBoard;
    }

    private void clonePieces() {
        for (int i=0; i<Board.HEIGHT; i++) {
            for (int j=0; j<Board.WIDTH; j++) {
                Piece absPiece = oldBoard.getPieceAtAbsCoords(i, j);
                Piece relPiece = oldBoard.getPieceAtRelCoords(i, j);
                Piece mirrorPiece = oldBoard.getPieceAtMirrorCoords(i, j);

                if (absPiece != null) {
                    Piece newPiece = absPiece.copy();
                    newBoard.setPieceAtAbsCoords(i, j, newPiece);
                }
                
                if (relPiece != null) {
                    Piece newPiece = relPiece.copy();
                    newBoard.setPieceAtRelCoords(i, j, newPiece);
                }
                 
                if (mirrorPiece != null) {
                    Piece newPiece = mirrorPiece.copy();
                    newBoard.setPieceAtMirrorCoords(i, j, newPiece);
                } 
            }
        }
    }

    private void clonePlayer(Player[] players) {
        Player player1 = players[0].copy();
        Player player2 = players[1].copy();
        Player[] newPlayers = {player1, player2};
        this.newBoard.setPlayers(newPlayers);
    }
}
