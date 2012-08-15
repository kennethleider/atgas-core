package org.atgas.store;

import java.io.Serializable;
import java.util.Map.Entry;
import java.util.*;

public final class Thing implements Serializable {
    private static final long serialVersionUID = -4827299592734550960L;
    
    private String id;
    private final String standardID;
    private final String sourceID;
    
    private final Map<String, Object> properties = new HashMap<>();
    private final Collection<Relationship> relationships = new LinkedHashSet<>();
    
    public Thing(String standardID, String sourceID) {
        this.id = ThingBuilder.newID();
        this.standardID = standardID;
        this.sourceID = sourceID;                
    }
    
    public Thing(String id, String standardID, String sourceID) {
        this.id = id;
        this.standardID = standardID;
        this.sourceID = sourceID;           
    }
    
    public String getID() {
        return id;
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
    
        /**
     * Get an enumeration of the keys of the JSONObject.
     *
     * @return An iterator of the keys.
     */
    public Iterator keys() {
        return this.properties.keySet().iterator();
    }

    
    public Set<String> getProperties() {
        return new LinkedHashSet<String>(properties.keySet());
    }
    
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Thing)) {
            return false;
        }
        return id.equals(((Thing)other).id);
    }
    
    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public void addRelationship(Relationship relationship) {
        relationships.add(relationship);
    }
    
    public Iterable<Relationship> getRelationships() {
        return Collections.unmodifiableCollection(relationships);
    }
    
    public Iterable<Relationship> getRelationships(String standardID) {
        Collection<Relationship> retval = new ArrayList<>();
        for(Relationship relationship: relationships) {
            if (relationship.getTargetStandardID().equals(standardID)) {
                retval.add(relationship);
            }
        }
        
        return retval;
    }
    
    public Iterable<Relationship> getRelationships(RelationshipType type) {
        Collection<Relationship> retval = new ArrayList<>();
        for(Relationship relationship: relationships) {
            if (relationship.getType().equals(type)) {
                retval.add(relationship);
            }
        }
        
        return retval;
    }

    
    /**
     * Get the value object associated with a key.
     *
     * @param key   A key string.
     * @return      The object associated with the key.
     * @throws      JSONException if the key is not found.
     */
    public Object get(String key) {
        if (key == null) {
            return null;
        }
        
        return properties.get(key);
    }
    
    /**
     * Get the boolean value associated with a key.
     *
     * @param key   A key string.
     * @return      The truth.
     * @throws      JSONException
     *  if the value is not a Boolean or the String "true" or "false".
     */
    public boolean getBoolean(String key) {
        Object object = this.get(key);
        if (object.equals(Boolean.FALSE) ||
                (object instanceof String &&
                ((String)object).equalsIgnoreCase("false"))) {
            return false;
        } else if (object.equals(Boolean.TRUE) ||
                (object instanceof String &&
                ((String)object).equalsIgnoreCase("true"))) {
            return true;
        }
        throw new IllegalArgumentException("JSONObject[" + key +
                "] is not a Boolean.");
    }


    /**
     * Get the double value associated with a key.
     * @param key   A key string.
     * @return      The numeric value.
     * @throws JSONException if the key is not found or
     *  if the value is not a Number object and cannot be converted to a number.
     */
    public double getDouble(String key) {
        Object object = this.get(key);
        try {
            return object instanceof Number
                ? ((Number)object).doubleValue()
                : Double.parseDouble((String)object);
        } catch (Exception e) {
            throw new IllegalArgumentException("JSONObject[" + key +
                "] is not a number.");
        }
    }


    /**
     * Get the int value associated with a key.
     *
     * @param key   A key string.
     * @return      The integer value.
     * @throws   JSONException if the key is not found or if the value cannot
     *  be converted to an integer.
     */
    public int getInt(String key)  {
        Object object = this.get(key);
        try {
            return object instanceof Number
                ? ((Number)object).intValue()
                : Integer.parseInt((String)object);
        } catch (Exception e) {
            throw new IllegalArgumentException("JSONObject[" + key +
                "] is not an int.");
        }
    }

    /**
     * Get the long value associated with a key.
     *
     * @param key   A key string.
     * @return      The long value.
     * @throws   JSONException if the key is not found or if the value cannot
     *  be converted to a long.
     */
    public long getLong(String key) {
        Object object = this.get(key);
        try {
            return object instanceof Number
                ? ((Number)object).longValue()
                : Long.parseLong((String)object);
        } catch (Exception e) {
            throw new IllegalArgumentException("JSONObject[" + key +
                "] is not a long.");
        }
    }
    
        /**
     * Get the string associated with a key.
     *
     * @param key   A key string.
     * @return      A string which is the value.
     * @throws   JSONException if there is no string value for the key.
     */
    public String getString(String key) {
        Object object = this.get(key);
        if (object instanceof String) {
            return (String)object;
        }
        
        if (object == null) { 
            return "";
        }
        throw new IllegalArgumentException("JSONObject[" + key +
            "] not a string.");
    }

    /**
     * Determine if the JSONObject contains a specific key.
     * @param key   A key string.
     * @return      true if the key exists in the JSONObject.
     */
    public boolean has(String key) {
        return this.properties.containsKey(key);
    }

    /**
     * Determine if the value associated with the key is null or if there is
     *  no value.
     * @param key   A key string.
     * @return      true if there is no value associated with the key or if
     *  the value is the JSONObject.NULL object.
     */
    public boolean isNull(String key) {
        Object value = this.properties.get(key);
        return value == null || value.equals("");
    }
    
    /**
     * Get the number of keys stored in the JSONObject.
     *
     * @return The number of keys in the JSONObject.
     */
    public int length() {
        return this.properties.size();
    }
    
    /**
     * Try to convert a string into a number, boolean, or null. If the string
     * can't be converted, return the string.
     * @param string A String.
     * @return A simple JSON value.
     */
    public static Object stringToValue(String string) {
        Double d;
        if (string.equals("")) {
            return string;
        }
        if (string.equalsIgnoreCase("true")) {
            return Boolean.TRUE;
        }
        if (string.equalsIgnoreCase("false")) {
            return Boolean.FALSE;
        }
        if (string.equalsIgnoreCase("null")) {
            return "";                        
        }

        /*
         * If it might be a number, try converting it.
         * If a number cannot be produced, then the value will just
         * be a string. Note that the plus and implied string
         * conventions are non-standard. A JSON parser may accept
         * non-JSON forms as long as it accepts all correct JSON forms.
         */

        char b = string.charAt(0);
        if ((b >= '0' && b <= '9') || b == '.' || b == '-' || b == '+') {
            try {
                if (string.indexOf('.') > -1 ||
                        string.indexOf('e') > -1 || string.indexOf('E') > -1) {
                    d = Double.valueOf(string);
                    if (!d.isInfinite() && !d.isNaN()) {
                        return d;
                    }
                } else {
                    Long myLong = new Long(string);
                    if (myLong.longValue() == myLong.intValue()) {
                        return new Integer(myLong.intValue());
                    } else {
                        return myLong;
                    }
                }
            }  catch (Exception ignore) {
            }
        }
        return string;
    }

    public void removeRelationship(Relationship relationship) {
        relationships.remove(relationship);
    }
}
