package ru.romasini.architechture.patterns.fabric;

import ru.romasini.architechture.patterns.entities.AbstractOperation;
import ru.romasini.architechture.patterns.entities.Source;
import ru.romasini.architechture.patterns.entities.Storage;
import ru.romasini.architechture.patterns.entities.User;

import java.util.List;

public interface FactoryProvider {

    AbstractOperation createOperation(User user, Source source, Double amount, List<Storage> storageList);

}
