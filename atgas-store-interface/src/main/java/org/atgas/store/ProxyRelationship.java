/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.atgas.store;

/**
 *
 * @author ken
 */
public class ProxyRelationship implements Relationship {
    private final RelationshipType type;
    private final String targetID;
    
    public ProxyRelationship(String type, String targetID) {
        this.type = new RelationshipType(type);
        this.targetID = targetID;
    }
    
    public ProxyRelationship(RelationshipType type, String targetID) {
        this.type = type;
        this.targetID = targetID;
    }

    @Override
    public String getTargetID() {
        return targetID;
    }

    @Override
    public RelationshipType getType() {
        return type;
    }
}
