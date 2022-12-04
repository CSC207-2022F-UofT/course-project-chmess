package engine;

import engine.move.Move;
import engine.entities.Board;
import engine.entities.Piece;

import java.util.ArrayList;
import java.util.List;

public class CheckChecker {
    public CheckChecker() {}

    private List<Piece> getAllPieces(Board board) {
        List<Piece> pieceList = new ArrayList<>();
        for (int i = 0; i < Board.HEIGHT; i++) {
            for (int j = 0; j < Board.WIDTH; j++) {
                Piece piece = board.getPieceAtAbsCoords(i, j);
                if (piece != null) pieceList.add(piece);
            }
        }
        return pieceList;
    }

    private int[] findKing(List<Piece> pieceList, char playerColor) {
        for (Piece piece : pieceList)
            if (piece.getColor() == playerColor && piece.getType().equals("king"))
                return piece.getCoords();
        return new int[]{-1, -1};
    }

    /**
     * Returns whether a player is in check.
     * @param board
     * @param playerColor
     * @return whether the given player is in check
     */
    public boolean isPlayerInCheck(Board board, char playerColor) {
        List<Piece> pieceList = getAllPieces(board);
        int[] kingCoords = findKing(pieceList, playerColor);
        for (Piece piece: pieceList) {
            if (piece.getColor() != playerColor) {
                List<Move> moves = piece.generateMoves();
                if (moves == null) continue;
                for (Move possibleMove : moves) {
                    if (possibleMove.destination[0] == kingCoords[0]
                            && possibleMove.destination[1] == kingCoords[1]) return true;
                }
            }
        }
        return false;
    }
}
