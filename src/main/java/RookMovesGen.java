import java.util.ArrayList;
import java.util.List;
/**
 * Contains a single method which creates list of possible moves
 * a rook can make which is later refined by PostMoveValidator.
 */
public class RookMovesGen extends MovesGenerator {
    /**
     * Checks if rook can move seven squares along any cardinal
     * straight line. Any moves which jump over a piece,
     * are not on the board, or are occupied by a friendly
     * piece are removed from the list. King checks are NOT
     * considered at this stage.
     *
     * @param board the board on which moves are generated
     * @param rook the rook piece for which moves are generated
     * @return the list of possible moves
     */
    @Override
    public List<Move> generate (Board board, Piece rook) {
        int[] origin = rook.getCoords();
        List<Move> moveList = new ArrayList<Move>();
        //completely check each of the four cardinal directions in turn.
        //begin with up, and go clockwise.
        //do this by looping through coord changes:
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for(int[] direction: directions) {
            //loop through new tiles (up to seven) one tile at a time.
            //the first tile which cannot be moved onto indicates that no further
            //tile can be moved to, since it will either be jumping over pieces
            //or off the board. Hence, terminate the loop when this happens.
            for (int distance = 1; distance < Board.WIDTH; distance++) {
                int[] destination = {origin[0] + distance * direction[0], origin[1] + distance * direction[1]};
                Move toAdd = new Move(origin, destination);
                //only add the move if it's valid.
                if (this.checkTile(toAdd, board)) {
                    moveList.add(toAdd);
                } else {
                    break;
                }
            }
        }
        return moveList;
    }
}
