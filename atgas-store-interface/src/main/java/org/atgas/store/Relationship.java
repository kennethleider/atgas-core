package org.atgas.store;

import java.io.Serializable;

public interface Relationship extends Serializable {
    
    String getTargetID();
    
    String getTargetStandardID();
    
    String getTargetSourceID();
    
    RelationshipType getType();
    
}
