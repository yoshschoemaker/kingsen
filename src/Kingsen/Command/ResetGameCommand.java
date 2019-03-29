package Kingsen.Command;

import Kingsen.Game.Game;

/**
 * This Command class helps reset the Game state to initial values
 * so a new Game can be started
 */
public class ResetGameCommand implements Command {

    private Game game;

    public ResetGameCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.executeCommand(new ClearPlayersCommand(game));
        game.getPlayerRanklist().clear();
        game.setStarted(false);
        game.setGameOver(false);
    }
}
