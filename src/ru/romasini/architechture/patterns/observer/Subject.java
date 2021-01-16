package ru.romasini.architechture.patterns.observer;

import ru.romasini.architechture.patterns.entities.AbstractOperation;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer o){
        observers.add(o);
    }

    public void detach(Observer o){
        observers.remove(o);
    }

    protected void notify(AbstractOperation arg){
        for (Observer o:observers) {
            o.update(this, arg);
        }
    }
}
