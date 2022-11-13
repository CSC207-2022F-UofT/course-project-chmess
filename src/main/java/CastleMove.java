public class CastleMove extends Move {
    public CastleMove(int[] origin, int[] destination) {
        super(origin, destination);
    }
    public void Try (Board board) {
        // mutates board to reflect castling where destination is king's destination
        // calls Try method from super class 2 times (once to move king and once to move rook)
    }
}
