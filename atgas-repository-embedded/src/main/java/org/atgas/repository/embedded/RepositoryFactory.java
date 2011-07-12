package org.atgas.repository.embedded;

public class RepositoryFactory {
	public Reposity create(Store store) {
		return new Repository(store);
	}
}
