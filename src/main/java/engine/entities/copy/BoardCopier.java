package engine.entities.copy;

import java.util.List;

import engine.entities.Board;
import engine.entities.Piece;
import engine.entities.Player;

/**
 * A deep cloner for Board instances.
 */
public class BoardCopier {
    public BoardCopier() {}

    /**
     * Returns a deep clone of the given Board instance.
     * The given Board object should contain player objects.
     *
     * @see Board#copy() Board.copy()
     *
     * @param oldBoard the board to be cloned
     * @return a clone of the board
     */
    public static Board createCopy(Board oldBoard) {
        Board newBoard = new Board();

        Player[] oldPlayers = oldBoard.getPlayers();
        Player player1 = oldPlayers[0].copy();
        Player player2 = oldPlayers[1].copy();
        Player[] newPlayers = {player1, player2};
        newBoard.setPlayers(newPlayers);

        List<Piece> oldPieces = oldBoard.getAllPieces();

        for (Piece piece : oldPieces) {
            Piece newPiece = piece.copy();
            int[] coords = piece.getCoords();
            newBoard.setPieceAtAbsCoords(coords[0], coords[1], newPiece);
        }

        return newBoard;
    }
}
