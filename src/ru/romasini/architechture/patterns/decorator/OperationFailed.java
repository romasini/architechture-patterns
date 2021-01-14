package ru.romasini.architechture.patterns.decorator;

public class OperationFailed extends OperationDecorator{

    public OperationFailed(OperationComponent operation) {
        super(operation);
    }

    @Override
    public void changeOperation(String comment) {
        operation.changeOperation("Operation is failed " + comment);
    }
}
