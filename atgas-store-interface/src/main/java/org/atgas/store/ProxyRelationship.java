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
    private final String targetStandardID;
    private final String targetSourceID;
    
    public ProxyRelationship(RelationshipType type, Thing target) {
        this(type, target.getID(), target.getStandardID(), target.getSourceID());
    }
    
    public ProxyRelationship(String type, Thing target) {
        this(new RelationshipType(type), target.getID(), target.getStandardID(), target.getSourceID());
    }
    
    public ProxyRelationship(String type, String targetID, String targetStandardID, String targetSourceID) {
        this(new RelationshipType(type), targetID, targetStandardID, targetSourceID);
    }
    
    public ProxyRelationship(RelationshipType type, String targetID, String targetStandardID, String targetSourceID) {
        this.type = type;
        this.targetID = targetID;
        this.targetStandardID = targetStandardID;
        this.targetSourceID = targetSourceID;
    }

    @Override
    public String getTargetID() {
        return targetID;
    }

    @Override
    public RelationshipType getType() {
        return type;
    }

    @Override
    public String getTargetStandardID() {
        return targetStandardID;
    }

    @Override
    public String getTargetSourceID() {
        return targetSourceID;
    }
    
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Relationship)) {
            return false;
        }
        String otherID = ((Relationship)other).getTargetID();        
        return getTargetID().equals(otherID);
    }
    
    @Override
    public int hashCode() {
        return getTargetID().hashCode();
    }    
}
