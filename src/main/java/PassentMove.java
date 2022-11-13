public class PassentMove extends Move {
    public PassentMove(int[] origin, int[] destination) {
        super(origin, destination);
    }
    /**
     * Mutates board to reflect en passent. Calls Try
     * method from super class to move pawn to destination
     * and also removes pawn being captured.
     */
    public void Try (Board board) {

    }
}
