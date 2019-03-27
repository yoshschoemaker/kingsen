package Kingsen.Game;

import java.util.List;

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
        return players.get(turnNumber % players.size());
    }
}
