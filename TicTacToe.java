import java.util.Scanner;

public class TicTacToe {

    // Create keyboard object of scanner class to read user input
    static Scanner keyboard = new Scanner(System.in);

    // integer variable to intake users choice of game
    static public int choice;

    // Create an aesthetic starting screen because I'm lost on the logic side 
    public static void startingScreen() {
        System.out.println("--------------------------------------");
        System.out.println("|                                    |");
        System.out.println("|            Tik Tak Toe !           |");
        System.out.println("|                                    |");
        System.out.println("|             X | O | X              |");
        System.out.println("|            ---|---|---             |");
        System.out.println("|             O | X | O              |"); 
        System.out.println("|            ---|---|---             |");
        System.out.println("|             X | O | X              |");
        System.out.println("|                                    |");
        System.out.println("|       [1] Play against a friend    |");
        System.out.println("|       [2] Play against a bot       |");
        System.out.println("|       [3] Exit                     |");
        System.out.println("|                                    |"); 
        System.out.print("|     Enter your choice (1-3): ");
        choice = keyboard.nextInt();
        System.out.println("    |");
        System.out.println("|                                    |");
        System.out.println("--------------------------------------");
    }

    // Create the tic tac toe interface
    public static void gameInterface() {
        System.out.println("             X | O | X              ");
        System.out.println("            ---|---|---             ");
        System.out.println("             O | X | O              "); 
        System.out.println("            ---|---|---             ");
        System.out.println("             X | O | X              ");
    }

    // Trying to figure out the logic 

   public static void main(String[] args) { 
    System.out.println("Hello World");
    startingScreen();
   } 
}   