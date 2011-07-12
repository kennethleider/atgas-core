package org.atgas.store;

import java.util.Set;

public interface Store {
	public void addThings(Thing... things);
	public void removeThings(Thing... things);
	
	public void addRelationships(Relationship... relationships);
	public void removeRelationships(Relationship... relationships);
	
	public Set<Thing> query(String query);
	public Set<Thing> query(String query, String queryLanguage);
	public Set<String> supportedQueryLanguages();
	public void close();
}
