import java.util.Scanner;

public class TicTacToe {
     

    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    private static final char EMPTY = ' ';

    public static char[][] board = {{' ',' ',' '},
                      {' ',' ',' '},
                      {' ',' ',' '}
                     };

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
     
    public static void main(String[] args)  {

        Scanner keyboard = new Scanner(System.in);
        printBoard(board); 
    }
}

