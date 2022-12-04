import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import engine.CheckChecker;
import engine.entities.*;

class CheckCheckerTest {
    CheckChecker cc = new CheckChecker();
    Player p1,p2;
    Piece king1,king2,queen,pawn,knight,rook,bishop,friendlyPiece;
    private void init() {
        p1 = new Player("p1", 'W');
        p2 = new Player("p1", 'B');
        king1=new Piece();
        king1.setColor('W');
        king1.setType("king");
        king2=new Piece();
        king2.setColor('B');
        king2.setType("king");
        queen=new Piece();
        queen.setColor('B');
        queen.setType("queen");
        rook=new Piece();
        rook.setColor('B');
        rook.setType("rook");
        pawn=new Piece();
        pawn.setColor('B');
        pawn.setType("pawn");
        knight=new Piece();
        knight.setColor('B');
        knight.setType("knight");
        bishop=new Piece();
        bishop.setColor('B');
        bishop.setType("bishop");
        friendlyPiece=new Piece();
        friendlyPiece.setColor('W');
        friendlyPiece.setType("pawn");
    }
    @Test
    public void DefaultBoard() {
        init();
        Board board = (new BoardCreator(p1, p2)).create();

        Assertions.assertFalse(cc.isPlayerInCheck(board,p1));
        Assertions.assertFalse(cc.isPlayerInCheck(board,p2));

    }

    @Test
    public void KingAndQueen() {
        init();

        Board board1 = new Board();
        board1.setPieceAtAbsCoords(7,7,king2);
        board1.setPieceAtAbsCoords(4,4,king1);
        board1.setPieceAtAbsCoords(4,6,queen);
        Assertions.assertTrue(cc.isPlayerInCheck(board1,p1));
        Assertions.assertFalse(cc.isPlayerInCheck(board1,p2));


        Board board2 = new Board();
        board2.setPieceAtAbsCoords(7,7,king2);
        board2.setPieceAtAbsCoords(4,4,king1);
        board2.setPieceAtAbsCoords(5,6,queen);
        Assertions.assertFalse(cc.isPlayerInCheck(board2,p1));
        Assertions.assertFalse(cc.isPlayerInCheck(board2,p2));
    }

    @Test
    public void KingAndPawn() {
        init();

        Board board1 = new Board();
        board1.setPieceAtAbsCoords(7,7,king2);
        board1.setPieceAtAbsCoords(4,4,king1);
        board1.setPieceAtAbsCoords(5,5,pawn);
        Assertions.assertTrue(cc.isPlayerInCheck(board1,p1));
        Assertions.assertFalse(cc.isPlayerInCheck(board1,p2));


        Board board2 = new Board();
        board2.setPieceAtAbsCoords(7,7,king2);
        board2.setPieceAtAbsCoords(4,4,king1);
        board2.setPieceAtAbsCoords(3,3,pawn);
        Assertions.assertFalse(cc.isPlayerInCheck(board2,p1));
        Assertions.assertFalse(cc.isPlayerInCheck(board2,p2));

    }
    @Test
    public void KingAndBishop() {
        init();

        Board board1 = new Board();
        board1.setPieceAtAbsCoords(7,7,king2);
        board1.setPieceAtAbsCoords(4,4,king1);
        board1.setPieceAtAbsCoords(6,6,bishop);
        Assertions.assertTrue(cc.isPlayerInCheck(board1,p1));
        Assertions.assertFalse(cc.isPlayerInCheck(board1,p2));


        Board board2 = new Board();
        board2.setPieceAtAbsCoords(7,7,king2);
        board2.setPieceAtAbsCoords(4,4,king1);
        board2.setPieceAtAbsCoords(5,6,bishop);
        Assertions.assertFalse(cc.isPlayerInCheck(board2,p1));
        Assertions.assertFalse(cc.isPlayerInCheck(board2,p2));

    }
    @Test
    public void KingAndKnight() {
        init();

        Board board1 = new Board();
        board1.setPieceAtAbsCoords(7,7,king2);
        board1.setPieceAtAbsCoords(4,4,king1);
        board1.setPieceAtAbsCoords(5,6,knight);
        Assertions.assertTrue(cc.isPlayerInCheck(board1,p1));
        Assertions.assertFalse(cc.isPlayerInCheck(board1,p2));


        Board board2 = new Board();
        board2.setPieceAtAbsCoords(7,7,king2);
        board2.setPieceAtAbsCoords(4,4,king1);
        board2.setPieceAtAbsCoords(5,5,knight);
        Assertions.assertFalse(cc.isPlayerInCheck(board2,p1));
        Assertions.assertFalse(cc.isPlayerInCheck(board2,p2));

    }
    @Test
    public void KingAndRook() {

        init();

        Board board1 = new Board();
        board1.setPieceAtAbsCoords(7,7,king2);
        board1.setPieceAtAbsCoords(4,4,king1);
        board1.setPieceAtAbsCoords(4,2,rook);
        Assertions.assertTrue(cc.isPlayerInCheck(board1,p1));
        Assertions.assertFalse(cc.isPlayerInCheck(board1,p2));


        Board board2 = new Board();
        board2.setPieceAtAbsCoords(7,7,king2);
        board2.setPieceAtAbsCoords(4,4,king1);
        board2.setPieceAtAbsCoords(3,5,rook);
        Assertions.assertFalse(cc.isPlayerInCheck(board2,p1));
        Assertions.assertFalse(cc.isPlayerInCheck(board2,p2));
    }

    @Test
    public void pieceBetweenKingAndQueen() {
        init();

        Board board1 = new Board();
        board1.setPieceAtAbsCoords(7,7,king2);
        board1.setPieceAtAbsCoords(4,4,king1);
        board1.setPieceAtAbsCoords(4,6,queen);
        board1.setPieceAtAbsCoords(4,5,friendlyPiece);
        Assertions.assertFalse(cc.isPlayerInCheck(board1,p1));
        Assertions.assertFalse(cc.isPlayerInCheck(board1,p2));
    }

    @Test
    public void pieceBetweenKingAndBishop() {
        init();

        Board board1 = new Board();
        board1.setPieceAtAbsCoords(7,7,king2);
        board1.setPieceAtAbsCoords(4,4,king1);
        board1.setPieceAtAbsCoords(6,6,bishop);
        board1.setPieceAtAbsCoords(5,5,friendlyPiece);
        Assertions.assertFalse(cc.isPlayerInCheck(board1,p1));
        Assertions.assertFalse(cc.isPlayerInCheck(board1,p2));
    }
    @Test
    public void pieceBetweenKingAndRook() {
        init();

        Board board1 = new Board();
        board1.setPieceAtAbsCoords(7,7,king2);
        board1.setPieceAtAbsCoords(4,4,king1);
        board1.setPieceAtAbsCoords(4,6,rook);
        board1.setPieceAtAbsCoords(4,5,friendlyPiece);
        Assertions.assertFalse(cc.isPlayerInCheck(board1,p1));
        Assertions.assertFalse(cc.isPlayerInCheck(board1,p2));

    }

    @Test
    public void twoPieces() {
        init();

        Board board1 = new Board();
        board1.setPieceAtAbsCoords(7,7,king2);
        board1.setPieceAtAbsCoords(4,4,king1);
        board1.setPieceAtAbsCoords(6,6,rook);
        board1.setPieceAtAbsCoords(4,5,queen);
        Assertions.assertTrue(cc.isPlayerInCheck(board1,p1));
        Assertions.assertFalse(cc.isPlayerInCheck(board1,p2));

        Board board2 = new Board();
        board2.setPieceAtAbsCoords(7,7,king2);
        board2.setPieceAtAbsCoords(4,4,king1);
        board2.setPieceAtAbsCoords(6,6,rook);
        board2.setPieceAtAbsCoords(5,6,queen);
        Assertions.assertFalse(cc.isPlayerInCheck(board1,p1));
        Assertions.assertFalse(cc.isPlayerInCheck(board1,p2));
    }

}
