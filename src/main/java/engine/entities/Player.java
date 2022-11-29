import java.util.List;
import engine.entities.copy.PlayerCopier;

public class Player {
    public String name;
    private char color; // 'w' or 'b'
    private List<Piece> pieces;
    private int points = 0;
    private List<Piece> capturedPieces;

    public Player (String name, char color) {
        this.name = name;
        this.color = color;
        // implement: get players pieces from board.pieces and store in this.pieces
    }

    /*
     * Returns a deep copy of the player class
     */
    public Player copy() {
        PlayerCopier pc = new PlayerCopier();
        return pc.createCopy(this);
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

    public void addCapturedPiece(Piece captured) {
        this.points += captured.getPointValue();
        this.capturedPieces.add(captured);
    }

    public List<Piece> getCapturedPieces() {
        return this.capturedPieces;
    }

    public List<Piece> getPieceList() {
        return this.pieces;
    }

    public void addPiece(Piece piece) {
        this.capturedPieces.add(piece);
    }
}
