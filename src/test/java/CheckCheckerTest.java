import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import engine.CheckChecker;
import engine.entities.*;

class CheckCheckerTest {
    private PieceFactory pf = new PieceFactory();
    private CheckChecker cc = new CheckChecker();
    /*
    @Test
    public void DefaultBoard() {
        Player p1 = new Player("p1", 'W');
        Player p2 = new Player("p1", 'B');
        Board board = (new BoardCreator(p1, p2)).create();
        System.out.println(board.getPieceAtAbsCoords(0, 0).getType());

        Assertions.assertFalse(cc.isPlayerInCheck(board, 'W'));
        Assertions.assertFalse(cc.isPlayerInCheck(board, 'B'));
    }
    */

    @Test
    public void SimpleCheck() {
        Board board = createEmptyBoard('W');
        createAndPlacePiece("king", 'W', board, 0, 0);
        createAndPlacePiece("rook", 'B', board, 0, 7);
        Assertions.assertTrue(cc.isPlayerInCheck(board, 'W'));
    }

    protected Piece createAndPlacePiece(String type, char color, Board board, int x, int y) {
        Piece piece = pf.create(type);
        piece.setColor(color);
        board.setPieceAtAbsCoords(x, y, piece);
        piece.setCoords(x, y);
        return piece;
    }

    protected Board createEmptyBoard(char currentPlayerColor) {
        Board board = new Board();
        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        Player[] players = {p1, p2};
        board.setPlayers(players);
        if (currentPlayerColor == 'W') {
            board.setCurrentPlayer(0);
        } else {
            board.setCurrentPlayer(1);
        }

        return board;
    }


    Player p1,p2;
    Piece king1,king2,queen,pawn,knight,rook,bishop,friendlyPiece;
    private void init() {
        p1 = new Player("p1", 'W');
        p2 = new Player("p1", 'B');
        king1=new PieceFactory().create("king");
        king1.setColor('W');
        king1.setType("king");
        king2=new PieceFactory().create("king");
        king2.setColor('B');
        king2.setType("king");
        queen=new PieceFactory().create("queen");
        queen.setColor('B');
        queen.setType("queen");
        rook=new PieceFactory().create("rook");
        rook.setColor('B');
        rook.setType("rook");
        pawn=new PieceFactory().create("pawn");
        pawn.setColor('B');
        pawn.setType("pawn");
        knight=new PieceFactory().create("knight");
        knight.setColor('B');
        knight.setType("knight");
        bishop=new PieceFactory().create("bishop");
        bishop.setColor('B');
        bishop.setType("bishop");
        friendlyPiece=new PieceFactory().create("pawn");
        friendlyPiece.setColor('W');
        friendlyPiece.setType("pawn");
    }

    @Test
    public void KingAndQueen() {
        init();

        Board board1 = new Board();
        board1.setPieceAtAbsCoords(7,7,king2);
        board1.setPieceAtAbsCoords(4,4,king1);
        board1.setPieceAtAbsCoords(4,6,queen);
        board1.setPlayers(new Player[]{p1, p2});

        board1.getPlayers()[0].setPieces(board1.getAllPiecesForColor(board1.getPlayers()[0].getColor()));
        board1.getPlayers()[1].setPieces(board1.getAllPiecesForColor(board1.getPlayers()[1].getColor()));

        Assertions.assertTrue(cc.isPlayerInCheck(board1,'W'));
        Assertions.assertFalse(cc.isPlayerInCheck(board1,'B'));


        Board board2 = new Board();
        board2.setPieceAtAbsCoords(7,7,king2);
        board2.setPieceAtAbsCoords(4,4,king1);
        board2.setPieceAtAbsCoords(5,6,queen);

        board2.setPlayers(new Player[]{p1, p2});
        board2.getPlayers()[0].setPieces(board2.getAllPiecesForColor(board2.getPlayers()[0].getColor()));
        board2.getPlayers()[1].setPieces(board2.getAllPiecesForColor(board2.getPlayers()[1].getColor()));
        Assertions.assertFalse(cc.isPlayerInCheck(board2,'W'));
        Assertions.assertFalse(cc.isPlayerInCheck(board2,'B'));
    }

    @Test
    public void KingAndPawn() {
        init();

        Board board1 = new Board();
        board1.setPlayers(new Player[]{p1, p2});
        board1.setPieceAtAbsCoords(7,7,king2);
        board1.setPieceAtAbsCoords(5,5,king1);
        board1.setPieceAtAbsCoords(6,6,pawn);
        board1.setPlayers(new Player[]{p1, p2});
        board1.getPlayers()[0].setPieces(board1.getAllPiecesForColor(board1.getPlayers()[0].getColor()));
        board1.getPlayers()[1].setPieces(board1.getAllPiecesForColor(board1.getPlayers()[1].getColor()));
        Assertions.assertTrue(cc.isPlayerInCheck(board1,'W'));
        Assertions.assertFalse(cc.isPlayerInCheck(board1,'B'));


        Board board2 = new Board();
        board2.setPlayers(new Player[]{p1, p2});
        board2.setPieceAtAbsCoords(7,7,king2);
        board2.setPieceAtAbsCoords(5,5,king1);
        board2.setPieceAtAbsCoords(3,4,pawn);
        board2.getPlayers()[0].setPieces(board2.getAllPiecesForColor(board2.getPlayers()[0].getColor()));
        board2.getPlayers()[1].setPieces(board2.getAllPiecesForColor(board2.getPlayers()[1].getColor()));
        Assertions.assertFalse(cc.isPlayerInCheck(board2,'W'));
        Assertions.assertFalse(cc.isPlayerInCheck(board2,'B'));

    }
    @Test
    public void KingAndBishop() {
        init();

        Board board1 = new Board();
        board1.setPlayers(new Player[]{p1, p2});
        board1.setPieceAtAbsCoords(7,7,king2);
        board1.setPieceAtAbsCoords(4,4,king1);
        board1.setPieceAtAbsCoords(6,6,bishop);
        board1.getPlayers()[0].setPieces(board1.getAllPiecesForColor(board1.getPlayers()[0].getColor()));
        board1.getPlayers()[1].setPieces(board1.getAllPiecesForColor(board1.getPlayers()[1].getColor()));
        Assertions.assertTrue(cc.isPlayerInCheck(board1,'W'));
        Assertions.assertFalse(cc.isPlayerInCheck(board1,'B'));


        Board board2 = new Board();
        board2.setPlayers(new Player[]{p1, p2});
        board2.setPieceAtAbsCoords(7,7,king2);
        board2.setPieceAtAbsCoords(4,4,king1);
        board2.setPieceAtAbsCoords(5,6,bishop);
        board2.getPlayers()[0].setPieces(board2.getAllPiecesForColor(board2.getPlayers()[0].getColor()));
        board2.getPlayers()[1].setPieces(board2.getAllPiecesForColor(board2.getPlayers()[1].getColor()));
        Assertions.assertFalse(cc.isPlayerInCheck(board2,'W'));
        Assertions.assertFalse(cc.isPlayerInCheck(board2,'B'));

    }
    @Test
    public void KingAndKnight() {
        init();

        Board board1 = new Board();
        board1.setPlayers(new Player[]{p1, p2});
        board1.setPieceAtAbsCoords(7,7,king2);
        board1.setPieceAtAbsCoords(4,4,king1);
        board1.setPieceAtAbsCoords(5,6,knight);
        board1.getPlayers()[0].setPieces(board1.getAllPiecesForColor(board1.getPlayers()[0].getColor()));
        board1.getPlayers()[1].setPieces(board1.getAllPiecesForColor(board1.getPlayers()[1].getColor()));
        Assertions.assertTrue(cc.isPlayerInCheck(board1,'W'));
        Assertions.assertFalse(cc.isPlayerInCheck(board1,'B'));


        Board board2 = new Board();
        board2.setPlayers(new Player[]{p1, p2});
        board2.setPieceAtAbsCoords(7,7,king2);
        board2.setPieceAtAbsCoords(4,4,king1);
        board2.setPieceAtAbsCoords(5,5,knight);
        board2.getPlayers()[0].setPieces(board2.getAllPiecesForColor(board2.getPlayers()[0].getColor()));
        board2.getPlayers()[1].setPieces(board2.getAllPiecesForColor(board2.getPlayers()[1].getColor()));
        Assertions.assertFalse(cc.isPlayerInCheck(board2,'W'));
        Assertions.assertFalse(cc.isPlayerInCheck(board2,'B'));

    }
    @Test
    public void KingAndRook() {

        init();

        Board board1 = new Board();
        board1.setPlayers(new Player[]{p1, p2});
        board1.setPieceAtAbsCoords(7,7,king2);
        board1.setPieceAtAbsCoords(4,4,king1);
        board1.setPieceAtAbsCoords(4,2,rook);
        board1.getPlayers()[0].setPieces(board1.getAllPiecesForColor(board1.getPlayers()[0].getColor()));
        board1.getPlayers()[1].setPieces(board1.getAllPiecesForColor(board1.getPlayers()[1].getColor()));
        Assertions.assertTrue(cc.isPlayerInCheck(board1,'W'));
        Assertions.assertFalse(cc.isPlayerInCheck(board1,'B'));


        Board board2 = new Board();
        board2.setPlayers(new Player[]{p1, p2});
        board2.setPieceAtAbsCoords(7,7,king2);
        board2.setPieceAtAbsCoords(4,4,king1);
        board2.setPieceAtAbsCoords(3,5,rook);
        board2.getPlayers()[0].setPieces(board2.getAllPiecesForColor(board2.getPlayers()[0].getColor()));
        board2.getPlayers()[1].setPieces(board2.getAllPiecesForColor(board2.getPlayers()[1].getColor()));
        Assertions.assertFalse(cc.isPlayerInCheck(board2,'W'));
        Assertions.assertFalse(cc.isPlayerInCheck(board2,'B'));
    }

    @Test
    public void pieceBetweenKingAndQueen() {
        init();

        Board board1 = new Board();
        board1.setPlayers(new Player[]{p1, p2});
        board1.setPieceAtAbsCoords(7,7,king2);
        board1.setPieceAtAbsCoords(4,4,king1);
        board1.setPieceAtAbsCoords(6,4,queen);
        board1.setPieceAtAbsCoords(5,4,friendlyPiece);
        board1.getPlayers()[0].setPieces(board1.getAllPiecesForColor(board1.getPlayers()[0].getColor()));
        board1.getPlayers()[1].setPieces(board1.getAllPiecesForColor(board1.getPlayers()[1].getColor()));
        Assertions.assertFalse(cc.isPlayerInCheck(board1,'W'));
        Assertions.assertFalse(cc.isPlayerInCheck(board1,'B'));
    }

    @Test
    public void pieceBetweenKingAndBishop() {
        init();

        Board board1 = new Board();
        board1.setPlayers(new Player[]{p1, p2});
        board1.setPieceAtAbsCoords(7,7,king2);
        board1.setPieceAtAbsCoords(4,4,king1);
        board1.setPieceAtAbsCoords(2,2,bishop);
        board1.setPieceAtAbsCoords(3,3,friendlyPiece);
        board1.getPlayers()[0].setPieces(board1.getAllPiecesForColor(board1.getPlayers()[0].getColor()));
        board1.getPlayers()[1].setPieces(board1.getAllPiecesForColor(board1.getPlayers()[1].getColor()));
        Assertions.assertFalse(cc.isPlayerInCheck(board1,'W'));
        Assertions.assertFalse(cc.isPlayerInCheck(board1,'B'));
    }
    @Test
    public void pieceBetweenKingAndRook() {
        init();

        Board board1 = new Board();
        board1.setPlayers(new Player[]{p1, p2});
        board1.setPieceAtAbsCoords(7,7,king2);
        board1.setPieceAtAbsCoords(4,4,king1);
        board1.setPieceAtAbsCoords(6,4,rook);
        board1.setPieceAtAbsCoords(5,4,friendlyPiece);
        board1.getPlayers()[0].setPieces(board1.getAllPiecesForColor(board1.getPlayers()[0].getColor()));
        board1.getPlayers()[1].setPieces(board1.getAllPiecesForColor(board1.getPlayers()[1].getColor()));
        Assertions.assertFalse(cc.isPlayerInCheck(board1,'W'));
        Assertions.assertFalse(cc.isPlayerInCheck(board1,'B'));

    }

    @Test
    public void twoPieces() {
        init();

        Board board1 = new Board();
        board1.setPlayers(new Player[]{p1, p2});
        board1.setPieceAtAbsCoords(7,7,king2);
        board1.setPieceAtAbsCoords(4,4,king1);
        board1.setPieceAtAbsCoords(6,6,rook);
        board1.setPieceAtAbsCoords(4,5,queen);
        board1.getPlayers()[0].setPieces(board1.getAllPiecesForColor(board1.getPlayers()[0].getColor()));
        board1.getPlayers()[1].setPieces(board1.getAllPiecesForColor(board1.getPlayers()[1].getColor()));
        Assertions.assertTrue(cc.isPlayerInCheck(board1,'W'));
        Assertions.assertFalse(cc.isPlayerInCheck(board1,'B'));

        Board board2 = new Board();
        board2.setPlayers(new Player[]{p1, p2});
        board2.setPieceAtAbsCoords(7,7,king2);
        board2.setPieceAtAbsCoords(4,4,king1);
        board2.setPieceAtAbsCoords(6,6,rook);
        board2.setPieceAtAbsCoords(5,6,queen);

        board2.getPlayers()[0].setPieces(board2.getAllPiecesForColor(board2.getPlayers()[0].getColor()));
        board2.getPlayers()[1].setPieces(board2.getAllPiecesForColor(board2.getPlayers()[1].getColor()));
        Assertions.assertFalse(cc.isPlayerInCheck(board2,'W'));
        Assertions.assertFalse(cc.isPlayerInCheck(board2,'B'));
    }
}
