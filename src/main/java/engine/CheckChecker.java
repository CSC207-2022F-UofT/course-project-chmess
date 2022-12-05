package engine;

import engine.move.Move;
import engine.entities.Board;
import engine.entities.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class CheckChecker {
    public CheckChecker() {}

    private List<Piece> getAllPieces(Board board) {
        List<Piece> pieceList = new ArrayList<>();
        for (int x = 0; x < Board.WIDTH; x++) {
            for (int y = 0; y < Board.HEIGHT; y++) {
                Piece piece = board.getPieceAtAbsCoords(x, y);
                if (piece != null) pieceList.add(piece);
            }
        }
        return pieceList;
    }

    private int[] findKing(List<Piece> pieceList, char playerColor) throws NoSuchElementException {
        for (Piece piece : pieceList)
            if (piece.getColor() == playerColor && piece.getType().equals("king"))
                return piece.getCoords();
        throw new NoSuchElementException();
    }

    /**
     * Returns whether a player is in check.
     * @param board
     * @param playerColor
     * @return whether the given player is in check
     */
    public boolean isPlayerInCheck(Board board, char playerColor) {
        try {
            List<Piece> pieceList = getAllPieces(board);
            int[] kingCoords = findKing(pieceList, playerColor);
            for (Piece piece : pieceList) {
                if (piece.getColor() != playerColor) {
                    List<Move> moves = piece.generateMoves(board);
                    if (moves == null) continue;

                    boolean containsDestCoords = movesContainsDestCoords(moves, kingCoords);
                    if (containsDestCoords) return true;
                }
            }
            return false;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean movesContainsDestCoords(List<Move> moves, int[] coords) {
        for (Move move : moves) {
            if (move.destination[0] == coords[0] && move.destination[1] == coords[1])
                return true;
        }
        return false;
    }
}
