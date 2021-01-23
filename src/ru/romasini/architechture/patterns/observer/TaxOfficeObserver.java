package ru.romasini.architechture.patterns.observer;

import ru.romasini.architechture.patterns.entities.AbstractOperation;
import ru.romasini.architechture.patterns.entities.OperationItem;
import ru.romasini.architechture.patterns.services.OperationItemService;
import ru.romasini.architechture.patterns.utils.TypeOperationItem;

import java.util.List;

public class TaxOfficeObserver implements Observer{
    @Override
    public void update(Subject s, AbstractOperation arg) {
        List<OperationItem> operationItemList = OperationItemService.getItemByOperation(arg);
        for (OperationItem oi:operationItemList) {
            if (oi.getTypeOperation()==TypeOperationItem.DEBIT){
                getTax(arg, oi);
            }
        }
    }

    private void getTax(AbstractOperation operation, OperationItem oi){
        System.out.println("Get tax from : " + operation.getUser());
        System.out.println("For : " + operation);
        System.out.println("Tax : " + oi.getAmount() * 0.5);
    }
}
