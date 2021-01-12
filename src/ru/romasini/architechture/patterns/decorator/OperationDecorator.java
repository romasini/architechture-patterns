package ru.romasini.architechture.patterns.decorator;

public abstract class OperationDecorator implements OperationComponent{

    protected OperationComponent operation;

    public OperationDecorator(OperationComponent operation) {
        this.operation = operation;
    }

}
