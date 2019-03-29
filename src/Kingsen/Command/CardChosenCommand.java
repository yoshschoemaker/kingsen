package Kingsen.Command;

import Kingsen.Build.Card;
import Kingsen.Game.Game;
import Kingsen.Game.Player;

/**
 * This Command class picks a card that is given in the constructor
 * and then removes it from the Game class to move it to the Player who
 * picked that card
 */
public class CardChosenCommand implements Command {

    private Game game;
    private Player player;
    private Card card;

    public CardChosenCommand(Game game, Card card) {
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
    }
}
