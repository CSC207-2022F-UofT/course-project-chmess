package engine.movegen;

import java.util.List;

import engine.move.Move;
import engine.entities.Board;
import engine.entities.Piece;

public class KnightMovesGen extends MovesGenerator {
    /**
     * Creates a list of possible moves a knight
     * can make which is later refined by PostMoveValidator.
     * Checks if knight can move in an L-shape vertically or
     * horizontally in either direction. Any moves which are
     * not on the board or are occupied by a friendly piece
     * are removed from the list. King checks are NOT considered.
     */
    @Override
    public List<Move> generate (Board board, Piece knight) {
        int[] pos = knight.getCoords(); // get position of knight
        int[][] add = {{2, 1}, {2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}}; // to be added to pos
        for (int i = 0; i <= 7; i++) {
            this.moves.add(new Move(pos, new int[]{pos[0] + add[i][0], pos[1] + add[i][1]})); // adds new Move instance to moves
        }
        super.removeInvalid(this.moves, board);
        return this.moves;

    }
}