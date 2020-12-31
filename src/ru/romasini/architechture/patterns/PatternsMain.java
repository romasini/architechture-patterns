package ru.romasini.architechture.patterns;

import ru.romasini.architechture.patterns.entities.Storage;
import ru.romasini.architechture.patterns.entities.User;
import ru.romasini.architechture.patterns.services.StorageService;
import ru.romasini.architechture.patterns.services.UserService;

public class PatternsMain {
    public static void main(String[] args) {

        UserService.addUser(new User(1l, "Bob", "123", "bob@mail.com"));
        UserService.addUser(new User(2l, "Rob", "123", "rob@mail.com"));
        UserService.addUser(new User(3l, "Bon", "123", "bon@mail.com"));
        UserService.addUser(new User(4l, "Max", "123", "max@mail.com"));
        UserService.addUser(new User(5l, "Pit", "123", "pit@mail.com"));

        StorageService.addStorage(new Storage(1l, "BankCard", UserService.getUserById(1l).get()));
        StorageService.addStorage(new Storage(2l, "Home",     UserService.getUserById(1l).get()));
        StorageService.addStorage(new Storage(3l, "BankCard", UserService.getUserById(2l).get()));
        StorageService.addStorage(new Storage(4l, "BankCard", UserService.getUserById(3l).get()));
        StorageService.addStorage(new Storage(5l, "BankCard", UserService.getUserById(5l).get()));




    }
}
