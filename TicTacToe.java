import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

    // Initialising Scanner and Random objects for further methods
    public static final Scanner keyboard = new Scanner(System.in);
    public static final Random randomNum = new Random();
     
    //Set pointers for each player plus the empty positions
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    private static final char EMPTY = ' ';

    // initialise the our tic tac toe board
    public static char[][] board = new char[3][3];

    // Make another display board for displaying numbered positions
    public static int[][] displayBoard = {{1,2,3},
                                          {4,5,6},
                                          {7,8,9}};

    // Method to print the display board
    public static void printDisplayBoard() { 
        for(int i = 0; i < displayBoard.length; i++) { 
            for(int j = 0; j < displayBoard[i].length; j++) {
                System.out.print(" "+ displayBoard[i][j] + " ");
                if(j < 2) { 
                    System.out.print("|");
                }
            }
            System.out.println();
            if(i < 2) { 
                System.out.println("-----------");
            }
        }
    }
                      
    /* @param 2D char array
       @return void (prints the char array) */
    public static void printBoard(char[][] board) { 
        for(int i = 0; i < board.length; i++) { 
            for(int j = 0; j < board[i].length; j++) {
                System.out.print(" "+ board[i][j] + " ");
                if(j < 2) { 
                    System.out.print("|");
                }
            }
            System.out.println();
            if(i < 2) { 
                System.out.println("-----------");
            }
        }
    }

    // method to set each index in the array to empty i.e. reset the board
    /*
     * @param 2D char array
     * @return 2D char array
     */
    public static char[][] resetBoard(char[][] board) { 
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) { 
                board[i][j] = EMPTY;
            }
        }
        return board;
    }

    /* 
     * @param char currentPlayer i.e. 'X'
     * @return int chosen by player i.e. 5
     */
    public static int getPlayerMove(char currentPlayer) { 
        System.out.print("Player " + currentPlayer + ", choose position (1-9): ");
        return keyboard.nextInt();
    }

    // I want to check if the space is free or occupied by a player
    // and if so return a true or false
    /* 
     *@param intakes the users choice of index for a marker
      @return returns a boolean true or false
     */
    public static boolean checkChoice(int choice) { 
        if(choice >= 1 && choice <= 9) { 
            int row = (choice - 1) / 3;
            int col = (choice - 1) % 3;

            if(board[row][col] == EMPTY) { 
                return true;
            }
            else { 
                return false;
            }
        }
        else { 
            return false;
        }
    }

    /*
     * method to choose which player to begin the game
     * 1 == Player_X
     * 2 == Player_O
     * @param function takes no argument
     * @return return an integer 1 or 2
     */
    public static int choosePlayer() { 
        int n = randomNum.nextInt(2)+1;
        return n;
    }

    /* 
     * Method to check if the game has been won
     * @param takes the 2D array as the argument
     * @return return true if game has been won and increment checkWin variable, return false if not
     */
    public static boolean checkWinner(char[][] board) { 
        // Horizontal logic
        for(int i = 0; i < board.length; i++)  {
            if(board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != EMPTY)  {
                return true;
            }
        }
        // vertical logic
        // need to be able to loop through the array to check indexes []
        for(int j = 0; j < board.length; j++) { 
            if(board[0][j] == board[1][j] && board[2][j] == board[0][j] && board[0][j] != EMPTY) { 
                return true;
            }
        }

        // Diagonal logic only 2 diagonals so lets check it out 
        if(board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != EMPTY) { 
            return true;
        }
        else if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != EMPTY) { 
            return true;
        }
        return false;
    }

    /*
     * Add a method to place moves
     * @param int choice, char player
     */
    public static void placeMove(int choice, char player) {
        int row = (choice - 1) / 3;
        int col = (choice - 1) % 3;
        board[row][col] = player; // places either 'X', 'O' or ' ' into board position
    }
    /*
     * add a method to check for a tie
     * @param char[][] board
     * @return boolean true if tie, false if game still undecided
     */
    public static boolean checkTie(char[][] board) {
        // need to check that at least 1 index in board[][] equals EMPTY
        int checkPointer = 0;
        for(int i = 0; i < board.length; i++) { 
            for(int j = 0; j < board[i].length; j++) { 
                if(board[i][j] == EMPTY)
                checkPointer = 1;
            }
        }
        if(checkPointer == 1) { 
            return false;
        }
        else { 
            return true;
        }
     }

    public static void main(String[] args)  {

        printDisplayBoard();
        resetBoard(board);
        char currentPlayer = (choosePlayer() == 1) ? PLAYER_X : PLAYER_O; // check who goes first
        boolean gameWon = false;

        while(!gameWon) { 
            if(checkTie(board) == true) { 
                System.out.println("Tie Game!");
                return;
            }
            int move = getPlayerMove(currentPlayer);
            
            if(checkChoice(move)) { 
                placeMove(move, currentPlayer);
                printBoard(board);
                gameWon = checkWinner(board);

                if(!gameWon) { 
                    // Utilise the ternary operator again to switch players
                    currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
                }
            } else { 
                System.out.println("Invalid move! Please try again."); // Doesn't switch players on invalid move
            }
        }

        System.out.println("Player " + currentPlayer + " wins!");
        keyboard.close(); // close my scanner object
    }
}