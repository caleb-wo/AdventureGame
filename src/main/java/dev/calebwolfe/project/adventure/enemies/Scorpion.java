package dev.calebwolfe.project.adventure.enemies;

import dev.calebwolfe.project.adventure.Item;

import java.io.Serializable;

public class Scorpion extends Enemy implements Serializable {

    private static final int MIN_HIT_POINTS = 3;
    private static final int MAX_HIT_POINTS = 4;

    public Scorpion(String name, String description, Item item) {
        super(name, description, item, MIN_HIT_POINTS, MAX_HIT_POINTS);
    }

    void initProbabilityMap() {
        // TODO: update the hitProbability map with the values below:
        // Set Attack.SLASH to 50
        // Set Attack.THRUST to 30
        // Set Attack.SMASH is 70
        hitProbability.put(Attack.SLASH, 50);
        hitProbability.put(Attack.THRUST, 30);
        hitProbability.put(Attack.SMASH, 70);
    }


}
