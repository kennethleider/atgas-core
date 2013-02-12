package org.atgas.core;

import java.util.Set;

/**
 * Created with IntelliJ IDEA. User: Ken Leider Date: 2/12/13 Time: 10:45 AM To change this template use File | Settings
 * | File Templates.
 */
public interface Thing {

    String getID();
    Iterable<Relationship> getRelationships();
    Iterable<Description> getDescriptions();

}
