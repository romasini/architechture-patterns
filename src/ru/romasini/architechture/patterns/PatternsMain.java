package ru.romasini.architechture.patterns;

import ru.romasini.architechture.patterns.decorator.OperationFailed;
import ru.romasini.architechture.patterns.decorator.OperationSuccess;
import ru.romasini.architechture.patterns.entities.AbstractOperation;
import ru.romasini.architechture.patterns.entities.Source;
import ru.romasini.architechture.patterns.entities.Storage;
import ru.romasini.architechture.patterns.entities.User;
import ru.romasini.architechture.patterns.fabric.Fabric;
import ru.romasini.architechture.patterns.fabric.Factory;
import ru.romasini.architechture.patterns.observer.ClientObserver;
import ru.romasini.architechture.patterns.observer.TaxOfficeObserver;
import ru.romasini.architechture.patterns.services.SourceService;
import ru.romasini.architechture.patterns.services.StorageService;
import ru.romasini.architechture.patterns.services.UserService;
import ru.romasini.architechture.patterns.utils.TypeOperation;
import ru.romasini.architechture.patterns.utils.TypeOperationItem;

import java.util.ArrayList;
import java.util.List;

public class PatternsMain {
    public static void main(String[] args) {


        //Mocking
        UserService.addUser(UserService.ADMIN);
        UserService.addUser(new User(2l, "Bob", "123", "bob@mail.com"));
        UserService.addUser(new User(3l, "Rob", "123", "rob@mail.com"));
        UserService.addUser(new User(4l, "Bon", "123", "bon@mail.com"));
        UserService.addUser(new User(5l, "Max", "123", "max@mail.com"));
        UserService.addUser(new User(6l, "Pit", "123", "pit@mail.com"));

        StorageService.addStorage(new Storage(1l, "BankCard", UserService.getUserById(1l).get()));
        StorageService.addStorage(new Storage(2l, "Home",     UserService.getUserById(1l).get()));
        StorageService.addStorage(new Storage(3l, "BankCard",  UserService.getUserById(2l).get()));
        StorageService.addStorage(new Storage(6l, "BankCard1", UserService.getUserById(2l).get()));
        StorageService.addStorage(new Storage(4l, "BankCard", UserService.getUserById(3l).get()));
        StorageService.addStorage(new Storage(5l, "BankCard", UserService.getUserById(5l).get()));

        SourceService.addSource(SourceService.TRANSPORTATION);
        SourceService.addSource(new Source(2l, UserService.getUserById(1l).get(), "Other", TypeOperationItem.DEBIT));
        SourceService.addSource(new Source(3l, UserService.getUserById(1l).get(), "Other", TypeOperationItem.CREDIT));
        SourceService.addSource(new Source(4l, UserService.getUserById(2l).get(), "Sells", TypeOperationItem.DEBIT));
        SourceService.addSource(new Source(5l, UserService.getUserById(2l).get(), "Buy", TypeOperationItem.CREDIT));
        SourceService.addSource(new Source(6l, UserService.getUserById(3l).get(), "Deposit", TypeOperationItem.DEBIT));

        //Observer
        ClientObserver client = new ClientObserver();
        TaxOfficeObserver taxOfficeObserver = new TaxOfficeObserver();

        //Fabric
        Fabric fabric = Fabric.getInstance();

        Factory simpleFactory = fabric.createFactory(TypeOperation.SIMPLE);
        Factory transportFactory = fabric.createFactory(TypeOperation.TRANSPORT);

        User user = UserService.getUserById(2l).get();

        Storage storage = StorageService.getStorageById(3l).get();
        Storage storageTo = StorageService.getStorageById(6l).get();

        storage.attach(client);
        storage.attach(taxOfficeObserver);
        storageTo.attach(taxOfficeObserver);

        Source source = SourceService.getSourceById(4l).get();

        List<Storage> storageList = new ArrayList<>();
        storageList.add(storage);

        AbstractOperation op1 = simpleFactory.createProvider().createOperation(user, source, 500d, storageList);

        storageList.add(storageTo);
        AbstractOperation tr1 = transportFactory.createProvider().createOperation(user, SourceService.TRANSPORTATION, 200d, storageList);

        System.out.println(op1);
        System.out.println(tr1);


        //Decorator
        OperationFailed operationFailed = new OperationFailed(tr1);
        operationFailed.changeOperation("1");
        System.out.println(tr1.getComment());

        OperationSuccess operationSuccess = new OperationSuccess(operationFailed);
        operationSuccess.changeOperation("2");
        System.out.println(tr1.getComment());




    }
}
