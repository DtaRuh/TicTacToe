import java.util.Scanner;

/*
 * Main class Creates the game board, players and manages the game loop
 * with replay functionality.
 */

public class Main {
    public static void main(String[] args) { 

        // Initialise Scanner for replay prompt
        Scanner keyboard = new Scanner(System.in);

        // initialise game components
        Board board = new Board();
        Player playerX = new Player('X');
        Player playerO = new Player('O');

        // Game loop - allows multiple games to be played
        do { 

            // Display board layout and start a new game
            Game game = new Game(board, playerX, playerO);
            game.startGame();

            // Prompt user with the option to play again
            System.out.print("Play again? (y/n): ");
        } while(keyboard.next().equalsIgnoreCase("y"));

        keyboard.close();

        // Run using javac *.java ; java Main
    }
}
