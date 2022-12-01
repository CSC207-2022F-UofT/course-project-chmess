package engine.entities.copy;

import engine.entities.Board;
import engine.entities.Piece;
import engine.entities.Player;

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
    public BoardCopier() {}

    public Board createCopy(Board oldBoard) {
        Board newBoard = new Board();

        Player[] oldPlayers = oldBoard.getPlayers();
        Player player1 = oldPlayers[0].copy();
        Player player2 = oldPlayers[1].copy();
        Player[] newPlayers = {player1, player2};
        newBoard.setPlayers(newPlayers);


        for (int i=0; i<Board.HEIGHT; i++) {
            for (int j=0; j<Board.WIDTH; j++) {
                Piece relPiece = oldBoard.getPieceAtRelCoords(i, j);

                if (relPiece != null) {
                    Piece newPiece = relPiece.copy();
                    newBoard.setPieceAtRelCoords(i, j, newPiece);
                }
            }
        }

        return newBoard;
    }
}
