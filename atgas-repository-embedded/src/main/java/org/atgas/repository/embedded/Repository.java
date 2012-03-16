package org.atgas.repository.embedded;

import org.atgas.store.Store;
import org.atgas.store.Thing;

public class Repository {

    private final Store store;

    public Repository(Store store) {
        this.store = store;
    }

    public Thing getSelf() {
        return null;
    }
}
