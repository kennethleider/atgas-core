package org.atgas.core;

import java.io.Serializable;
import java.util.Set;

public interface Relationship extends Serializable {

    String getOriginID();

    String getDestinationID();

    String getType();
}
