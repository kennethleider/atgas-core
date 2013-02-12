package org.atgas.core;

import java.util.Set;

/**
 * Created with IntelliJ IDEA. User: Ken Leider Date: 2/12/13 Time: 10:43 AM To change this template use File | Settings
 * | File Templates.
 */
public interface Description {

    String getStandardID();

    String getSourceID();

    Set<String> getProperties();

    Object get(String key);

    boolean getBoolean(String key);

    double getDouble(String key);

    int getInt(String key);

    long getLong(String key);

    String getString(String key);

    boolean has(String key);

    int propertyCount();
}
