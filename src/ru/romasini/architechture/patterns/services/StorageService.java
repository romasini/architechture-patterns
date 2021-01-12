package ru.romasini.architechture.patterns.services;

import ru.romasini.architechture.patterns.entities.Storage;

import java.util.*;

public class StorageService {

    private static List<Storage> storageList = new ArrayList<>();

    public static Optional<Storage> getStorageById(Long id){
        return storageList.stream().filter(u->u.getId().equals(id)).findAny();
    }

    public static void addStorage(Storage s){
        storageList.add(s);
    }

    public static void deleteStorageById(Long id){
        Iterator<Storage> iterator = storageList.iterator();
        while (iterator.hasNext()){
            Storage temp = iterator.next();
            if(temp.getId().equals(id)){
                iterator.remove();
            }
        }
    }

    public static Long getNextId(){
        OptionalLong ol = storageList.stream().mapToLong(o->o.getId()).max();
        if(ol.isPresent()){
            return ol.getAsLong() + 1;
        }else{
            return 1l;
        }
    }
}
