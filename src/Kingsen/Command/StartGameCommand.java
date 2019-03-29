package Kingsen.Command;

import Kingsen.Game.Game;

/**
 * This Command class notifies the Game class that
 * the game can commence
 */
public class StartGameCommand implements Command {

    private Game game;

    public StartGameCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.start();
    }
}
