import Interface.PlayGame;
import engine.entities.Game;
import engine.entities.GameCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
/**
 * Run to start Chmess program.
 */
public class Chmess {
    public static void main () {
        Scanner reader = new Scanner(System.in);
        System.out.println("Welcome to Chmess! Press (N) for new game, (L) for load game, or (Q) to exit program: ");
        String c = reader.next();
        if (Objects.equals(c, "N")) {
            ArrayList<String> players = askPlayers();
            GameCreator gameCreate = new GameCreator();
            PlayGame.play(gameCreate.create(players.get(0), players.get(1)));
        }
        else if (Objects.equals(c, "L")) {
            return;
        }
        else if (Objects.equals(c, "Q")) {
            return;
        }
        else {
            System.out.println("Invalid input. Please try again: ");
            //
        }

    }
    /**
     * Asks user to input player names.
     */
    private static ArrayList<String> askPlayers() {
        ArrayList<String> l = new ArrayList<>();
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter Player 1 name: ");
        l.add(reader.next());
        System.out.println("Enter Player 2 name: ");
        l.add(reader.next());
        return l;
    }
}
