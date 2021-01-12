package ru.romasini.architechture.patterns.decorator;

public class OperationSuccess extends OperationDecorator{

    public OperationSuccess(OperationComponent operation) {
        super(operation);
    }

    @Override
    public void changeOperation(String comment) {
        operation.changeOperation("Operation is success " + comment);
    }
}
