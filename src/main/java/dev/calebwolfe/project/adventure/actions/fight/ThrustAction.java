package dev.calebwolfe.project.adventure.actions.fight;

import dev.calebwolfe.project.adventure.Obstacle;
import dev.calebwolfe.project.adventure.Player;
import dev.calebwolfe.project.adventure.enemies.Attack;
import dev.calebwolfe.project.adventure.enemies.Enemy;

import java.util.Optional;

public class ThrustAction extends FightAction{
    private final String DESCRIPTION = "(T)hrust with a sword";
    public ThrustAction(String key) {
        super(key);
    }
    @Override
    public void doAction(Player p){
        Optional<Obstacle> current = p.getLocation().getObstacle();
        if (current.isPresent() && current.get() instanceof Enemy){
            Enemy e = (Enemy) current.get();
            attack(p , e , Attack.THRUST);
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
