package ru.romasini.architechture.patterns.services;

import ru.romasini.architechture.patterns.entities.Operation;

import java.util.*;

public class OperationService {

    private static List<Operation> operationList = new ArrayList<>();

    public static Optional<Operation> getOperationById(Long id){
        return operationList.stream().filter(u->u.getId().equals(id)).findAny();
    }

    public static void addOperation(Operation o){
        operationList.add(o);
    }

    public static void deleteOperationById(Long id){
        Iterator<Operation> iterator = operationList.iterator();
        while (iterator.hasNext()){
            Operation temp = iterator.next();
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
