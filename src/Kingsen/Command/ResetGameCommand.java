package Kingsen.Command;

import Kingsen.Game.Game;

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
