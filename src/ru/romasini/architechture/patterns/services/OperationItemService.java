package ru.romasini.architechture.patterns.services;

import ru.romasini.architechture.patterns.entities.AbstractOperation;
import ru.romasini.architechture.patterns.entities.OperationItem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalLong;
import java.util.stream.Collectors;

public class OperationItemService {

    private static List<OperationItem> operationItemList = new ArrayList<>();

    public static List<OperationItem> getItemByOperation(AbstractOperation operation){
        return operationItemList.stream().filter(u->u.getOperation().equals(operation)).collect(Collectors.toList());
    }

    public static void addOperationItem(OperationItem o){
        operationItemList.add(o);
    }

    public static void deleteOperationItemByOperation(AbstractOperation operation){
        Iterator<OperationItem> iterator = operationItemList.iterator();
        while (iterator.hasNext()){
            OperationItem temp = iterator.next();
            if(temp.getOperation().equals(operation)){
                iterator.remove();
            }
        }
    }

    public static Long getNextId(){
        OptionalLong ol = operationItemList.stream().mapToLong(o->o.getId()).max();
        if(ol.isPresent()){
            return ol.getAsLong() + 1;
        }else{
            return 1l;
        }
    }
}
