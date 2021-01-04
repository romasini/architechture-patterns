package ru.romasini.architechture.patterns.fabric;

public class TransportationFactory implements Factory{
    @Override
    public FactoryProvider createProvider() {
        return new TransportationProvider();
    }
}
