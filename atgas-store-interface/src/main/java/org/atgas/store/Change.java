/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.atgas.store;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author ken
 */
public class Change {
    private final Set<Thing> adds = new LinkedHashSet<>();
    private final Set<Thing> removes = new LinkedHashSet<>();
    private final Set<Thing> replaces = new LinkedHashSet<>();

    public Change() {
    }

    public Change(Collection<Thing> adds, Collection<Thing> replaces, Collection<Thing> removes) {
        if(adds != null) this.adds.addAll(adds);
        if(removes != null) this.removes.addAll(removes);
        if(replaces != null) this.removes.addAll(replaces);
    }

    public void add(Thing thing) {
        adds.add(thing);
    }

    public void replace(Thing thing) {
        replaces.add(thing);
    }

    public void remove(Thing thing) {
        removes.add(thing);
    }

    public Set<Thing> getAdds() {
        return adds;
    }

    public Set<Thing> getReplaces() {
        return replaces;
    }

    public Set<Thing> getRemoves() {
        return removes;
    }

    public void add(Collection<Thing> things) {
        if (things == null) {
            return;
        }
        for (Thing thing : things) {
            add(thing);
        }
    }

    public void replace(Collection<Thing> things) {
        if (things == null) {
            return;
        }
        for (Thing thing : things) {
            replace(thing);
        }
    }

    public void remove(Collection<Thing> things) {
        if (things == null) {
            return;
        }
        for (Thing thing : things) {
            remove(thing);
        }
    }
}
