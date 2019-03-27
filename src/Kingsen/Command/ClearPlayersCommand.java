package Kingsen.Command;

import Kingsen.Game.Game;

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
