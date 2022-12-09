package Interface;

//import Interface.Import;
//import Interface.ImportInt;
//import Interface.PlayGame;
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
    public static void main (String[] args) {
        runGame();
    }
    /**
     * Asks user to input player names.
     */
    private static ArrayList<String> askPlayers() {
        ArrayList<String> l = new ArrayList<>();
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter Player 1 name (White): ");
        l.add(reader.next());
        System.out.println("Enter Player 2 name (Black): ");
        l.add(reader.next());
        return l;
    }

    public static void runGame() {
        Scanner reader = new Scanner(System.in);
        String c = null;
        while(!Objects.equals(c, "N") && !Objects.equals(c, "L") && !Objects.equals(c, "Q")){
            System.out.println("Welcome to Chmess! Press (N) for new game, (L) for load custom starting position from file, or (Q) to exit program: ");
            c = reader.next();
            if (Objects.equals(c, "N")) {
                ArrayList<String> players = askPlayers();
                GameCreator gameCreate = new GameCreator();
                Game game = gameCreate.create(players.get(0), players.get(1));
                PlayGame.play(game);
            } else if (Objects.equals(c, "L")) {
                System.out.println("Enter file name: ");
                String fileName = reader.next();
                ImportPositionInt importStarting = new ImportPosition();
                ArrayList<String> players = askPlayers();
                GameCreator gameCreate = new GameCreator();
                PlayGame.play(gameCreate.createImport(players.get(0), players.get(1), importStarting.importGame(fileName)));
            } else if (Objects.equals(c, "Q")) {
                return;
            } else {
                System.out.println("Invalid input. Please enter one of the listed options.");
            }
        }
    }
}
