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

    public Change() {        
    }
    
    public Change(Collection<Thing> adds, Collection<Thing> removes) {
        if(adds != null) this.adds.addAll(adds);
        if(removes != null) this.removes.addAll(removes);
    }
    
    public void add(Thing thing) {
        adds.add(thing);
    }
    
    public void remove(Thing thing) {
        removes.add(thing);
    }
    
    public Set<Thing> getAdds() {
        return adds;
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
    
    public void remove(Collection<Thing> things) {
        if (things == null) {
            return;
        }
        for (Thing thing : things) {
            remove(thing);
        }
    }
}
