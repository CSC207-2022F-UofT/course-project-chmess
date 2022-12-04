package engine.movegen;

import java.util.List;
import java.util.ArrayList;

import engine.move.Move;
import engine.entities.Board;
import engine.entities.Piece;

/**
 * Abstract class containing useful methods used in
 * its subclasses. Each subclass will generate a
 * list of possible moves according to the piece
 * it's related to.
 */
public abstract class MovesGenerator {
    public List<Move> moves;
    public abstract List<Move> generate (Board board, Piece piece);
    /**
     * Mutates list of moves by removing moves not on
     * board and are not occupied by friendly pieces.
     *
     * @param moves the list of moves being checked
     * @param board the board on which these moves exist
     */
    public void removeInvalid (List<Move> moves, Board board) {
        for(Move move : moves){
            if(!(checkTile(move, board))){
                moves.remove(move);
            }
        }
    }

    /**
     * Returns true if the destination of move is on
     * board and is NOT occupied by friendly piece.
     *
     * @param move the move whose destination tile is being checked
     * @param board the board on which the move exists
     * @return whether the
     */
    public boolean checkTile (Move move, Board board) {
        //returns false if the destination tile is not on the board
        if(!(board.containsAbsCoords(move.destination[0], move.destination[1]))){return false;}
        //checks if there is no piece on the destination tile
        if(board.getPieceAtAbsCoords(move.destination[0], move.destination[1]) == null){
            //there is no piece on the destination tile, so the move has no issue.
            return true;
        } else return isOccupiedByEnemy(move, board); //move is valid only if enemy is on destination tile
    }

    /**
     * Checks to see whether destination of move is already
     * occupied by a friendly piece.
     *
     * @param move the move whose destination tile is being checked
     * @param board the board on which the move exists
     * @return whether the destination tile is occupied by a friendly piece
     */
    public boolean isOccupiedByFriendly (Move move, Board board) {
        //ensure destination tile is occupied
        if(board.getPieceAtAbsCoords(move.destination[0], move.destination[1]) != null){
            Piece movingPiece = board.getPieceAtAbsCoords(move.origin[0], move.origin[1]);
            Piece destPiece = board.getPieceAtAbsCoords(move.destination[0], move.destination[1]);
            //returns true if moving and destination pieces have same colours
            return(movingPiece.getColor() == destPiece.getColor());
        }
        //destination tile is not occupied
        return false;
    }
    /**
     * Checks to see whether destination of move is
     * occupied by an enemy piece.
     *
     * @param move the move whose destination tile is being checked
     * @param board the board on which the move exists
     * @return whether the destination tile is occupied by an enemy piece
     */
    public boolean isOccupiedByEnemy (Move move, Board board) {
        //ensure destination tile is occupied
        if(board.getPieceAtAbsCoords(move.destination[0], move.destination[1]) != null){
            Piece movingPiece = board.getPieceAtAbsCoords(move.origin[0], move.origin[1]);
            Piece destPiece = board.getPieceAtAbsCoords(move.destination[0], move.destination[1]);
            //returns true if moving and destination pieces have different colours
            return(movingPiece.getColor() != destPiece.getColor());
        }
        //destination tile is not occupied
        return false;
    }

    /**
     * Generates moves in straight lines from an original tile in given directions. Includes captures.
     * Does not include moves which land on friendly pieces, jump over pieces, or are off the board.
     *
     * @param origin the original coordinates of the piece for which moves are being generated
     * @param directions the directions of moves to be generated, represented by coordinate changes
     * @param board the board on which moves are being generated
     * @return a list of valid straight line moves in the specified directions
     */
    public List<Move> genStraightLineMoves (int[] origin, int[][] directions, Board board){
        List<Move> moveList = new ArrayList<Move>();
        for(int[] direction: directions){
            //loop through new tiles (up to the board's dimensions, i.e. 7) one tile at a time.
            //the first tile which cannot be moved onto indicates that no further
            //tile can be moved to, since it will either be jumping over pieces
            //or off the board. Hence, terminate the loop when this happens.
            for(int distance = 1; distance < Board.WIDTH; distance++){
                int[] destination = {origin[0] + distance * direction[0], origin[1] + distance * direction[1]};
                Move toAdd = new Move(origin, destination);
                //only add the move if it's valid, meaning the destination tile is on the board and no
                //friendly piece is on it
                if(checkTile(toAdd, board)){
                    moveList.add(toAdd);
                    //if the move is a capture, any further tile would be a jump, so stop looping
                    //in this direction
                    if(isOccupiedByEnemy(toAdd, board)){break;}
                }
                //the move lands on a friendly or is off the board, so stop looping for this direction
                else{break;}
            }
        }
        return moveList;
    }
}
