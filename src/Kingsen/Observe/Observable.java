package Kingsen.Observe;

public interface Observable {
    void addObserver(Observer observer);

    void notifyAllObservers();
}
