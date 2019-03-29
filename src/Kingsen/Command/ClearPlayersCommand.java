package Kingsen.Command;

import Kingsen.Game.Game;

/**
 * This Command class clears the Player ArrayList from the Game class
 */
public class ClearPlayersCommand implements Command {

    private Game game;

    public ClearPlayersCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.getPlayers().clear();
    }
}
