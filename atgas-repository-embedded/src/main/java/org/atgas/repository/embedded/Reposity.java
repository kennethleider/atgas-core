package org.atgas.repository.embedded;

import org.atgas.store.BuiltIns;
import org.atgas.store.Store;
import org.atgas.store.Thing;

public class Reposity {
	private final Store store;

	public Reposity(Store store) {
		this.store = store;
	}
	
	public Thing getSelf() {
		return null;
	}
}
