class GameCreator {
    public GameCreator() {}

    /**
     * Create a new Game instance, including a new Board instance
     * (with pieces placed according to the rules of chess)
     * and new Player instances.
     *
     * @return a new game
     */
    public Game create() {
        Game game = new Game();

        Player p1 = new Player("Player 1", 'W');
        Player p2 = new Player("Player 2", 'B');
        BoardCreator bc = new BoardCreator(p1, p2);
        Board board = bc.create();
        game.setBoard(board);

        return game;
    }
}
