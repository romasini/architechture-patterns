package ru.romasini.architechture.patterns.fabric;

import ru.romasini.architechture.patterns.entities.*;
import ru.romasini.architechture.patterns.services.OperationItemService;
import ru.romasini.architechture.patterns.services.TransportationService;
import ru.romasini.architechture.patterns.utils.TypeOperationItem;

import java.util.Date;
import java.util.List;

public class TransportationProvider implements FactoryProvider{
    @Override
    public AbstractOperation createOperation(User user, Source source, Double amount, List<Storage> storageList) {
        Transportation op = new Transportation();
        op.setId(TransportationService.getNextId());
        op.setUser(user);
        op.setSource(source);
        op.setDate(new Date());
        op.setStorageFrom(storageList.get(0));
        op.setStorageTo(storageList.get(1));
        op.setAmount(amount);

        OperationItem opCredit = new OperationItem();
        opCredit.setId(OperationItemService.getNextId());
        opCredit.setOperation(op);
        opCredit.setTypeOperation(TypeOperationItem.CREDIT);
        opCredit.setSource(source);
        opCredit.setStorage(op.getStorageFrom());
        opCredit.setAmount(amount);

        OperationItemService.addOperationItem(opCredit);

        OperationItem opDebit = new OperationItem();
        opDebit.setId(OperationItemService.getNextId());
        opDebit.setOperation(op);
        opDebit.setTypeOperation(TypeOperationItem.DEBIT);
        opDebit.setSource(source);
        opDebit.setStorage(op.getStorageTo());
        opDebit.setAmount(amount);

        OperationItemService.addOperationItem(opDebit);

        TransportationService.addOperation(op);

        return op;
    }
}
