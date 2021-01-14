package ru.romasini.architechture.patterns.fabric;

import ru.romasini.architechture.patterns.entities.*;
import ru.romasini.architechture.patterns.services.OperationItemService;
import ru.romasini.architechture.patterns.services.OperationService;

import java.util.Date;
import java.util.List;

public class OperationProvider implements FactoryProvider{
    @Override
    public AbstractOperation createOperation(User user, Source source, Double amount, List<Storage> storageList) {
        Operation op = new Operation();
        op.setId(OperationService.getNextId());
        op.setUser(user);
        op.setSource(source);
        op.setDate(new Date());
        op.setStorage(storageList.get(0));
        op.setAmount(amount);

        OperationItem opI = new OperationItem();
        opI.setId(OperationItemService.getNextId());
        opI.setOperation(op);
        opI.setTypeOperation(source.getType());
        opI.setSource(source);
        opI.setStorage(storageList.get(0));
        opI.setAmount(amount);

        OperationItemService.addOperationItem(opI);
        OperationService.addOperation(op);

        return op;
    }
}
