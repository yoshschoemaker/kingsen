package Kingsen.Game;

import java.util.List;

/**
 * Helper class to keep track of the turns
 * and the current turn of a Player
 */
public class Turn {

    private List<Player> players;
    private int turnNumber;

    public Turn(List<Player> players) {
        turnNumber = 0;
        this.players = players;
    }

    public void nextTurn() {
        turnNumber++;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public Player getCurrentPlayer() {
        // Returns the player based on the turn integer with
        // a modulo operator on the size of the ArrayList.
        // E.g.: we are at turn 6 and there are 3 players
        // 6 modulo 3 = 0 because 3 fits 2 times in 6
        // so it will return the first player in the Player ArrayList
        return players.get(turnNumber % players.size());
    }
}
