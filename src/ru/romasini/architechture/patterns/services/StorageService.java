package ru.romasini.architechture.patterns.services;

import ru.romasini.architechture.patterns.entities.Storage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class StorageService {

    private static List<Storage> storageList = new ArrayList<>();

    public static Optional<Storage> getStorageById(Long id){
        return storageList.stream().filter(u->u.getId()==id).findAny();
    }

    public static void addStorage(Storage s){
        storageList.add(s);
    }

    public static void deleteStorageById(Long id){
        Iterator<Storage> iterator = storageList.iterator();
        while (iterator.hasNext()){
            Storage temp = iterator.next();
            if(temp.getId() == id){
                iterator.remove();
            }
        }
    }
}
