/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.atgas.core.impl;

import org.atgas.core.Relationship;
import org.atgas.core.Thing;

import java.io.Serializable;

/**
 *
 * @author ken
 */
public class DeepRelationship implements Relationship, Serializable {
    private final String type;
    private final Thing origin;
    private final Thing destination;
    
    public DeepRelationship(String type, Thing origin, Thing destination) {
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
    public String getType() {
        return type;
    }

    public Thing getOrigin() {
        return origin;
    }

    public Thing getDestination() {
        return destination;
    }
}
