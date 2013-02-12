package org.atgas.core.impl;

import org.atgas.core.Description;

import java.util.*;

public class DescriptionImpl implements Description {

    private final MutableDescription description;

    public DescriptionImpl(String standardID, String sourceID, Map<String, String> properties) {
        description = new MutableDescription(standardID, sourceID);
        description.setProperties(properties);
    }

    @Override
    public String getStandardID() {
        return description.getStandardID();
    }

    @Override
    public String getSourceID() {
        return description.getSourceID();
    }

    @Override
    public Set<String> getProperties() {
        return description.getProperties();
    }

    @Override
    public Object get(String key) {
        return description.get(key);
    }

    @Override
    public boolean getBoolean(String key) {
        return description.getBoolean(key);
    }

    @Override
    public double getDouble(String key) {
        return description.getDouble(key);
    }

    @Override
    public int getInt(String key) {
        return description.getInt(key);
    }

    @Override
    public long getLong(String key) {
        return description.getLong(key);
    }

    @Override
    public String getString(String key) {
        return description.getString(key);
    }

    @Override
    public boolean has(String key) {
        return description.has(key);
    }

    @Override
    public int propertyCount() {
        return description.propertyCount();
    }
}
