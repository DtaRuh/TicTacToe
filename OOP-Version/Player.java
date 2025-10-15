/*
 * Player class represents a player in Tic-Tac-Toe
 * Each player has a unique symbol (X, or O) represented by the field playerSign
 */
public class Player {

    // fields
    private char playerSign;

    // constructor(s)
    // Constructs a new Player with the specified symbol
    public Player(char playerSign) { 
        this.playerSign = playerSign;
    }

    // methods
    /*
     * @return the character representing the player (X or O)
     */
    public char getPlayerSign() { 
        return playerSign;
    }

    /*
     * Sets a new symbol for this player
     * @param playerSign the new character symbol for this player
     */
    public void setPlayer(char playerSign) { 
        this.playerSign = playerSign;
    }
    
}
