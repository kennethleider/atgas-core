package org.atgas.core.impl;

import com.google.common.collect.Lists;
import org.atgas.core.Description;
import org.atgas.core.Relationship;
import org.atgas.core.Thing;
import org.atgas.core.UUIDGenerator;
import sun.reflect.generics.tree.Tree;

import java.io.Serializable;
import java.util.*;

/**
 * Created with IntelliJ IDEA. User: Ken Leider Date: 2/12/13 Time: 11:04 AM To change this template use File | Settings
 * | File Templates.
 */
public class MutableThing implements Serializable, Thing {

    private String id;
    private final Collection<Relationship> relationships = new TreeSet<>();
    private final Collection<Description> descriptions = new TreeSet<>();

    public MutableThing() {
        this.id = UUIDGenerator.newID();
    }

    public MutableThing(Description... descriptions) {
        this();
        this.descriptions.addAll(Arrays.asList(descriptions));
    }

    public MutableThing(String id) {
        this.id = id;
    }

    public MutableThing(String id, Description... descriptions) {
        this(id);
        this.descriptions.addAll(Arrays.asList(descriptions));
    }

    public MutableThing(Thing thing) {
        this.id = thing.getID();
        this.relationships.addAll(Lists.newArrayList(thing.getRelationships()));
        this.descriptions.addAll(Lists.newArrayList(thing.getDescriptions()));
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

    public void addDescription(Description description) {
        descriptions.add(description);
    }

    public void removeDescription(Description description) {
        descriptions.remove(description);
    }

    public void addRelationship(Relationship relationship) {
        relationships.add(relationship);
    }

    public void removeRelationship(Relationship relationship) {
        relationships.remove(relationship);
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
