package engine.move;

import engine.entities.Board;
import engine.entities.Piece;

/**
 * A representation of the most common move type.
 * Contrast with the anomalies
 * (1) castling, where multiple pieces move;
 * (2) promoting, where the moved piece changes type;
 * (3) en passant, where the captured piece's coordinates
 * do not match the capturing piece's destination.
 */
public class Move {
    public int[] origin;
    public int[] destination;

    /**
     * Creates a Move object with the given coordinate pairs.
     *
     * @param origin      the origin of the piece to be moved
     * @param destination the destination of the piece to be moved
     */
    public Move (int[] origin, int[] destination) {
        this.origin = origin;
        this.destination = destination;
    }

    /**
     * Returns the coordinates of the piece which is to be moved.
     *
     * @return the origin for this move
     */
    public int[] getOrigin() {
        return this.origin;
    }

    /**
     * Returns the destination coordinates of the piece which is to be moved.
     *
     * @return the destination for this move
     */
    public int[] getDestination() {
        return this.destination;
    }

    /**
     * Mutates the given board (as well as players and pieces within the board)
     * to reflect the state of the board after this move is made.
     * This includes advancing the current player and setting the first move.
     * Piece located on origin square is moved to destination square.
     * If destination square contains an enemy piece that piece is captured.
     *
     * @param board the board on which this move should be executed
     */
    public void execute(Board board) {
        Piece piece = board.getPieceAtAbsCoords(origin[0], origin[1]);
        Piece captured = removePiece(board, destination);

        if (captured != null) {
            board.getPlayerOfPiece(piece).addCapturedPiece(captured);
        }
        movePiece(board, origin, destination);

        // Might want to refactor to avoid this repetition.
        piece.setHasMadeFirstMove();
        board.advanceCurrentPlayer();
    }

    protected void placePiece(Piece piece, Board board, int[] dest) {
        piece.setCoords(dest[0], dest[1]);
        board.setPieceAtAbsCoords(dest[0], dest[1], piece);
    }

    protected void movePiece(Board board, int[] pos1, int[] pos2) {
        Piece piece = removePiece(board, pos1);
        placePiece(piece, board, pos2);
    }

    protected Piece removePiece(Board board, int[] pos) {
        Piece removed = board.getPieceAtAbsCoords(pos[0], pos[1]);
        board.setPieceAtAbsCoords(pos[0], pos[1], null);
        return removed;
    }

    /**
     * Returns the algebraic notation representing this move,
     * provided a board on which the move is being made.
     * The game state (check, checkmate) is omitted.
     *
     * @param board     the board on which this move is made
     * @return the (expanded) algebraic notation for a given move
     */
    public String getAlgebraicNotation(Board board) {
        Piece movingPiece = board.getPieceAtAbsCoords(origin[0], origin[1]);
        boolean isCapture = board.getPieceAtAbsCoords(destination[0], destination[1]) != null;

        StringBuilder sb = new StringBuilder();
        sb.append(getPieceString(movingPiece));
        sb.append(getChessCoords(origin));
        if (isCapture) {
            sb.append('x');
        }
        sb.append(getChessCoords(destination));
        return sb.toString();
    }
    /**
     * Converts algebraic notation to move instance and returns
     * that move instance.
     *
     * @param moveString String representing algebraic notation of move
     * @return move instance
     */
    public static Move getMoveFromNotation(String moveString) {
        // TODO
        // calls Move constructor to create new instance of move

        String[] pieceStrings = {"k", "q", "r", "b", "n"};
        String[] moveParams = moveString.split("");

//        if ("O-O".equals(moveString)) {
//            CastleMove castle = new CastleMove();
//        } else if ("O-O-O".equals(moveString)) {
//            // TODO
//            // castling
//        } else if (moveString.contains("=")) {
//            // TODO
//            // promotion
//        } else if (moveString.contains("x")) {
//            // TODO
//            // capture
//        } else {
//            // TODO
//            // normal move
//        }

        return null;
    }


    protected String getChessCoords(int[] coords) {
        int x = coords[0];
        int y = coords[1];
        char col = (char)((int) 'a' + x);
        String row = Integer.toString(y + 1);
        return col + row;
    }

    protected String getPieceString(Piece piece) {
        String type = piece.getType();

        if (type == "pawn") {
            return "";
        }

        char pieceChar = getPieceChar(type, piece.getColor());

        return Character.toString(pieceChar);
    }

    protected char getPieceChar(String type, char color) {
        char pieceChar;
        switch (type) {
            case "pawn":
                pieceChar = 'p';
                break;
            case "knight":
                pieceChar = 'n';
                break;
            case "bishop":
                pieceChar = 'b';
                break;
            case "rook":
                pieceChar = 'r';
                break;
            case "queen":
                pieceChar = 'q';
                break;
            case "king":
                pieceChar = 'k';
                break;
            // This never actually happens, but we do it to please the IDE :)
            default:
                pieceChar = ' ';
        }

        if (color == 'W') {
            return Character.toUpperCase(pieceChar);
        } else {
            return pieceChar;
        }
    }
}
