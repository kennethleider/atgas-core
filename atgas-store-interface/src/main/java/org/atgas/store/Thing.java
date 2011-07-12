package org.atgas.store;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public final class Thing implements Serializable{
	private static final long serialVersionUID = -4827299592734550960L;
	
	private String id;
	public final String standardID;
	public final String sourceID;
	
	private final Map<String, String> properties = new HashMap<String, String>();
	
	public Thing(String standardID, String sourceID) {
		this.standardID = standardID;
		this.sourceID = sourceID;		
	}
	
	public Thing(String id, String standardID, String sourceID) {
		this(standardID, sourceID);
		this.id = id;
	}

	public String getSourceID() {
		return sourceID;
	}

	public String getStandardID() {
		return standardID;
	}

	public String generateID() {
		id = UUID.randomUUID().toString();
		return getId();
	}
	
	public String getId() {
		return id;
	}
	
	public void setProperty(String property, String value) {
		if (value == null) {
			properties.remove(property);
		}
		
		properties.put(property, value);
	}
	
	public Set<String> getProperties() {
		return properties.keySet();
	}
	
	public Set<Entry<String, String>> getPropertyValues() {
		return properties.entrySet();
	}
	
	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Thing)) {
			return false;
		}
		String otherID = ((Thing)other).id;
		if (id == null || otherID == null) {
			return false;
		}	
			
		return id.equals(otherID);
	}
	
	@Override
	public int hashCode() {
		if (id != null) {
			return id.hashCode();
		}
		
		return super.hashCode();
	}
}
