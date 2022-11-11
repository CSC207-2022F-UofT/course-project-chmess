public class Piece {
    private String type;
    private Player player;
    private int[] coords;

    public Piece(String type) {
        this.type = type;
        this.coords = new int[2];
    }

    public String getType() {}

    public int getPointValue() {}

    public void setPlayer(Player p) {
        this.player = p;
    }
    public Player getPlayer() {
        return this.player;
    }

    public void setCoords(int x, int y) {
        this.coords[0] = x;
        this.coords[1] = y;
    }

    public int[] getCoords() {
        return this.coords;
    }

    public Move generateMoves() {

    }
}
