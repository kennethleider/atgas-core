package org.atgas.core;

import java.util.Set;

/**
 * Created with IntelliJ IDEA. User: Ken Leider Date: 2/12/13 Time: 10:51 AM To change this template use File | Settings
 * | File Templates.
 */
public interface Change {
    public Set<Thing> getAdds();

    public Set<Thing> getReplaces();

    public Set<Thing> getRemoves();
}
