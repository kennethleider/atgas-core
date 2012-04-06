package org.atgas.store;

public class RelationshipType {
    
    public static final RelationshipType Source = new RelationshipType("Source");
    public static final RelationshipType Standard = new RelationshipType("Standard");

    private final String name;

    public RelationshipType(String name) {
        assert(name != null);
        this.name = name;
    }

    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RelationshipType)) {
            return false;
        }
        return name.equals(((RelationshipType)other).name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name();
    }
    
    
    
    
}
