import java.util.ArrayList;
import java.util.List;
/**
 * Contains a single method which creates list of possible moves
 * a rook can make which is later refined by PostMoveValidator.
 */
public class RookMovesGen extends MovesGenerator {
    /**
     * Checks if rook can move seven squares along any cardinal
     * straight line. Also includes castling if the rook satisfies
     * the requirements to castle. Any moves which jump over a piece,
     * are not on the board, or are occupied by a friendly
     * piece are removed from the list. King checks are NOT
     * considered at this stage.
     *
     * @param board the board on which moves are generated
     * @param rook the rook piece for which moves are generated
     * @return the list of possible moves
     */
    public List<Move> generate (Board board, Piece rook) {
        int[] origin = rook.getCoords();
        List<Move> moveList = new ArrayList<Move>();
        //completely check each of the four cardinal directions in turn.
        //begin with up, and go clockwise.
        //do this by looping through coord changes:
        int[][] coordChanges = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for(int[] coordChange: coordChanges) {
            //loop through new tiles (up to seven) one tile at a time.
            //the first tile which cannot be moved onto indicates that no further
            //tile can be moved to, since it will either be jumping over pieces
            //or off the board. Hence, terminate the loop when this happens.
            for (int i = 1; i < Board.WIDTH; i++) {
                int[] destination = {origin[0] + i * coordChange[0], origin[1] + i * coordChange[1]};
                Move toAdd = new Move(origin, destination);
                //only add the move if it's valid.
                if (this.checkTile(toAdd, board)) {
                    moveList.add(toAdd);
                }
                else {break;}
            }
        }
        //TODO: add ability to castle

        return moveList;
    }
}
