package Kingsen.Command;

import Kingsen.Game.Game;

/**
 * This Command class notifies the Game class of its next turn
 */
public class NextTurnCommand implements Command {

    private Game game;

    public NextTurnCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        // Go to the next turn!
        game.nextTurn();
    }
}
