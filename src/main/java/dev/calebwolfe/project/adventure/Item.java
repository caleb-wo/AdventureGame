package dev.calebwolfe.project.adventure;

import java.io.Serializable;

public class Item implements Serializable {
    private String name;
    private final String description;
    public static Item AMULET_OF_POWER;
    public static Item SWORD_OF_JUSTICE;
    public Item(String name, String desc) {
        this.name = name;
        this.description = desc;
    }
    // GETTER
    public String getDescription(){
        return this.description;
    }
    public String getName() {
        return this.name;
    }
    // TO STRING
    @Override
    public String toString() {
        return this.name;
    }
}
