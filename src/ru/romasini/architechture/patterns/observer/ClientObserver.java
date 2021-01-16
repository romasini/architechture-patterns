package ru.romasini.architechture.patterns.observer;

import ru.romasini.architechture.patterns.entities.AbstractOperation;
import ru.romasini.architechture.patterns.services.UserService;

public class ClientObserver implements Observer{
    @Override
    public void update(Subject s, AbstractOperation arg) {
        UserService.sendMessageToClient(arg.getUser(), arg.toString()) ;
    }
}
