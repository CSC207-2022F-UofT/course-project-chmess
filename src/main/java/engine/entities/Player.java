package engine.entities;

import engine.move.Move;

import java.util.List;
import java.util.ArrayList;

import engine.entities.copy.PlayerCopier;

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
        this.pieces = new ArrayList<Piece>();
        // implement: get players pieces from board.pieces and store in this.pieces
    }

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

    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public void addCapturedPiece (Piece captured) {
        captured.remove();
        this.points += captured.getPointValue();
        this.capturedPieces.add(captured);
    }

    public List<Piece> getCapturedPieces () {
        return this.capturedPieces;
    }

    public List<Piece> getPieceList () {
        return this.pieces;
    }

    public void addPiece(Piece newPiece) {
        this.pieces.add(newPiece);
    }
    /**
     * Returns all moves a player can make.
     */
    public List<Move> generatePlayerMoves (Board board) {
        List<Move> moves = new ArrayList<Move>();
        for (Piece piece : this.pieces) if (piece.isOnBoard()) {


            moves.addAll(piece.generateMoves(board));
        }
        return moves;
    }

}
