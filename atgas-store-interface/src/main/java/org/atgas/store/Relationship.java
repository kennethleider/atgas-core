package org.atgas.store;

import java.io.Serializable;

public interface Relationship extends Serializable {
    
    String getTargetID();
    
    RelationshipType getType();
    
}
