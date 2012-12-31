/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.atgas.core;

import java.io.Serializable;

/**
 *
 * @author ken
 */
public class ConcreteRelationship implements Relationship, Serializable {
    private final RelationshipType type;
    private final Thing origin;
    private final Thing destination;
    
    public ConcreteRelationship(String type, Thing origin, Thing destination) {
        this.type = new RelationshipType(type);
        this.origin = origin;
        this.destination = destination;
    }
        
    public ConcreteRelationship(RelationshipType type, Thing origin, Thing destination) {
        this.type = type;
        this.origin = origin;
        this.destination = destination;
    }

    @Override
    public String getOriginID() {
        return getOrigin().getID();
    }

    @Override
    public String getDestinationID() {
        return getDestination().getID();
    }

    @Override
    public RelationshipType getType() {
        return type;
    }

    public Thing getOrigin() {
        return origin;
    }

    public Thing getDestination() {
        return destination;
    }
}
