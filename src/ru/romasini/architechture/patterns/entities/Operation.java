package ru.romasini.architechture.patterns.entities;

import ru.romasini.architechture.patterns.utils.TypeOperationItem;

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


    @Override
    public void changeOperation(String comment) {
        if(source.getType() == TypeOperationItem.CREDIT){
            this.comment = comment + " transport from " + storage.getName() ;
        }else {
            this.comment = comment + " transport to " + storage.getName() ;
        }

    }
}
