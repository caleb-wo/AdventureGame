package dev.calebwolfe.project.adventure.actions.fight;

import dev.calebwolfe.project.adventure.Obstacle;
import dev.calebwolfe.project.adventure.Player;
import dev.calebwolfe.project.adventure.enemies.Attack;
import dev.calebwolfe.project.adventure.enemies.Enemy;

import java.util.Optional;

public class SmashAction extends FightAction{
    private final String DESCRIPTION = "S(M)ash with a sword";
    public SmashAction(String key) {
        super(key);
    }
    @Override
    public void doAction(Player p){
        Optional<Obstacle> current = p.getLocation().getObstacle();
        if (current.isPresent() && current.get() instanceof Enemy){
            Enemy e = (Enemy) current.get();
            attack(p , e , Attack.SMASH);
        } else if (current.isPresent()){
            System.out.println("This is not an enemy. Return with "+current.get().getRequired()+".");
        } else {
            System.out.println("Null object.");
        }

    }
    @Override
    public String getActionDescription(){
        return this.DESCRIPTION;
    }
}
