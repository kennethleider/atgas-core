package org.atgas.store;

public class RelationshipType {
    
    public static final RelationshipType Source = new RelationshipType("Source");
    public static final RelationshipType Standard = new RelationshipType("Standard");

    private final String name;

    RelationshipType(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }
}
