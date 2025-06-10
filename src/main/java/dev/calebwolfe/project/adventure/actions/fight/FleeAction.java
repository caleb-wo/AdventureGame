package dev.calebwolfe.project.adventure.actions.fight;

import dev.calebwolfe.project.adventure.Player;
import dev.calebwolfe.project.adventure.enemies.Attack;
import dev.calebwolfe.project.adventure.enemies.Enemy;

public class FleeAction extends FightAction{
    private final String DESCRIPTION = "(F)lee in terror";
    @Override
    public void attack(Player p, Enemy e, Attack a){}
    public FleeAction(String key) {
        super(key);
    }
    @Override
    public boolean canDoAction(Player p) {
        return true;
    }
    @Override
    public void doAction(Player p){
       System.out.println("You flee as fast as you can. This obstacle was too much to bear. For now.");
       if ( p.getLocation().getObstacle().isPresent() && p.getLocation().getObstacle().get() instanceof Enemy) {
           Enemy e = (Enemy) p.getLocation().getObstacle().get();
           e.counterAttack(p);
       }
       p.setFleeing(true);
    }
    @Override
    public String getActionDescription(){
        return this.DESCRIPTION;
    }
}
