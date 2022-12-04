package Interface;

interface DisplayEndInt {
    /**
     * Displays ending screen based on gameState. If checkmate,
     * displays curPlayer as winner. After user inputs (C) to
     * continue, calls Chmess to return to main screen.
     */
    public void display(String curPlayer, char gameState);
}
