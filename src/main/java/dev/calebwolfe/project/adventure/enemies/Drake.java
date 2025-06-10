package dev.calebwolfe.project.adventure.enemies;


import dev.calebwolfe.project.adventure.Item;

import java.io.Serializable;

public class Drake extends Enemy implements Serializable {

    private static final int MIN_HIT_POINTS = 2;
    private static final int MAX_HIT_POINTS = 3;

    public Drake(String name, String description, Item item) {
        super(name, description, item, MIN_HIT_POINTS, MAX_HIT_POINTS);
    }

    void initProbabilityMap() {
        // TODO: update the hitProbability map with the values below:
        // Set Attack.SLASH to 30
        // Set Attack.THRUST to 70
        // Set Attack.SMASH is 50
        hitProbability.put(Attack.SLASH , 30);
        hitProbability.put(Attack.THRUST , 70);
        hitProbability.put(Attack.SMASH , 50);
    }

}
