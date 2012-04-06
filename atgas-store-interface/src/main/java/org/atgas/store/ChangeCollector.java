/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.atgas.store;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

/**
 *
 * @author ken
 */
public class ChangeCollector implements Callable<Change> {

    private final Change change;
    
    public ChangeCollector(Collection<Thing> adds, Collection<Thing> removes) {
        this.change = new Change(adds, removes);
    }
    
    public ChangeCollector(Change change) {
        this.change = change;
    }
    
    @Override
    public Change call() throws Exception {
        return change;
    }
    
}
