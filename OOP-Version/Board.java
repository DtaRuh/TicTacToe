/*
 * Board class represents the Tic-Tac-Toe game board
 * Manages move validation and win/tie detection on the 3x3 grid
 */

public class Board {
    
    // fields
    // The 3x3 game board
    private char[][] board;

    // Character representing an empty cell
    private static final char EMPTY = ' ';
    
    // constructor(s)
    // Default constructor declares a 2D array of 3x3 rows and columns
    public Board() { 
        this.board = new char[3][3];
    }

    // methods 

    /*
     * @param: no argument
     * @return: void / prints the board as a grid
     */
    public void printBoard() { 
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

    public void printDisplayBoard() { 
        int[][] displayBoard = {{1,2,3},
                                {4,5,6},
                                {7,8,9}};
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

    /* Updates the board with the players last move
     * @param: int choice, char player
     * @return: void
     */
    public void placeMove(int choice, char playerSign) {

        // converts position number (1-9) to 2D array coordinates
        int row = (choice - 1) / 3;
        int col = (choice - 1) % 3;
        board[row][col] = playerSign; // places either 'X', 'O' or ' ' into board position
    }

    /* resets the board positions to EMPTY
     * @param: null
     * @return: void
    */
    public void resetBoard() { 
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) { 
                board[i][j] = EMPTY;
            }
        }
    }

    /*
     * method to check if player choice is valid
     * @param: int choice
     * @return: boolean
     */
    public boolean checkChoice(int choice) { 
        if(choice < 1 || choice > 9) { 
            return false;
        }

        // int row = index / W   for any grid of width W
        // int col = index % W
        int row = (choice - 1) / 3; // choice-1 becuase the array is zero indexed
        int col = (choice - 1) % 3;
        return board[row][col] == EMPTY; // checks if index is empty and returns true or false
    }

    /*
     * @return True if there is a winner, False if otherwise
     */
    public boolean checkWinner() { 
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
     * @return True if all positions are filled, false if empty position(s) exist
     */
    public boolean checkTie() { 
        // need to check that at least 1 index in board[][] equals EMPTY
        for(int i = 0; i < board.length; i++) { 
            for(int j = 0; j < board[i].length; j++) { 
                if(board[i][j] == EMPTY)
                return false;
            }
        }
        return true;
    }
}
