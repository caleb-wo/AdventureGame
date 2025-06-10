package dev.calebwolfe.project.adventure.enemies;

import dev.calebwolfe.project.adventure.Item;

import java.io.Serializable;

public class Kobold extends Enemy implements Serializable {

    private static final int MIN_HIT_POINTS = 1;
    private static final int MAX_HIT_POINTS = 2;

    public Kobold(String name, String description, Item required) {
        super(name, description, required, MIN_HIT_POINTS, MAX_HIT_POINTS);
    }

    void initProbabilityMap() {
        // TODO: update the hitProbability map with the values below:
        // Set Attack.SLASH to 70
        // Set Attack.THRUST to 50
        // Set Attack.SMASH is 30
        hitProbability.put(Attack.SLASH , 70);
        hitProbability.put(Attack.THRUST, 50);
        hitProbability.put(Attack.SMASH , 30);
    }

}
