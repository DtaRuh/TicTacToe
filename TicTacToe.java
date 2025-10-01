import java.util.Scanner;


public class TicTacToe {

    public static final Scanner keyboard = new Scanner(System.in);
     
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
        printDisplayBoard();
        System.out.print("Player " + currentPlayer + ", choose position (1-9): ");
        return keyboard.nextInt();
    }
    
     
    public static void main(String[] args)  {

        resetBoard(board);
        printBoard(board); 
    }
}

