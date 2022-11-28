import java.util.List;

public class KingMovesGen extends MovesGenerator {
    public KingMovesGen (Board board, Piece king) {


    }
    /**
     * Creates list of possible moves a king can
     * make which is later refined by PostMoveValidator.
     * Checks if king can move one square in any direction, or
     * castle. Any moves which are not on the board, or are
     * occupied by a friendly piece are removed from the list.
     * For castling, if squares in between King and Rook are
     * under attack the move is invalid and is removed.
     * Other than this special case, King checks are NOT
     * considered.
     */
    @Override
    public List<Move> generate (Board board, Piece king) {
        char color = king.getColor();
        if (color == 'W') { board.selectDefaultPov(); }
        else if (color == 'B') { board.selectMirrorPov(); }
        int[] pos = board.switchCoords(king.getCoords()); // get position of king in relative coords
        int[][] add = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
        for (int i = 0; i <= 7; i++) {
            this.moves.add(new Move(board.switchCoords(pos), board.switchCoords(new int[]{pos[0] + add[i][0], pos[1] + add[i][1]}))); // adds new Move instance to moves
        }
        Piece rook1 = board.getPieceAtRelCoords(7, 0);
        Piece rook2 = board.getPieceAtRelCoords(0, 0);
        if (king.hasMadeFirstMove() && rook1.getType().equals("rook") && rook1.hasMadeFirstMove()) { // TODO implement hasMadeFirstMove()
            if (notAttacked(new int[][]{{6, 0}, {5, 0}, {4, 0}}, board, color) && isEmpty(new int[][]{{6, 0}, {5, 0}}, board)) {
                this.moves.add(new CastleMove(board.switchCoords(pos), board.switchCoords(new int[] {6, 0})));
            }
        }
        if (king.hasMadeFirstMove() && rook2.getType().equals("rook") && rook2.hasMadeFirstMove()) {
            if (notAttacked(new int[][]{{1, 0}, {2, 0}, {3, 0}, {4, 0}}, board, color) && isEmpty(new int[][]{{1, 0}, {2, 0}, {3, 0}}, board)) {
                this.moves.add(new CastleMove(board.switchCoords(pos), board.switchCoords(new int[] {2, 0})));
            }
        }
        super.removeInvalid(this.moves, board);
        return this.moves;

    }
    /**
     * Checks that every coordinate in destinations
     * is NOT under attack. Takes in relative coordinates.
     */
    private boolean notAttacked(int[][] destinations, Board board, char color) {
        boolean notAttacking = true;
        List<Move> semiValid = board.semiValidMovesForColor(color);
        for (int[] d : destinations) {
            for (Move m : semiValid) {
                if (m.destination == board.switchCoords(d)) { notAttacking = false; }
            }
        }
        return notAttacking;
    }
    /**
     * Checks to see whether destination of move is already
     * occupied by any piece. Takes in relative coordinates.
     */
    private boolean isEmpty (int[][] coords, Board board) {
        boolean empty = true;
        for (int[] coord : coords) {
            Move testMove = new Move(new int[] {0, 0}, board.switchCoords(coord));
            if (isOccupiedByFriendly(testMove, board) || isOccupiedByEnemy(testMove, board)) { empty = false; }
        }
        return empty;
    }
}
