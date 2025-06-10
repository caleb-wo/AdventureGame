package dev.calebwolfe.project.adventure;

import java.io.Serializable;

public enum Terrain implements Serializable {
     FOREST("The Mysterious Forest")
    ,RIVER("The Wide River")
    ,LAKE("The Sparkling Lake")
    ,MOUNTAINS("The Jagged Mountains")
    ,DESSERT("The Winding Desert");

    private final String description;
    Terrain(String desc){
        this.description = desc;
    }

    public String getDescription(){
        return this.description;
    }
}
