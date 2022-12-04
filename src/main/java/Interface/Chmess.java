package Interface;

import Interface.Import;
import Interface.ImportInt;
import Interface.PlayGame;
import engine.entities.Game;
import engine.entities.GameCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
/**
 * Run to start Interface.Chmess program.
 */
public class Chmess {
    public static void main () {
        runGame();
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

    public static void runGame() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Welcome to Interface.Chmess! Press (N) for new game, (L) for load custom starting position from file, or (Q) to exit program: ");
        String c = reader.next();
        if (Objects.equals(c, "N")) {
            ArrayList<String> players = askPlayers();
            GameCreator gameCreate = new GameCreator();
            PlayGame.play(gameCreate.create(players.get(0), players.get(1)));
        }
        else if (Objects.equals(c, "L")) {
            System.out.println("Enter file name: ");
            String fileName = reader.next();
            ImportInt importStarting = new Import();
            ArrayList<String> players = askPlayers();
            GameCreator gameCreate = new GameCreator();
            PlayGame.play(gameCreate.createImport(players.get(0), players.get(1), importStarting.importGame(fileName)));
        }
        else if (Objects.equals(c, "Q")) {
            return;
        }
        else {
            System.out.println("Invalid input. Please try again: ");
            main();
        }


    }
}
