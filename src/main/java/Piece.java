public class Piece {
    private String type;
    private Player player;
    private int[] coords;
    private int pointValue;

    public Piece() {
        this.coords = new int[2];
    }

    /**
     * Returns a semi-deep clone of the Piece object.
     * More precisely, the coords array is replaced with a clone.
     * (The Player object is not replaced.)
     *
     * @return a clone of this piece
     */
    public Piece copy() {
        return null;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }

    public int getPointValue() {
        return this.pointValue;
    }

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
}
