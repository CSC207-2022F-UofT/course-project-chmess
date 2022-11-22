import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoveTest {
    protected final PieceFactory pf = new PieceFactory();

    @Test
    public void ExecuteAdvancesCurrentPlayerWhiteToBlack() {
        Board board = createEmptyBoard('W');
        Player p1 = board.getPlayers()[0];

        createAndPlacePiece("king", p1, board, 0, 0);

        int[] origin = {0, 0};
        int[] dest = {0, 1};
        Move move = new Move(origin, dest);
        move.execute(board);

        Assertions.assertEquals('B', board.getCurrentPlayer().getColor());
    }

    @Test
    public void ExecuteAdvancesCurrentPlayerBlackToWhite() {
        Board board = createEmptyBoard('B');
        Player p2 = board.getPlayers()[1];

        createAndPlacePiece("king", p2, board, 0, 0);

        int[] origin = {0, 0};
        int[] dest = {0, 1};
        Move move = new Move(origin, dest);
        move.execute(board);

        Assertions.assertEquals('W', board.getCurrentPlayer().getColor());
    }

    @Test
    public void ExecuteMovesPiece() {
        Board board = createEmptyBoard('W');
        Player p1 = board.getPlayers()[0];

        Piece king = createAndPlacePiece("king", p1, board, 0, 0);

        int[] origin = {0, 0};
        int[] dest = {0, 1};
        Move move = new Move(origin, dest);
        move.execute(board);

        Assertions.assertNull(board.getPieceAtAbsCoords(0, 0));
        Assertions.assertEquals(king, board.getPieceAtAbsCoords(0, 1));
        Assertions.assertTrue(board.getPieceAtAbsCoords(0, 1).hasMadeFirstMove());
    }

    @Test
    public void ExecuteWithCaptureUpdatesCapturedPieces() {
        Board board = createEmptyBoard('W');
        Player p1 = board.getPlayers()[0];
        Player p2 = board.getPlayers()[1];

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
        Board board = createEmptyBoard('W');
        Player p1 = board.getPlayers()[0];
        Player p2 = board.getPlayers()[1];

        createAndPlacePiece("king", p1, board, 0, 0);
        createAndPlacePiece("pawn", p2, board, 0, 1);

        int[] origin = {0, 0};
        int[] dest = {0, 1};
        Move move = new Move(origin, dest);
        Assertions.assertEquals("Ka1xa2", move.getAlgebraicNotation(board));
    }

    protected Piece createAndPlacePiece(String type, Player player, Board board, int x, int y) {
        Piece piece = pf.create(type);
        piece.setPlayer(player);
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
            board.setCurrentPlayer(p1);
        } else {
            board.setCurrentPlayer(p2);
        }

        return board;
    }

    private void placePieceFromChar(char c, Board board, int x, int y) {
        String type;
        switch (Character.toLowerCase(c)) {
            case 'p':
                type = "pawn";
                break;
            case 'n':
                type = "knight";
                break;
            case 'b':
                type = "bishop";
                break;
            case 'r':
                type = "rook";
                break;
            case 'q':
                type = "queen";
                break;
            case 'k':
                type = "king";
                break;
            default:
                return;
        }

        Player[] players = board.getPlayers();
        Player player;
        if (Character.isUpperCase(c)) {
            player = players[0];
        } else {
            player = players[1];
        }

        createAndPlacePiece(type, player, board, x, y);
    }

    // Handy helper for building complicated boards
    protected void placePiecesOnBoard(Board board, String boardString) {
        for (int y = board.HEIGHT - 1; y > 0; y--) {
            for (int x = 0; x < board.WIDTH; x++) {
                int i = y * board.WIDTH + x;
                char c = boardString.charAt(i);
                placePieceFromChar(c, board, x, y);
            }
        }
    }
}
