package dev.calebwolfe.project.adventure.enemies;

import dev.calebwolfe.project.adventure.Item;
import dev.calebwolfe.project.adventure.Obstacle;
import dev.calebwolfe.project.adventure.Player;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class Enemy extends Obstacle implements Serializable {

    protected int hitPoints;
    protected Map<Attack, Integer> hitProbability = new HashMap<>();
    protected final Random random = new Random();
    protected int playerHitProbability = 20;

    public Enemy(String name, String description, Item required, int minHitPoints, int maxHitPoints) {
        super(name, description, required);
        hitPoints = random.nextInt(minHitPoints, maxHitPoints + 1);
        initProbabilityMap();
    }

    abstract void initProbabilityMap();

    public void attack(Player player, Attack attack) {
        // TODO: Implement attack logic here as explained below:
        // If the player does not have the required item for this
        // enemy print a message that they cannot attack because they lack the specified item.
        // Otherwise, roll for hit by picking a random number between 1 and 100.
        // Get the probability number from the map using the attack enum as the key
        // If the number rolled is less than the number print a message that the enemy was hit and subtract a hit point
        // Otherwise, print a message that the attack was unsuccessful.
         if (player.hasItem(player.getLocation().getObstacle().get().getRequired().get())){
             int hitChance = random.nextInt( 1, 101 );

             if (hitChance < hitProbability.get(attack)){
                System.out.println("You attacked the enemy. -1 hp");
                hitPoints--;
                return;
             } else {
                System.out.println("Your attack failed.");
            }
         } else {
             System.out.println("You are missing the key to defeating this beast. [HINT: "+player.getLocation().getObstacle().get().getRequired().get().getName()+".]");
         }

    }
//        if (player.getInventory().stream().anyMatch((Predicate<? super Item>) player.getLocation().getObstacle().get().getRequired().get())){
//            int hitChance = random.nextInt( 1, 101 );
//
//            if (hitChance < hitProbability.get(attack)){
//               System.out.println("You attacked the enemy. -1 hp");
//               hitPoints--;
//            } else {
//                System.out.println("Your attack failed.");
//            }
//        } else {
//            System.out.println("You are missing the key to defeating this beast. [HINT: "+player.getLocation().getObstacle().get().getRequired().get().getName()+".]");
//        }


    public void counterAttack(Player player) {
        int roll = random.nextInt(100);
        if (roll < playerHitProbability){
            System.out.println("The "+getName()+" attacks and scores a HIT on you.");
            player.reduceHitPoints(1);
        }
        else{
            System.out.println("The "+getName()+" attacks but luckily it was a MISS.");
        }
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }

    public int getHitPoints(){
        return hitPoints;
    }
}

