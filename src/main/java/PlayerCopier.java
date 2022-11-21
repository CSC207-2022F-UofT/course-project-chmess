public class PlayerCopier {
    /**
     * Returns a deep clone of the given Board instance.
     *
     * @see Player#copy() Board.copy()
     *
     * @param player the board to be cloned
     * @return a clone of the board
     */

    private Player newPlayer;
    private Player oldPlayer;

    public PlayerCopier(Player oldPlayer) {
        this.oldPlayer = oldPlayer;
    }

    public Player createCopy(Player player) {
        //TODO!!!
        // Don't entirely understand the use of mirror coordinates
        // If still needed, will need to implement later

        return this.newPlayer;
    }

}
