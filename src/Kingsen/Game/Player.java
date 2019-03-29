package Kingsen.Game;

import Kingsen.Build.Card;
import Kingsen.Observe.Observable;
import Kingsen.Observe.Observer;

import java.util.ArrayList;
import java.util.List;

public class Player implements Comparable<Player>, Observable {

    private String name;
    private Integer score = 0;
    private List<Observer> observers = new ArrayList<>();
    private List<Card> cards = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void addOneToScore() {
        score++;
        notifyAllObservers();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public String toString() {
        return "Player " + getName() + " with score " + getScore();
    }

    @Override
    public int compareTo(Player o) {
        return this.getScore().compareTo(o.getScore());
    }
}
