package engine.entities;

import java.util.List;

import engine.move.Move;
import engine.movegen.MovesGenerator;

import engine.entities.copy.PieceCopier;

public class Piece {
    private char color;
    private String type;
    private int[] coords;
    private int pointValue;
    private MovesGenerator mg;
    private boolean hasMoved = false;

    public Piece() {
        this.coords = new int[2];
    }

    /**
     * Returns a semi-deep clone of the Piece object.
     * More precisely, the coords array is replaced with a clone.
     * (The Player object is not replaced.)
     *
     * @return a clone of this piece
     */
    public Piece copy() {
        PieceCopier pc = new PieceCopier();
        return pc.createCopy(this);
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        //Returns P for pawn, B for bishop, N for knight, 
        //R for rook, Q for queen, K for king
        return this.type;
    }

    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }

    public int getPointValue() {
        return this.pointValue;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public char getColor() {
        return this.color;
    }

    /**
     * Records that this piece has made its first move.
     */
    public void setHasMadeFirstMove() {
        hasMoved = true;
    }

    /**
     * Returns whether this piece has made its first move/
     *
     * @return whether this piece has made its first move
     */
    public boolean hasMadeFirstMove() {
        return hasMoved;
    }

    public void setCoords(int x, int y) {
        this.coords[0] = x;
        this.coords[1] = y;
    }

    public int[] getCoords() {
        return this.coords;
    }

    /**
     * Returns a list of semivalid moves that this piece can make.
     * A semivalid move is one which is valid in almost every way,
     * except it could possibly put one's own King in check.
     *
     * @return list of semivalid moves
     */
    public List<Move> generateMoves() {
        // TODO. Note: Should use mg.
        // mg probably needs to take at least the board
        // and the coordinates of this piece (a priori
        // it knows nothing except *how* to generate moves)
        return null;
    }

    public void setMovesGenerator(MovesGenerator mg) {
        this.mg = mg;
    }

    public MovesGenerator getMovesGenerator() {
        return this.mg;
    }
}
