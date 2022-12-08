package Interface;

import engine.entities.Game;
import engine.move.Move;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class InputMove implements InputMoveInt{
    /**
     * Asks user to input move. If inputted move is in validMoves,
     * return that move. If not tell user it is invalid and ask
     * again. Give user option to undo move by pressing (U), which
     * calls undoMove in PlayGame class.
     *
     * @return string representing algebraic notation of move
     */
    public String input(List<String> validMoves, boolean canUndo) {
        Scanner reader = new Scanner(System.in);
        while (true) {
            System.out.println("Input move from list of moves shown above: ");
            String c = reader.next();
            if ((canUndo && Objects.equals(c, "U")) || validMoves.contains(c)) {
                return c;
            }
            System.out.println("Invalid Move. ");
        }
    }
}
