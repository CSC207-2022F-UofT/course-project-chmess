package engine;

import engine.move.Move;
import engine.entities.Board;
import engine.entities.Player;
import engine.entities.Piece;

import java.util.ArrayList;
import java.util.List;

public class CheckChecker {
    public CheckChecker() {}

    private List<Piece> getAllPiece(Board board) {
        List<Piece> pieceList = new ArrayList<>();
        for (int i = 0; i < Board.HEIGHT; i++)
            for (int j = 0; j < Board.WIDTH; j++)
                if (board.getPieceAtAbsCoords(i,j) != null)
                    pieceList.add(board.getPieceAtAbsCoords(i,j));
        return pieceList;
    }

    private int[] findKing(List<Piece> pieceList, Player player) {
        for (Piece piece : pieceList)
            if (piece.getColor() == player.getColor() && piece.getType().equals("king"))
                return piece.getCoords();
        return new int[]{-1, -1};
    }

    /**
     * Returns whether a player is in check.
     * @param board
     * @param player
     * @return whether the given player is in check
     */
    public boolean isPlayerInCheck(Board board, Player player) {
        List<Piece> pieceList=getAllPiece(board);
        int[] kingCoords = findKing(pieceList, player);
        for (Piece piece: pieceList) {
            if (piece.getColor() != player.getColor()) {
                List<Move> moves=piece.generateMoves();
                if (moves == null) continue;
                for (Move possibleMove: moves) {
                    if (possibleMove.destination[0] == kingCoords[0]
                            && possibleMove.destination[1] == kingCoords[1]) return true;
                }
            }
        }
        return false;
    }
}
