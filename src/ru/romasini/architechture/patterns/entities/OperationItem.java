package ru.romasini.architechture.patterns.entities;

import ru.romasini.architechture.patterns.utils.TypeOperationItem;

public class OperationItem {
    private Long id;
    private AbstractOperation operation;
    private Storage storage;
    private Source source;
    private TypeOperationItem typeOperationItem;
    private Double amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AbstractOperation getOperation() {
        return operation;
    }

    public void setOperation(AbstractOperation operation) {
        this.operation = operation;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public TypeOperationItem getTypeOperation() {
        return typeOperationItem;
    }

    public void setTypeOperation(TypeOperationItem typeOperationItem) {
        this.typeOperationItem = typeOperationItem;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}
