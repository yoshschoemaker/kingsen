package Kingsen.Game;

import Kingsen.Build.*;
import Kingsen.Command.*;
import Kingsen.Decorate.*;
import Kingsen.Observe.*;

import java.util.*;

public class Game {

    private List<Player> players = new ArrayList<>();
    private Map<Player, Integer> ranklist;
    private boolean drinkMode = false;
    private ArrayList<Card> cards;
    private int turn;

    public void init() {
        System.out.println("--- GAME INITIALIZED ---\n");
    }

    public void start() {
        System.out.println("--- GAME STARTED ---\n");

        CardDeckDecorator cardDeck = new CardDeckShuffleDecorator(new CardDeck());
        cards = cardDeck.generateCardDeck();

        System.out.println("--- STARTED GENERATING THE CARD DECK ---");
        for (Card card : cards) {
            if (card.isNumberCard()) {
                System.out.println(String.format("%3$s %2$s (%4$s) card with rule: '%1$s'", card.getRule().getRule(), card.getFace(), card.getType(), card.getNumber()));
            } else {
                System.out.println(String.format("%3$s %2$s card with rule: '%1$s'", card.getRule().getRule(), card.getFace(), card.getType()));
            }
        }
        System.out.println(cards.size());
        System.out.println("--- DONE GENERATING THE CARD DECK ---");
    }

    public void executeCommand(Command command) {
        command.execute();
    }

    public void getPlayerNames() {
        for (Player player : players) {
            System.out.println(player.getName());
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getTurn() {
        return turn;
    }

    public boolean drinkModeEnabled() {
        return drinkMode;
    }
}
