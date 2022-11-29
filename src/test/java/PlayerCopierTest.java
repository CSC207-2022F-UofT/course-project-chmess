import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import engine.entities.Board;
import engine.entities.Piece;
import engine.entities.Player;
import engine.entities.PieceFactory;

class PlayerCopierTest {
    @Test
    public void PlayerDetailsCopied() {
        Player p = new Player("Player 1", 'W');
        Player p2 = p.copy();

        System.out.println(p.getName());
        System.out.println(p2.getName());

        Assertions.assertSame("Player 1", p2.getName());
        Assertions.assertSame('W', p2.getColor());
    }

    @Test
    public void PlayerMemoryDifferent() {
        Player p = new Player("Player 1", 'W');
        Player p2 = p.copy();

        Assertions.assertNotSame(p, p2);
    }

    @Test
    public void PlayerPointValuePreserved() {
        Player p = new Player("Player 1", 'W');

        PieceFactory pf = new PieceFactory();

        Piece pawn1 = pf.create("pawn", 'W');
        pawn1.setCoords(0,1);

        Piece pawn2 = pf.create("pawn", 'W');
        pawn2.setCoords(1,1);

        Piece pawn3 = pf.create("pawn", 'B');
        pawn3.setCoords(1,7);

        Piece rook1 = pf.create("rook", 'W');
        rook1.setCoords(0,0);

        Piece rook2 = pf.create("rook", 'B');
        rook2.setCoords(0,8);

        p.addPiece(pawn1);
        p.addPiece(pawn2);
        p.addPiece(rook1);
        p.addCapturedPiece(pawn3);
        p.addCapturedPiece(rook2);

        Player p2 = p.copy();

        Assertions.assertSame(p2.getPoints(), p.getPoints());
    }

    @Test
    public void PlayerPieceListPreserved(){
        Player p = new Player("Player 1", 'W');

        PieceFactory pf = new PieceFactory();

        Piece pawn1 = pf.create("pawn", 'W');
        pawn1.setCoords(0,1);

        Piece pawn2 = pf.create("pawn", 'W');
        pawn2.setCoords(1,1);

        Piece pawn3 = pf.create("pawn", 'B');
        pawn3.setCoords(1,7);

        Piece rook1 = pf.create("rook", 'W');
        rook1.setCoords(0,0);

        Piece rook2 = pf.create("rook", 'B');
        rook2.setCoords(0,8);

        p.addPiece(pawn1);
        p.addPiece(pawn2);
        p.addPiece(rook1);
        p.addCapturedPiece(pawn3);
        p.addCapturedPiece(rook2);

        Player p2 = p.copy();

        Assertions.assertSame(p2.getPieceList().size(), p.getPieceList().size());
        Assertions.assertSame(p2.getCapturedPieces().size(), p.getCapturedPieces().size());
    }

    @Test
    public void PlayerPiecesDeepCopied() {
        Player p = new Player("Player 1", 'W');

        PieceFactory pf = new PieceFactory();

        Piece pawn1 = pf.create("pawn", 'W');
        pawn1.setCoords(0,1);

        Piece pawn2 = pf.create("pawn", 'W');
        pawn2.setCoords(1,1);

        Piece pawn3 = pf.create("pawn", 'B');
        pawn3.setCoords(1,7);

        Piece rook1 = pf.create("rook", 'W');
        rook1.setCoords(0,0);

        Piece rook2 = pf.create("rook", 'B');
        rook2.setCoords(0,8);

        p.addPiece(pawn1);
        p.addPiece(pawn2);
        p.addPiece(rook1);
        p.addCapturedPiece(pawn3);
        p.addCapturedPiece(rook2);

        Player p2 = p.copy();

        Assertions.assertNotSame(p2.getPieceList().get(0), p.getPieceList().get(0));
        Assertions.assertNotSame(p2.getPieceList().get(1), p.getPieceList().get(1));
        Assertions.assertNotSame(p2.getCapturedPieces().get(0), p.getCapturedPieces().get(0));
        Assertions.assertNotSame(p2.getCapturedPieces().get(1), p.getCapturedPieces().get(1));
    }
    
}
