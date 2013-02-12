/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.atgas.core.impl;

import org.atgas.core.Description;
import org.atgas.core.Relationship;
import org.atgas.core.Thing;

/**
 *
 * @author ken
 */
public class ShallowRelationship implements Relationship {
    private final String type;
    private final String destinationID;
    private final String originID;

    public ShallowRelationship(String type, Thing origin, Thing destination) {
        this(type, origin.getID(), destination.getID());
    }
    
    public ShallowRelationship(String type, String originID, String destinationID) {
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
    public String getType() {
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
