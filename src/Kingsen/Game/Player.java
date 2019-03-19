package Kingsen.Game;

import Kingsen.Observe.Observer;

import java.util.List;

public class Player {

    private int id;
    private String name;
    private int score;
    private List<Observer> observers;

    public Player(String name) {
        this.name = name;
        score = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {

    }
}
