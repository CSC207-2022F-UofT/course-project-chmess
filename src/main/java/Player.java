import java.util.List;
public class Player {
    public String name;
    public char color;
    public List<Piece> pieces;
    public int points = 0;
    public List<Piece> capturedPieces;

    public Player (String name, char color) {
        this.name = name;
        this.color = color;
        // implement: get players pieces from board.pieces and store in this.pieces
    }
    // are we updating points and captured Pieces here or is that happening somewhere else?
}
