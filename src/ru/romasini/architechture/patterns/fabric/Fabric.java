package ru.romasini.architechture.patterns.fabric;

import ru.romasini.architechture.patterns.utils.TypeOperation;

public class Fabric {

    public Factory createFactory(TypeOperation type){
        switch (type){
            case TRANSPORT: return new TransportationFactory();
            default: return new OperationFactory();
        }
    }

    private static Fabric instance = new Fabric();

    public static Fabric getInstance() {
        return instance;
    }

    private Fabric(){};

}
