package dev.calebwolfe.project.adventure;

import java.io.Serializable;
import java.util.Optional;

public class Obstacle implements Serializable {
    private final String name;
    private final Item required;
    private final String description;
    public Obstacle(String name ,String desc ,Item req) {
        this.name = name;
        this.required = req;
        this.description = desc;
    }
    public String getName(){
        return this.name;
    }
    public Optional<Item> getRequired(){
        return Optional.ofNullable(this.required);
    }

    public String getDescription(){
        return this.description;
    }

    @Override
    public String toString() {
        return name;
    }
}
