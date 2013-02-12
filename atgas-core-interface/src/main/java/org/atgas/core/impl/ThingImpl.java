package org.atgas.core.impl;

import com.google.common.collect.Lists;
import org.atgas.core.Description;
import org.atgas.core.Relationship;
import org.atgas.core.Thing;

import java.io.Serializable;
import java.util.*;

public final class ThingImpl implements Serializable, Thing {

    private static final long serialVersionUID = -4827299592734550960L;
    
    private String id;
    private final Collection<Relationship> relationships;
    private final Collection<Description> descriptions;

    public ThingImpl(String id, Iterable<Relationship>  relationships, Iterable<Description> descriptions) {
        this.id = id;
        this.relationships = Collections.unmodifiableCollection(Lists.newArrayList(relationships));
        this.descriptions =  Collections.unmodifiableCollection(Lists.newArrayList(descriptions));
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public Iterable<Relationship> getRelationships() {
        return Collections.unmodifiableCollection(relationships);
    }

    @Override
    public Iterable<Description> getDescriptions() {
        return Collections.unmodifiableCollection(descriptions);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Thing)) {
            return false;
        }
        return id.equals(((Thing)other).getID());
    }
    
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
