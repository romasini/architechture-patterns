package ru.romasini.architechture.patterns.services;

import ru.romasini.architechture.patterns.entities.Source;
import ru.romasini.architechture.patterns.utils.TypeOperationItem;

import java.util.*;

public class SourceService {

    public static final Source TRANSPORTATION = new Source(1l, UserService.ADMIN, "Transportation", TypeOperationItem.CREDIT);

    private static List<Source> sourceList = new ArrayList<>();

    public static Optional<Source> getSourceById(Long id){
        return sourceList.stream().filter(u->u.getId().equals(id)).findAny();
    }

    public static void addSource(Source s){
        sourceList.add(s);
    }

    public static void deleteSourceById(Long id){
        Iterator<Source> iterator = sourceList.iterator();
        while (iterator.hasNext()){
            Source temp = iterator.next();
            if(temp.getId().equals(id)){
                iterator.remove();
            }
        }
    }

    public static Long getNextId(){
        OptionalLong ol = sourceList.stream().mapToLong(o->o.getId()).max();
        if(ol.isPresent()){
            return ol.getAsLong() + 1;
        }else{
            return 1l;
        }
    }
}
