package engine.entities;

import engine.move.Move;

import java.util.List;
import java.util.ArrayList;

public class Player {
    public String name;
    private char color;
    private List<Piece> pieces;
    private int points = 0;
    private List<Piece> capturedPieces;

    public Player (String name, char color) {
        this.name = name;
        this.color = color;
        this.capturedPieces = new ArrayList<Piece>();
        // implement: get players pieces from board.pieces and store in this.pieces
    }

    public Player copy() {
        // TODO
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
    /**
     * Returns all moves a player can make.
     */
    public List<Move> generatePlayerMoves () {
        List<Move> moves = new ArrayList<Move>();
        for (Piece piece : this.pieces) {
            moves.addAll(piece.generateMoves());
        }
        return moves;
    }
}
