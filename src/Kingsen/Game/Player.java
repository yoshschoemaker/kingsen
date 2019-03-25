package Kingsen.Game;

import Kingsen.Build.Card;
import Kingsen.Observe.Observer;

import java.util.List;

public class Player {

    private String name;
    private int score;
    private List<Observer> observers;
    private List<Card> cards;

    public Player(String name) {
        this.name = name;
        score = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void playCard(Card card) {

    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {

    }
}
