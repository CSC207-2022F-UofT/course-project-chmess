import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerCopierTest {
    @Test
    public void PlayerDetailsCopied() {
        Player p = new Player("Player 1", 'W');
        Player p2 = p.copy();

        Assertions.assertTrue(p2.getName() == "Player 1");
        Assertions.assertTrue(p2.getColor() == 'W');
    }

    @Test
    public void PlayerMemoryDifferent() {
        Player p = new Player("Player 1", 'W');
        Player p2 = p.copy();

        Assertions.assertFalse(p == p2);
    }

    @Test
    public void PlayerPointValuePreserved() {
        Player p = new Player("Player 1", 'W');

        Piece pawn1 = new Piece();
        pawn1.setType("pawn");
        pawn1.setColor('W');
        pawn1.setCoords(0,1);
        pawn1.setPointValue(1);

        Piece pawn2 = new Piece();
        pawn2.setType("pawn");
        pawn2.setColor('W');
        pawn2.setCoords(1,1);
        pawn2.setPointValue(1);

        Piece pawn3 = new Piece();
        pawn3.setType("pawn");
        pawn3.setColor('B');
        pawn3.setCoords(1,7);
        pawn3.setPointValue(1);

        Piece rook1 = new Piece();
        rook1.setType("rook");
        rook1.setColor('W');
        rook1.setCoords(0,0);
        rook1.setPointValue(5);

        Piece rook2 = new Piece();
        rook2.setType("rook");
        rook2.setColor('B');
        rook2.setCoords(0,8);
        rook2.setPointValue(5);

        p.addPiece(pawn1);
        p.addPiece(pawn2);
        p.addPiece(rook1);
        p.addCapturedPiece(pawn3);
        p.addCapturedPiece(rook2);

        Player p2 = p.copy();

        Assertions.assertTrue(p2.getPoints() == p.getPoints());
    }

    @Test
    public void PlayerPieceListPreserved(){
        Player p = new Player("Player 1", 'W');

        Piece pawn1 = new Piece();
        pawn1.setType("pawn");
        pawn1.setColor('W');
        pawn1.setCoords(0,1);
        pawn1.setPointValue(1);

        Piece pawn2 = new Piece();
        pawn2.setType("pawn");
        pawn2.setColor('W');
        pawn2.setCoords(1,1);
        pawn2.setPointValue(1);

        Piece pawn3 = new Piece();
        pawn3.setType("pawn");
        pawn3.setColor('B');
        pawn3.setCoords(1,7);
        pawn3.setPointValue(1);

        Piece rook1 = new Piece();
        rook1.setType("rook");
        rook1.setColor('W');
        rook1.setCoords(0,0);
        rook1.setPointValue(5);

        Piece rook2 = new Piece();
        rook2.setType("rook");
        rook2.setColor('B');
        rook2.setCoords(0,8);
        rook2.setPointValue(5);

        p.addPiece(pawn1);
        p.addPiece(pawn2);
        p.addPiece(rook1);
        p.addCapturedPiece(pawn3);
        p.addCapturedPiece(rook2);

        Player p2 = p.copy();

        Assertions.assertTrue(p2.getPieceList().size() == p.getPieceList().size());
        Assertions.assertTrue(p2.getCapturedPieces().size() == p.getCapturedPieces().size());
    }

    @Test
    public void PlayerPiecesDeepCopied() {
        Player p = new Player("Player 1", 'W');

        Piece pawn1 = new Piece();
        pawn1.setType("pawn");
        pawn1.setColor('W');
        pawn1.setCoords(0,1);
        pawn1.setPointValue(1);

        Piece pawn2 = new Piece();
        pawn2.setType("pawn");
        pawn2.setColor('W');
        pawn2.setCoords(1,1);
        pawn2.setPointValue(1);

        Piece pawn3 = new Piece();
        pawn3.setType("pawn");
        pawn3.setColor('B');
        pawn3.setCoords(1,7);
        pawn3.setPointValue(1);

        Piece rook1 = new Piece();
        rook1.setType("rook");
        rook1.setColor('W');
        rook1.setCoords(0,0);
        rook1.setPointValue(5);

        Piece rook2 = new Piece();
        rook2.setType("rook");
        rook2.setColor('B');
        rook2.setCoords(0,8);
        rook2.setPointValue(5);

        p.addPiece(pawn1);
        p.addPiece(pawn2);
        p.addPiece(rook1);
        p.addCapturedPiece(pawn3);
        p.addCapturedPiece(rook2);

        Player p2 = p.copy();

        Assertions.assertFalse(p2.getPieceList().get(0) == p.getPieceList().get(0));
        Assertions.assertFalse(p2.getPieceList().get(1) == p.getPieceList().get(1));
        Assertions.assertFalse(p2.getCapturedPieces().get(0) == p.getCapturedPieces().get(0));
        Assertions.assertFalse(p2.getCapturedPieces().get(1) == p.getCapturedPieces().get(1));
    }
    
}
