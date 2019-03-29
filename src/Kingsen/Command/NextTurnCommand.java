package Kingsen.Command;

import Kingsen.Game.Game;

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
