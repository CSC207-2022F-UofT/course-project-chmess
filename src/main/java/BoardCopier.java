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
    private Board oldBoard = new Board();

    public BoardCopier() {}

    public Board createCopy(Board board) {
        this.oldBoard = board;
        Player[] oldPlayers = this.oldBoard.getPlayers();
        clonePlayer(oldPlayers);

        //TODO!!!
        // Don't entirely understand the use of mirror coordinates
        // If still needed, will need to implement later

        Piece[][] pieceBoard = oldBoard.getBoard();
        clonePieces(pieceBoard);

        Piece[][] relativeBoard = oldBoard.getRelBoard();
        clonePieces(relativeBoard);

        Piece[][] mirrorBoard = oldBoard.getMirrorBoard();
        clonePieces(mirrorBoard);


        return this.newBoard;
    }

    private void clonePieces(Piece[][] pieceBoard) {
        for (int i=0; i<pieceBoard.length; i++) {
            for (int j=0; j<pieceBoard[0].length; j++) {

                if (pieceBoard[i][j] != null) {
                    Piece piece = pieceBoard[i][j];
                    Piece newPiece = piece.copy();
                    newBoard.setPieceAtAbsCoords(i, j , newPiece);
                    newBoard.setPieceAtRelCoords(i, j, newPiece);
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

    private void cloneRelative(Piece piece) {
        
    }
}
