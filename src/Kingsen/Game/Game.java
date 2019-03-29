package Kingsen.Game;

import Kingsen.Build.*;
import Kingsen.Command.*;
import Kingsen.Decorate.*;
import Kingsen.Helpers.ConsoleColors;
import Kingsen.Observe.*;
import Kingsen.Observe.Observable;
import Kingsen.Observe.Observer;

import java.util.*;

public class Game implements Observable {

    private List<Player> players = new ArrayList<>();
    private List<Player> playerRanklist = new ArrayList<>(players);
    private boolean drinkMode = false;
    private ArrayList<Card> cards;
    private Turn turn;
    private List<Observer> observers = new ArrayList<>();
    private boolean gameOver = false;
    private boolean started = false;
    private int kingsLeft;

    public void init() {
        System.out.println("--- GAME INITIALIZED ---");
    }

    public void start() {
        if (!started) {
            System.out.println("--- NEW GAME STARTED ---");

            CardDeckDecorator cardDeck = new CardDeckRuleDecorator(new CardDeckShuffleDecorator(new CardDeck()));

            System.out.println("--- STARTED GENERATING THE CARD DECK ---");
            cards = cardDeck.generateCardDeck();
        /*for (Card card : cards) {
            if (card.isNumberCard()) {
                System.out.println(String.format("%3$s %2$s (%4$s) card with rule: '%1$s'", card.getRule().getRuleTitle(), card.getFace(), card.getType(), card.getNumber()));
            } else {
                System.out.println(String.format("%3$s %2$s card with rule: '%1$s'", card.getRule().getRuleTitle(), card.getFace(), card.getType()));
            }
        }*/
            System.out.println(cards.size() + " cards have been generated");
            System.out.println("--- FINISHED GENERATING THE CARD DECK ---");

            System.out.println("--- SETTING UP TURN OBJECT ---");
            this.turn = new Turn(players);
            System.out.println("--- TURN OBJECT SET ---");

            System.out.println("--- SETTING UP END GAME OBSERVER ---");
            new KingCardObserver(this);
            notifyAllObservers();
            System.out.println("--- END GAME OBSERVER IS SET AND NOTIFIED ---");

            started = true;

            System.out.println(ConsoleColors.GREEN + "\n--- GAME STARTED! HAVE FUN PLAYING ---" + ConsoleColors.RESET);
        }
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

    public Turn getTurn() {
        return turn;
    }

    public boolean drinkModeEnabled() {
        return drinkMode;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void nextTurn() {
        notifyAllObservers();
        turn.nextTurn();
    }

    public List<Player> getPlayerRanklist() {
        return playerRanklist;
    }

    public void setPlayerRanklist(List<Player> playerRanklist) {
        this.playerRanklist = playerRanklist;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public int getKingsLeft() {
        return kingsLeft;
    }

    public void setKingsLeft(int kingsLeft) {
        this.kingsLeft = kingsLeft;
    }

    // TODO: implement below when restarting the game
    public void resetGame() {
        started = false;
    }

    public boolean isStarted() {
        return started;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
