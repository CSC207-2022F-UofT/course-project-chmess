import java.util.List;
public class Player {
    public String name;
    private char color;
    private List<Piece> pieces;
    private int points = 0;
    private List<Piece> capturedPieces;

    public Player (String name, char color) {
        this.name = name;
        this.color = color;
        // implement: get players pieces from board.pieces and store in this.pieces
    }

    public Player copy() {
        // placeholder
        return null;
    }

    public String getName() {
        return this.name;
    }

    public char getColor() {
        return this.color;
    }

    public int getPoints() {
        return this.points;
    }

    public void addCapturedPiece (Piece captured) {
        this.points += captured.getPointValue();
        this.capturedPieces.add(captured);
    }

    public List<Piece> getCapturedPieces () {
        return this.capturedPieces;
    }
}
