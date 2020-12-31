package ru.romasini.architechture.patterns.services;

import ru.romasini.architechture.patterns.entities.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class UserService {

    private static List<User> userList = new ArrayList<>();



    public static Optional<User> getUserById(Long id){
        return userList.stream().filter(u->u.getId()==id).findAny();
    }

    public static void addUser(User u){
        userList.add(u);
    }

    public static void deleteUserById(Long id){
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()){
            User temp = iterator.next();
            if(temp.getId() == id){
                iterator.remove();
            }
        }
    }

}
