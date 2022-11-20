import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoveTest {
    private final PieceFactory pf = new PieceFactory();
    private Piece createAndPlacePiece(String type, Player player, Board board, int x, int y) {
        Piece piece = pf.create(type);
        piece.setPlayer(player);
        board.setPieceAtAbsCoords(x, y, piece);
        piece.setCoords(x, y);
        return piece;
    }

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
        move.execute(board, king);

        Assertions.assertEquals(board.getCurrentPlayer().getColor(), 'B');
    }

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
        move.execute(board, king);

        Assertions.assertNull(board.getPieceAtAbsCoords(0, 0));
        Assertions.assertEquals(board.getPieceAtAbsCoords(0, 1), king);
    }

    @Test
    public void ExecuteWithCaptureUpdatesCapturedPieces() {
        Board board = new Board();

        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        Player[] players = {p1, p2};
        board.setPlayers(players);

        Assertions.assertEquals(p1.getCapturedPieces().size(), 0);

        Piece king = createAndPlacePiece("king", p1, board, 0, 1);
        Piece pawn = createAndPlacePiece("pawn", p2, board, 0, 1);

        int[] origin = {0, 0};
        int[] dest = {0, 1};
        Move move = new Move(origin, dest);
        move.execute(board, king);
        Assertions.assertEquals(p1.getCapturedPieces().size(), 1);
    }
}
