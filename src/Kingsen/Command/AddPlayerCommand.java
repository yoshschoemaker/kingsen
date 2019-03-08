package Kingsen.Command;

import Kingsen.Game.*;

public class AddPlayerCommand implements Command {

    private Game game;
    private Player player;

    public AddPlayerCommand(Game game, Player player) {
        this.game = game;
        this.player = player;
    }

    @Override
    public void execute() {
        game.getPlayers().add(player);
    }
}
