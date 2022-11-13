public class PassentMove extends Move {
    public PassentMove(int[] origin, int[] destination) {
        super(origin, destination);
    }
    public void Try (Board board) {
        // mutates board to reflect en passent
        // calls Try method from super class to move pawn to destination and also removes pawn being captured
    }
}
