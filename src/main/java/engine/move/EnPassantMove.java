package engine.move;

public class EnPassantMove extends Move {
    public EnPassantMove(int[] origin, int[] destination) {
        super(origin, destination);
    }

    /**
     * Mutates board to reflect en passant. Calls Try
     * method from super class to move pawn to destination
     * and also removes pawn being captured.
     */
    @Override
    public void Try(Board board) {

    }
}
