package ru.romasini.architechture.patterns.fabric;

public class OperationFactory implements Factory{
    @Override
    public FactoryProvider createProvider() {
        return new OperationProvider();
    }
}
