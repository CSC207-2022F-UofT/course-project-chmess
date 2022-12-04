package Interface;

import java.util.Objects;
import java.util.Scanner;


public class DisplayEnd implements DisplayEndInt {
    /**
     * Displays ending screen based on gameState. If checkmate,
     * displays curPlayer as winner. After user inputs (C) to
     * continue, calls Interface.Chmess to return to main screen.
     */
    public void display(String curPlayer, char gameState) {
        Scanner reader = new Scanner(System.in);
        if (gameState == '#') {
            System.out.println("The game ended in checkmate. The winner is " + curPlayer + ". To return back to main screen press (C).");
        }
        else if (gameState == '$') {
            System.out.println("The game ended in stalemate. To return back to main screen press (C).");
        }
        else {
            System.out.println("The game has been terminated. To return back to main screen press (C).");
        }
        String c = reader.next();
        if (Objects.equals(c, "C")) {
            Chmess.runGame();
        }
    }
}
