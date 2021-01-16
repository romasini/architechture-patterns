package ru.romasini.architechture.patterns.observer;

import ru.romasini.architechture.patterns.entities.AbstractOperation;

public interface Observer {
    void update(Subject s, AbstractOperation arg);
}
