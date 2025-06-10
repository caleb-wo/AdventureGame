package dev.calebwolfe.project.adventure.actions.fight;

import dev.calebwolfe.project.adventure.Item;
import dev.calebwolfe.project.adventure.Player;
import dev.calebwolfe.project.adventure.actions.AbstractAction;
import dev.calebwolfe.project.adventure.enemies.Attack;
import dev.calebwolfe.project.adventure.enemies.Enemy;


public abstract class FightAction extends AbstractAction {
    private String actionKey;

    public FightAction(String key) {
        super(key);
    }

    public void attack(Player p, Enemy en, Attack atk) {
        en.attack(p, atk);
        if (en.isAlive()) {
            en.counterAttack(p);
        }

    }
    public boolean canDoAction(Player p){
        return p.getInventory().stream().anyMatch(item -> item.equals(Item.SWORD_OF_JUSTICE));
    }
}
