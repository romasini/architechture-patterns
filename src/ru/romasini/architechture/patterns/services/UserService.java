package ru.romasini.architechture.patterns.services;

import ru.romasini.architechture.patterns.entities.User;

import java.util.*;

public class UserService {

    public static final User ADMIN = new User(1l, "Administration", "123", "admin@mail.com");

    private static List<User> userList = new ArrayList<>();

    public static Optional<User> getUserById(Long id){
        return userList.stream().filter(u->u.getId().equals(id)).findAny();
    }

    public static void addUser(User u){
        userList.add(u);
    }

    public static void deleteUserById(Long id){
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()){
            User temp = iterator.next();
            if(temp.getId().equals(id)){
                iterator.remove();
            }
        }
    }

    public static Long getNextId(){
        OptionalLong ol = userList.stream().mapToLong(o->o.getId()).max();
        if(ol.isPresent()){
            return ol.getAsLong() + 1;
        }else{
            return 1l;
        }
    }

}
