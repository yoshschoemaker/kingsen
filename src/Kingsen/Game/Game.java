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
            CardDeckDecorator cardDeck = new CardDeckRuleDecorator(new CardDeck());
            cards = cardDeck.generateCardDeck();
            this.turn = new Turn(players);
            new KingCardObserver(this);
            notifyAllObservers();
            started = true;
            System.out.println(ConsoleColors.GREEN + "--- GAME IS SET UP! HAVE FUN PLAYING ---" + ConsoleColors.RESET);
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

    public void setStarted(boolean started) {
        this.started = started;
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
