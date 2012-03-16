/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.atgas.store;

import java.io.Serializable;

/**
 *
 * @author ken
 */
public class ConcreteRelationship implements Relationship, Serializable {
    private final RelationshipType type;
    private final Thing target;
    
    public ConcreteRelationship(String type, Thing target) {
        this.type = new RelationshipType(type);
        this.target = target;
    }
        
    public ConcreteRelationship(RelationshipType type, Thing target) {
        this.type = type;
        this.target = target;
    }

    @Override
    public String getTargetID() {
        return getTarget().getID();
    }

    @Override
    public RelationshipType getType() {
        return type;
    }
    
    public Thing getTarget() {
        return target;
    }
}
