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

    public PlayerCopier() {}

    public Player createCopy(Player oldPlayer) {
        String name = oldPlayer.getName();
        char color = oldPlayer.getColor();
        Player newPlayer = new Player(name, color);
        
        // Points will automatically be calculated when captured pieces are added
        List<Piece> capturedPieces = oldPlayer.getCapturedPieces();
        for (Piece piece : capturedPieces) {
            Piece newPiece = piece.copy();
            newPlayer.addCapturedPiece(newPiece);
        }

        List<Piece> pieceList = oldPlayer.getPieceList();
        for (Piece piece : pieceList) {
            Piece newPiece = piece.copy();
            newPlayer.addPiece(newPiece);
        }
        
        return newPlayer;
    }
}
