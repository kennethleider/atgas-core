package org.atgas.repository.embedded;

import org.atgas.store.Store;

public class RepositoryFactory {

    public Repository create(Store store) {
        return new Repository(store);
    }
}
