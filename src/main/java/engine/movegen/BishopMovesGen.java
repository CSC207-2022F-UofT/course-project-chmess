package engine.movegen;

import java.util.ArrayList;
import java.util.List;

import engine.move.Move;
import engine.entities.Board;
import engine.entities.Piece;
/**
 * Contains a single method which creates list of possible moves
 * a bishop can make which is later refined by PostMoveValidator.
 */
public class BishopMovesGen extends MovesGenerator {
    /**
     * Finds all possible moves a bishop can make, up to seven tiles
     * in any diagonal. Any moves which jump over a piece,
     * are not on the board, or are occupied by a friendly
     * piece are removed from the list. King checks are NOT
     * considered at this stage.
     *
     * @param board the board on which moves are generated
     * @param bishop the bishop piece for which moves are generated
     * @return the list of possible moves
     */
    @Override
    public List<Move> generate (Board board, Piece bishop) {
        int[] origin = bishop.getCoords();
        List<Move> moveList = new ArrayList<Move>();
        //completely check each of the four diagonal directions in turn.
        //begin with the top left diagonal, and go clockwise.
        int[][] directions = {{-1, 1}, {1, 1}, {1, -1}, {-1, -1}};
        for(int[] direction: directions){
            //loop through new tiles (up to seven) one tile at a time.
            //the first tile which cannot be moved onto indicates that no further
            //tile can be moved to, since it will either be jumping over pieces
            //or off the board. Hence, terminate the loop when this happens.
            for(int distance = 1; distance < Board.WIDTH; distance++){
                int[] destination = {origin[0] + distance * direction[0], origin[1] + distance * direction[1]};
                Move toAdd = new Move(origin, destination);
                //only add the move if it's valid.
                if(this.checkTile(toAdd, board)){
                    moveList.add(toAdd);
                }
                else{break;}
            }
        }
        return moveList;
    }
}
