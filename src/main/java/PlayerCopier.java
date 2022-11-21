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
        //TODO!!!
        
        String name = this.oldPlayer.getName();
        char color = this.oldPlayer.getColor();
        int points = this.oldPlayer.getPoints();
        List<Piece> capturedPieces = this.oldPlayer.getCapturedPieces();

        return this.newPlayer;
    }

    public void addPiecesToCaptured() {
        List<Piece> pieces = this.oldPlayer.getPieceList();
        for (Piece piece : pieces) {
            Piece newPiece = piece.copy();
            this.newPlayer.addCapturedPiece(newPiece);
        }
    }

}
