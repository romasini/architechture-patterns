package ru.romasini.architechture.patterns.entities;

public class Transportation extends AbstractOperation{
    private Storage storageFrom;
    private Storage storageTo;

    public Storage getStorageFrom() {
        return storageFrom;
    }

    public void setStorageFrom(Storage storageFrom) {
        this.storageFrom = storageFrom;
    }

    public Storage getStorageTo() {
        return storageTo;
    }

    public void setStorageTo(Storage storageTo) {
        this.storageTo = storageTo;
    }

    @Override
    public String toString() {
        return "Transportation{" +
                "id=" + id +
                ", date=" + date +
                ", user=" + user +
                ", source=" + source +
                ", amount=" + amount +
                ", storageFrom=" + storageFrom +
                ", storageTo=" + storageTo +
                '}';
    }
}
