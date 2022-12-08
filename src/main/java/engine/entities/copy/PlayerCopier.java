package engine.entities.copy;

import java.util.List;
import engine.entities.Piece;
import engine.entities.Player;

public class PlayerCopier {
    public PlayerCopier() {}

    /**
     * Returns a deep clone of the given Player instance.
     * The contained Piece objects are cloned.
     *
     * @param oldPlayer the player to be cloned
     * @return a (deep) clone of the player
     */
    public Player createCopy(Player oldPlayer) {
        String name = oldPlayer.getName();
        char color = oldPlayer.getColor();
        Player newPlayer = new Player(name, color);

        // The pieces need to be copies to produce a deep clone
        List<Piece> capturedPieces = oldPlayer.getCapturedPieces();
        for (Piece piece : capturedPieces) if (piece.isOnBoard())  {
            newPlayer.addCapturedPiece(piece.copy());
        }

        List<Piece> pieceList = oldPlayer.getPieceList();
        for (Piece piece : pieceList) if (piece.isOnBoard()) {
            newPlayer.addPiece(piece.copy());
        }
        return newPlayer;
    }
}
