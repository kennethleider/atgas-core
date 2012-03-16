package org.atgas.store;

import java.io.Serializable;
import java.util.*;
import java.util.Map.Entry;

public final class Thing implements Serializable{
    private static final long serialVersionUID = -4827299592734550960L;
    
    private String id;
    
    private final Map<String, String> properties = new HashMap<String, String>();
    private final List<Relationship> relationships = new ArrayList<>();
    
    public Thing(String standardID, String sourceID) {
        this.id = UUID.randomUUID().toString();
        relationships.add(new ProxyRelationship("Source", sourceID));
        relationships.add(new ProxyRelationship("Standard", standardID));        
    }
    
    public Thing(String id, String standardID, String sourceID) {
        this.id = id;
        relationships.add(new ProxyRelationship(RelationshipType.Source, sourceID));
        relationships.add(new ProxyRelationship(RelationshipType.Standard, standardID));         
    }
    
    public String getID() {
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

    public Iterable<Relationship> getRelationships() {
        return Collections.unmodifiableCollection(relationships);
    }
}
