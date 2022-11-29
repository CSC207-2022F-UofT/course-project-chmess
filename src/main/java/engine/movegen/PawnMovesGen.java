package engine.movegen;

import java.util.List;

import engine.move.*;
import engine.entities.Board;
import engine.entities.Piece;

public class PawnMovesGen extends MovesGenerator {
    /**
     * Creates list of possible moves a pawn can
     * make which is later refined by PostMoveValidator.
     * Checks if pawn can move one square, two squares,
     * capture diagonally, promote, or en passant and adds
     * them to the list of moves. Any moves which jump over
     * a piece, are not on the board, or are occupied are
     * removed from the list. King checks are NOT considered.
     */
    public List<Move> generate (Board board, Piece pawn) {
        char color = pawn.getColor();
        if (color == 'W') { board.selectDefaultPov(); }
        else if (color == 'B') { board.selectMirrorPov(); }
        int[] pos = board.switchCoords(pawn.getCoords()); // get position of pawn in relative coordinates
//        Move move1Rel = new Move(pos, new int[]{pos[0], pos[1] + 1});
        Move move1 = new Move(board.switchCoords(pos), board.switchCoords(new int[]{pos[0], pos[1] + 1}));
        if (pos[0] == 6 && !(isOccupiedByPiece(move1, board))) { // checks if pawn can promote
            addPromoteMoves(pos, new int[]{pos[0], 7}, pawn, board);
            Move moveCapPro1 = new Move(board.switchCoords(pos), board.switchCoords(new int[]{pos[0] - 1, 7}));
            Move moveCapPro2 = new Move(board.switchCoords(pos), board.switchCoords(new int[]{pos[0] + 1, 7}));
            if (isOccupiedByEnemy(moveCapPro1, board)) {
                addPromoteMoves(pos, new int[]{pos[0] - 1, 7}, pawn, board);
            }
            if (isOccupiedByEnemy(moveCapPro2, board)) {
                addPromoteMoves(pos, new int[]{pos[0] + 1, 7}, pawn, board);
            }
        }
        if (pos[0] == 1 && !(this.isOccupiedByPiece(move1, board))) { // checks if pawn is in starting position and not jumping over piece
            Move move2 = new Move(board.switchCoords(pos), board.switchCoords(new int[]{pos[0], pos[1] + 2})); // absolute pawn double move
            this.moves.add(move2);
        }
        if (pos[1] == 4) { // checks en passant
            Move prevMove = board.getPreviousMove();
            int[] origin1 = new int[]{pos[0] + 1, 6};
            int[] origin2 = new int[]{pos[0] - 1, 6};
            int[] dest1 = new int[]{pos[0] + 1, 4};
            int[] dest2 = new int[]{pos[0] - 1, 4};
            int[] preOri = board.switchCoords(prevMove.origin); //changing to relative
            int[] preDest = board.switchCoords(prevMove.destination);
            if (preOri == origin1 && preDest == dest1 && board.getPieceAtRelCoords(preDest[0], preDest[1]).getType().equals("pawn")) {
                this.moves.add(new EnPassantMove(board.switchCoords(pos), board.switchCoords(new int[]{dest1[0], dest1[1] + 1})));
            }
            if (preOri == origin2 && preDest == dest2 && board.getPieceAtRelCoords(preDest[0], preDest[1]).getType().equals("pawn")) {
                this.moves.add(new EnPassantMove(board.switchCoords(pos), board.switchCoords(new int[]{dest2[0], dest2[1] + 1})));
            }
        }
        if (!(isOccupiedByPiece(move1, board))) { // move one tile
            this.moves.add(move1); // move1 is already absolute move
        }
        Move destCap1 = new Move(board.switchCoords(pos), board.switchCoords(new int[]{pos[0]-1, pos[1]+1})); // absolute moves
        Move destCap2 = new Move(board.switchCoords(pos), board.switchCoords(new int[]{pos[0]+1, pos[1]+1}));
        if (isOccupiedByEnemy(destCap1, board)) { // capture
            this.moves.add(destCap1);
        }
        if (isOccupiedByEnemy(destCap2, board)) {
            this.moves.add(destCap2);
        }


        super.removeInvalid(this.moves, board);
        return this.moves;
    }
    /**
     * Checks to see whether destination of move is already
     * occupied by any piece. Takes in absolute coordinates.
     */
    private boolean isOccupiedByPiece (Move move, Board board) {
        return isOccupiedByFriendly(move, board) && isOccupiedByEnemy(move, board);
    }
    /**
     * Mutates list moves by adding all possible
     * promotion moves with destination dest. Takes
     * in relative coordinates.
     */
    private void addPromoteMoves (int[] pos, int[] dest, Piece pawn, Board board) {
        String[] pieces = {"knight", "bishop", "rook", "queen"};
        for (String p : pieces) { // creates move instance for each promotion option
            int[] destAbs = board.switchCoords(dest);
            PromoteMove promote = new PromoteMove(board.switchCoords(pos), destAbs, p);
            this.moves.add(promote);
        }
    }
}
