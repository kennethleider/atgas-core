package org.atgas.core;

import java.io.Serializable;

public interface Relationship extends Serializable {

    String getOriginID();

    String getDestinationID();
    
    RelationshipType getType();
    
}
