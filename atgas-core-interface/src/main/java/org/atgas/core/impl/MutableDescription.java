package org.atgas.core.impl;

import org.atgas.core.Description;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA. User: Ken Leider Date: 2/12/13 Time: 1:38 PM To change this template use File | Settings
 * | File Templates.
 */
public class MutableDescription implements Description {
    private final Map<String, Object> properties = new HashMap<>();
    private final String standardID;
    private final String sourceID;

    public MutableDescription(String standardID, String sourceID) {
        this.standardID = standardID;
        this.sourceID = sourceID;
    }

    public String getStandardID() {
        return standardID;
    }

    public String getSourceID() {
        return sourceID;
    }

    public void unsetProperty(String property) {
        setProperty(property, null);
    }

    public void setProperty(String property, Object value) {
        if (value == null) {
            properties.remove(property);
        } else {
            properties.put(property, value);
        }
    }

    public void setProperties(Map<String,String> properties) {
        for(Map.Entry<String, String> entry : properties.entrySet()) {
              setProperty(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public Set<String> getProperties() {
        return new LinkedHashSet<String>(properties.keySet());
    }

    @Override
    public Object get(String key) {
        if (key == null) {
            return null;
        }

        return properties.get(key);
    }

    @Override
    public boolean getBoolean(String key) {
        Object object = get(key);
        if (object.equals(Boolean.FALSE)) return false;
        if (object.equals(Boolean.TRUE)) return true;
        if (object instanceof String) {
            String string = (String)object;

            if (string.equalsIgnoreCase("false")) return false;
            if (string.equalsIgnoreCase("true")) return true;
        }

        throw new IllegalArgumentException("Description[" + key + "] is not a boolean.");
    }

    @Override
    public double getDouble(String key) {
        Object object = get(key);

        try {
            if (object instanceof Number) return ((Number)object).doubleValue();
            if (object instanceof String) return Double.parseDouble((String)object);
        } catch (Exception e) {}
        throw new IllegalArgumentException("Description[" + key + "] is not a double.");
    }

    @Override
    public int getInt(String key)  {
        Object object = get(key);

        try {
            if (object instanceof Number) return ((Number)object).intValue();
            if (object instanceof String) return Integer.parseInt((String)object);
        } catch (Exception e) {}
        throw new IllegalArgumentException("Description[" + key + "] is not a int.");
    }

    @Override
    public long getLong(String key) {
        Object object = get(key);

        try {
            if (object instanceof Number) return ((Number)object).longValue();
            if (object instanceof String) return Long.parseLong((String)object);
        } catch (Exception e) {}
        throw new IllegalArgumentException("Description[" + key + "] is not a long.");
    }

    @Override
    public String getString(String key) {
        Object object = get(key);
        if (object instanceof String) return (String)object;
        if (object == null) return null;

        throw new IllegalArgumentException("Description[" + key + "] is not a string.");
    }

    @Override
    public boolean has(String key) {
        return properties.containsKey(key);
    }

    @Override
    public int propertyCount() {
        return properties.size();
    }
}
