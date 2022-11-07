import java.util.List;

public class Knight extends Piece {
    public int pointValue = 3;

    private List<Move> generateMoves() {
        int[] pos;
        pos = super.getCoordinates(); // get position of knight
        List<Move> moves = new List<Move>();
        int[][] add = {{2, 1}, {2, -1}, {1, 2}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}}; // to be added to pos
        for (int i = 0; i <= 7; i++) {
            moves.add(new Move(this, new int[]{pos[0] + add[i][0], pos[1] + add[i][1]})); // adds new Move instance to move
        }
        return moves;
    }
}
