package trafficlight;

import trafficlight.states.State;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        if (!observers.contains(observer))
            observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(State state) {
        for (Observer observer : observers)
            observer.update(state);
    }


}
