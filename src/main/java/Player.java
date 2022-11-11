import java.util.List;
public class Player {
    public String name;
    public char color;
    public List<Piece> pieces;
    private int points = 0;
    private List<Piece> capturedPieces;

    public Player (String name, char color) {
        this.name = name;
        this.color = color;
        // implement: get players pieces from board.pieces and store in this.pieces
    }

    public Player copy() {}

    public String getName() {}

    public String getColor() {}

    public int getPoints() {}

    public void addCapturedPiece (Piece captured) {
        this.points += captured.pointValue;
        this.capturedPieces.add(captured);
    }

    public List<Piece> getCapturedPieces () {
        return this.capturedPieces;
    }
}
