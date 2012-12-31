/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.atgas.core;

/**
 *
 * @author ken
 */
public class ProxyRelationship implements Relationship {
    private final RelationshipType type;
    private final String destinationID;
    private final String originID;
    
    public ProxyRelationship(RelationshipType type, Thing origin, Thing destination) {
        this(type, origin.getID(), destination.getID());
    }
    
    public ProxyRelationship(String type, Thing origin, Thing destination) {
        this(new RelationshipType(type), origin.getID(), destination.getID());
    }
    
    public ProxyRelationship(String type, String originID, String destinationID) {
        this(new RelationshipType(type), originID, destinationID);
    }
    
    public ProxyRelationship(RelationshipType type, String originID, String destinationID) {
        this.type = type;
        this.originID = originID;
        this.destinationID = destinationID;
    }

    @Override
    public String getOriginID() {
        return destinationID;
    }

    @Override
    public String getDestinationID() {
        return destinationID;
    }

    @Override
    public RelationshipType getType() {
        return type;
    }
    
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Relationship)) {
            return false;
        }

        Relationship relationship = (Relationship)other;

        String otherID = ((Relationship)other).getDestinationID();
        return getOriginID().equals(relationship.getOriginID()) &&
                getDestinationID().equals(relationship.getDestinationID()) &&
                getType().equals(relationship.getType());
    }
    
    @Override
    public int hashCode() {
        return getOriginID().hashCode() * getDestinationID().hashCode() * getType().hashCode();
    }    
}
