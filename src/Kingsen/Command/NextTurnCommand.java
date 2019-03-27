package Kingsen.Command;

import Kingsen.Build.Card;
import Kingsen.Game.Game;
import Kingsen.Game.Player;

public class NextTurnCommand implements Command {

    private Game game;
    private Player player;
    private Card card;

    public NextTurnCommand(Game game, Card card) {
        this.game = game;
        this.player = game.getTurn().getCurrentPlayer();
        this.card = card;
    }

    @Override
    public void execute() {
        // Remove card from the Deck
        game.getCards().remove(card);

        // Add the selected card to the player's deck
        player.getCards().add(card);

        // Call the next turn
        game.nextTurn();
    }
}
