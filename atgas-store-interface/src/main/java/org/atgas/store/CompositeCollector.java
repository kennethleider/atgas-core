/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.atgas.store;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;

/**
 *
 * @author ken
 */
public class CompositeCollector<V> implements Callable<Collection<V>> {
    private final Collection<Callable<Collection<V>>> collectors;

    public CompositeCollector(Collection<Callable<Collection<V>>> collectors) {
        this.collectors = collectors;        
    }
    
    @Override
    public Collection<V> call() throws Exception {
        Collection<V> retval = new ArrayList<>();
        
        for (Callable<Collection<V>> collector : collectors) {
            retval.addAll(collector.call());
        }
        
        return retval;
    }
    
}
