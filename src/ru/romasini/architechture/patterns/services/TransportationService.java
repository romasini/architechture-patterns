package ru.romasini.architechture.patterns.services;

import ru.romasini.architechture.patterns.entities.Transportation;

import java.util.*;

public class TransportationService {

    private static List<Transportation> operationList = new ArrayList<>();

    public static Optional<Transportation> getOperationById(Long id){
        return operationList.stream().filter(u->u.getId().equals(id)).findAny();
    }

    public static void addOperation(Transportation o){
        operationList.add(o);
    }

    public static void deleteOperationById(Long id){
        Iterator<Transportation> iterator = operationList.iterator();
        while (iterator.hasNext()){
            Transportation temp = iterator.next();
            if(temp.getId().equals(id)){
                OperationItemService.deleteOperationItemByOperation(temp);
                iterator.remove();
            }
        }
    }

    public static Long getNextId(){
        OptionalLong ol = operationList.stream().mapToLong(o->o.getId()).max();
        if(ol.isPresent()){
            return ol.getAsLong() + 1;
        }else{
            return 1l;
        }
    }

}
