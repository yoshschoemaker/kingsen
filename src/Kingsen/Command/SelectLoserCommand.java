package Kingsen.Command;

import Kingsen.Game.Game;
import Kingsen.Game.Player;

/**
 * This Command class adds 1 to the score of the
 * referenced player
 */
public class SelectLoserCommand implements Command {

    private Game game;
    private Player player;

    public SelectLoserCommand(Game game, Player player) {
        this.game = game;
        this.player = player;
    }

    @Override
    public void execute() {
        Player selectedLoserPlayer = game.getPlayers().get(game.getPlayers().indexOf(player));
        selectedLoserPlayer.addOneToScore();
    }
}
