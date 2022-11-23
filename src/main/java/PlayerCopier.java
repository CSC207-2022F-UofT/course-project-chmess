import java.util.List;

public class PlayerCopier {
    /**
     * Returns a deep clone of the given Board instance.
     *
     * @see Player#copy() Board.copy()
     *
     * @param player the board to be cloned
     * @return a clone of the board
     */

    private Player newPlayer;
    private Player oldPlayer;

    public PlayerCopier(Player oldPlayer) {
        this.oldPlayer = oldPlayer;
    }

    public Player createCopy() {
        String name = this.oldPlayer.getName();
        char color = this.oldPlayer.getColor();
        this.newPlayer = new Player(name, color);
        
        // Points will autmatically be calculated when captured pieces are added
        List<Piece> capturedPieces = this.oldPlayer.getCapturedPieces();
        for (Piece piece : capturedPieces) {
            Piece newPiece = piece.copy();
            this.newPlayer.addCapturedPiece(newPiece);
        }

        List<Piece> pieceList = this.oldPlayer.getPieceList();
        for (Piece piece : pieceList) {
            Piece newPiece = piece.copy();
            this.newPlayer.addPiece(newPiece);
        }
        
        return this.newPlayer;
    }
}
