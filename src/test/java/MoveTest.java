import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoveTest {
    protected final PieceFactory pf = new PieceFactory();
    protected Piece createAndPlacePiece(String type, Player player, Board board, int x, int y) {
        Piece piece = pf.create(type);
        piece.setPlayer(player);
        board.setPieceAtAbsCoords(x, y, piece);
        piece.setCoords(x, y);
        return piece;
    }

    /*
    Actually, Move.execute() doesn't do this; this happens in MoveExecutor (?)
    @Test
    public void ExecuteAdvancesCurrentPlayer() {
        Board board = new Board();

        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        Player[] players = {p1, p2};
        board.setPlayers(players);

        Piece king = createAndPlacePiece("king", p1, board, 0, 0);

        int[] origin = {0, 0};
        int[] dest = {0, 1};
        Move move = new Move(origin, dest);
        move.execute(board);

        Assertions.assertEquals(board.getCurrentPlayer().getColor(), 'B');
    }
    */

    @Test
    public void ExecuteMovesPiece() {
        Board board = new Board();

        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        Player[] players = {p1, p2};
        board.setPlayers(players);

        Piece king = createAndPlacePiece("king", p1, board, 0, 0);

        int[] origin = {0, 0};
        int[] dest = {0, 1};
        Move move = new Move(origin, dest);
        move.execute(board);

        Assertions.assertNull(board.getPieceAtAbsCoords(0, 0));
        Assertions.assertEquals(king, board.getPieceAtAbsCoords(0, 1));
    }

    @Test
    public void ExecuteWithCaptureUpdatesCapturedPieces() {
        Board board = new Board();

        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        Player[] players = {p1, p2};
        board.setPlayers(players);

        Assertions.assertEquals(p1.getCapturedPieces().size(), 0);

        createAndPlacePiece("king", p1, board, 0, 0);
        createAndPlacePiece("pawn", p2, board, 0, 1);

        int[] origin = {0, 0};
        int[] dest = {0, 1};
        Move move = new Move(origin, dest);
        move.execute(board);
        Assertions.assertEquals(1, p1.getCapturedPieces().size());
    }

    @Test
    public void GetAlgebraicNotation() {
        Board board = new Board();

        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        Player[] players = {p1, p2};
        board.setPlayers(players);

        Assertions.assertEquals(0, p1.getCapturedPieces().size());

        createAndPlacePiece("king", p1, board, 0, 0);
        createAndPlacePiece("pawn", p2, board, 0, 1);

        int[] origin = {0, 0};
        int[] dest = {0, 1};
        Move move = new Move(origin, dest);
        Assertions.assertEquals("Ka1xa2", move.getAlgebraicNotation(board, ""));
    }

    @Test
    public void GetAlgebraicNotationCheck() {
        Board board = new Board();

        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        Player[] players = {p1, p2};
        board.setPlayers(players);

        Assertions.assertEquals(0, p1.getCapturedPieces().size());

        createAndPlacePiece("king", p1, board, 0, 0);
        createAndPlacePiece("pawn", p2, board, 1, 2);

        int[] origin = {1, 2};
        int[] dest = {1, 1};
        Move move = new Move(origin, dest);
        Assertions.assertEquals("b3b2+", move.getAlgebraicNotation(board, "+"));
    }

    @Test
    public void GetAlgebraicNotationCheckmate() {
        Board board = new Board();

        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        Player[] players = {p1, p2};
        board.setPlayers(players);

        Assertions.assertEquals(0, p1.getCapturedPieces().size());

        createAndPlacePiece("king", p1, board, 0, 0);
        createAndPlacePiece("queen", p2, board, 6, 1);
        createAndPlacePiece("rook", p2, board, 7, 1);

        int[] origin = {6, 1};
        int[] dest = {1, 1};
        Move move = new Move(origin, dest);
        Assertions.assertEquals("qg2b2#", move.getAlgebraicNotation(board, "#"));
    }

    @Test
    public void GetAlgebraicNotationCaptureCheckmate() {
        Board board = new Board();

        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        Player[] players = {p1, p2};
        board.setPlayers(players);

        Assertions.assertEquals(0, p1.getCapturedPieces().size());

        createAndPlacePiece("king", p2, board, 0, 0);
        createAndPlacePiece("pawn", p2, board, 1, 1);
        createAndPlacePiece("queen", p1, board, 6, 1);
        createAndPlacePiece("rook", p1, board, 7, 1);

        int[] origin = {6, 1};
        int[] dest = {1, 1};
        Move move = new Move(origin, dest);
        Assertions.assertEquals("Qg2xb2#", move.getAlgebraicNotation(board, "#"));
    }
}
