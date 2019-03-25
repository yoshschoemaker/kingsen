package Kingsen.Command;

import Kingsen.Game.Game;

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
