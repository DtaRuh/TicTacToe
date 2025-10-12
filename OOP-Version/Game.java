import java.util.Scanner;
import java.util.Random;

/*
 * Game class manages Tic-Tac-Toe game flow and logic
 * Handles player turns, input validation, and game state
 */

public class Game {

    // fields
    private Scanner keyboard;
    private Random randomNum;
    private Board board;
    private Player playerX;
    private Player playerO;

    // constructor(s)
    // constructs a new game with a board object and two player objects
    public Game(Board board, Player player1, Player player2) { 
        this.board = board;
        this.playerX = player1;
        this.playerO = player2;
        this.keyboard = new Scanner(System.in);
        this.randomNum = new Random();
    }

    // methods
    /*
     * @return the Player object that will make the first move
     */
    public Player chooseFirstPlayer() { 
        int n = randomNum.nextInt(2)+1;
        if(n == 1) { 
            System.out.println("Player X goes first!");
            return playerX;
        }
        else { 
            System.out.println("Player O goes first!");
            return playerO;
        }
    }

    /*
     * @param currentPlayer object
     * @return int position chosen by the player (1-9)
     */
    public int getPlayerMove(Player currentPlayer) { 
        System.out.print("Player " + currentPlayer.getPlayerSign() + ", choose position (1-9): ");
        return keyboard.nextInt();
    }

    /*
     * @param currentPlayer object
     * @return The other player object
     */
    public Player switchPlayer(Player currentPlayer) { 
        return currentPlayer = (currentPlayer == playerX ) ? playerO : playerX;
    }

    /*
     * Starts and manages the main game loop. 
     * Handles player turns and move validation,
     * Win/Tie detection and game termination.
     */
    public void startGame() { 
        board.resetBoard();
        board.printDisplayBoard();

        Player currentPlayer = chooseFirstPlayer();
        
        //Loop here, continues until win or tie
        while(true) {  
            board.printBoard();

            // Get players move
            int move = getPlayerMove(currentPlayer);

            // If move is invalid, prompt another move
            while(!board.checkChoice(move)) { 
                System.out.println("Invalid move! That position is taken or out of range.");
                move = getPlayerMove(currentPlayer);
            }

            // Place the validated move on the board
            board.placeMove(move, currentPlayer.getPlayerSign());
            
            // Check if current player won
            if(board.checkWinner()) { 
                board.printBoard();
                System.out.println("Player " + currentPlayer.getPlayerSign() + " Wins!");
                break;
            }

            // Check if game ended in a tie
            if(board.checkTie()) { 
                board.printBoard();
                System.out.println("It's a tie!");
                break;
            }

            // Switch to the other player for next turn
            currentPlayer = switchPlayer(currentPlayer);
        } 
    }
}
