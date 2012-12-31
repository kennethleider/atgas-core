/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.atgas.core;

import java.util.Collection;
import java.util.concurrent.Callable;

/**
 *
 * @author ken
 */
public class AddCollector implements Callable<Collection<Thing>> {

    private final Callable<Change> sourceCollector;
    
    public AddCollector(Callable<Change> sourceCollector) {
        this.sourceCollector = sourceCollector;
    }
    
    @Override
    public Collection<Thing> call() throws Exception {
        return sourceCollector.call().getAdds();
    }
    
}
