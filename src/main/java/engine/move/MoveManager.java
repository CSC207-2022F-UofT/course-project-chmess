package engine.move;

import engine.CheckChecker;
import engine.MoveExecutor;
import engine.entities.Board;
import engine.entities.Game;
import engine.entities.Piece;
import engine.entities.Player;
import engine.entities.copy.BoardCopier;


import java.util.ArrayList;
import java.util.List;
import engine.move.*;

import javax.swing.border.Border;

public class MoveManager {
    public MoveManager() {}

    //use to debug
    public static void display(Board board) {
        board.selectDefaultPov();
        for (int y = 0; y < Board.HEIGHT; y++) {
            for (int x = 0; x < Board.WIDTH; x++) {
                Piece piece = board.getPieceAtRelCoords(x, y);
                if (piece == null) {
                    System.out.print(".");
                } else {
                    String type = piece.getType();
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
                        default:
                            pieceChar = '.';
                            break;
                    }
                    if (piece.getColor() == 'W') {
                        System.out.print(Character.toUpperCase(pieceChar));
                    } else {
                        System.out.print(pieceChar);
                    }
                }
            }
            System.out.print("\n");
        }
    }


    private static void updateGamestate(Game game) {
        Player player=game.getBoard().getCurrentPlayer();
        if (CheckChecker.isPlayerInCheck(game.getBoard(), player.getColor())) {
            boolean canBreak=false;
            List<Piece> pieces=game.getBoard().getAllPiecesForColor(player.getColor());
            for (Piece p:pieces) {
                for (Move trymove:p.generateMoves(game.getBoard())) {
                    Board tryBreak=BoardCopier.createCopy(game.getBoard());
                    MoveExecutor.execute(tryBreak, trymove);
                    if (!CheckChecker.isPlayerInCheck(tryBreak, player.getColor())) {

                        //display(tryBreak);
                        canBreak=true;
                        break;
                    }
                }
                if (canBreak) break;
            }
            if (!canBreak) game.setGameState('#');
        }
    }
    /**
     * Makes the given move on the given game.
     * This includes updating the board reference in Game,
     * updating players and their points and pieces captured,
     * and updating the Game state (stalemate/checkmate/neither).
     * Note: In the current implementation, players are stored only in boards.
     *
     * @param game
     * @param move
     */
    public static void makeMove(Game game, Move move) {
        // make new board
        Board oldBoard = game.getBoard();
        game.setBoard(BoardCopier.createCopy(oldBoard));
        game.getBoard().setPreviousBoard(oldBoard);
        // mutate board with move
        /*
        for (Piece p:game.getPlayers()[0].getPieceList()) {
            System.out.print(p.getCoords()[0]);
            System.out.print(p.getCoords()[1]);
            System.out.print(p.getColor());
            System.out.print(p.getType());
            System.out.println(' ');
        }
        Board board=oldBoard;
        for (int y = Board.HEIGHT-1; y>=0; y--) {
            for (int x=0; x<Board.WIDTH; x++) {
                Piece piece = board.getPieceAtRelCoords(x, y);
                if (piece == null) {
                    System.out.print(".");
                } else {
                    String type = piece.getType();
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
                        default:
                            pieceChar = '.';
                            break;
                    }
                    if (piece.getColor() == 'W') {
                        System.out.print(Character.toUpperCase(pieceChar));
                    } else {
                        System.out.print(pieceChar);
                    }
                }
            }
            System.out.print("\n");
        }*/

        MoveExecutor.execute(game.getBoard(), move);





        updateGamestate(game);

    }

    /**
     * Undoes the last move on the given game.
     * This includes updating the board reference in Game,
     * updating players and their points and pieces captured,
     * and updating the Game state (stalemate/checkmate/neither).
     * Note: In the current implementation, players are stored only in boards.
     *
     * @param game
     */
    public static void undoLastMove(Game game) {

        game.setBoard(game.getBoard().getPreviousBoard());
    }

    /**
     * Converts algebraic notation to move instance and returns
     * that move instance.
     *
     * @param moveString String representing algebraic notation of move
     * @return move instance
     */
    public static Move getMoveFromNotation(Game game, String moveString) {
        // calls Move constructor to create new instance of move
        int[] ori = new int[2];
        int[] dest = new int[2];
        ori[0] = moveString.charAt(0);
        ori[1] = moveString.charAt(1);
        dest[0] = moveString.charAt(3);
        dest[1] = moveString.charAt(4);
        return new Move (ori, dest);
/*
        String[] pieceStrings = {"k", "q", "r", "b", "n"};
        String[] moveParams = moveString.split("");

        Board board = game.getBoard();

        if ("O-O".equals(moveString)) {
            if (board.getCurrentPlayer().getColor() == 'W') {
                CastleMove castle = new CastleMove(new int[]{4, 7}, new int[]{6, 7});
            } else {
                CastleMove castle = new CastleMove(new int[]{4, 0}, new int[]{6, 0});
            }
        } else if ("O-O-O".equals(moveString)) {
            if (board.getCurrentPlayer().getColor() == 'W') {
                CastleMove castle = new CastleMove(new int[]{4, 7}, new int[]{6, 7});
            } else {
                CastleMove castle = new CastleMove(new int[]{4, 0}, new int[]{6, 0});
            }
        } else if (moveString.contains("=")) {
            throw new java.lang.UnsupportedOperationException("Not supported yet.");
            //Move move = new PromoteMove();

        } else if (moveString.contains("x")) {
            throw new java.lang.UnsupportedOperationException("Not supported yet.");
            //Move move = new Move();

        } else {
            throw new java.lang.UnsupportedOperationException("Not supported yet.");
            //Move move = new Move();
        }

        return null; */

    }
}
