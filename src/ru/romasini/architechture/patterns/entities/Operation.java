package ru.romasini.architechture.patterns.entities;

public class Operation extends AbstractOperation{
    private Storage storage;

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", date=" + date +
                ", user=" + user +
                ", source=" + source +
                ", amount=" + amount +
                ", storage=" + storage +
                '}';
    }
}
