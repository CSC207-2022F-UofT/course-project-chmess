import java.util.ArrayList;
import java.util.List;
/**
 * Contains a single method which creates list of possible moves
 * a queen can make which is later refined by PostMoveValidator.
 */
public class QueenMovesGen extends MovesGenerator {
    /**
     * Checks if queen can move seven squares along any straight line.
     * Any moves which jump over a piece,
     * are not on the board, or are occupied by a friendly
     * piece are removed from the list. King checks are NOT
     * considered at this stage.
     *
     * @param board the board on which moves are generated
     * @param queen the queen piece for which moves are generated
     * @return the list of possible moves
     */
    public List<Move> generate (Board board, Piece queen) {
        //creates list of moves to be returned and initializes with diagonal moves,
        //generated using BishopMovesGen class instance
        List<Move> moveList = new ArrayList<Move>(new BishopMovesGen().generate(board, queen));
        //next adds all cardinal moves possible, generated via RookMovesGen
        moveList.addAll(new RookMovesGen().generate(board, queen));
        return moveList;
    }
}
