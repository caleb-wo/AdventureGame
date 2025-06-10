package dev.calebwolfe.project.adventure.actions.fight;

import dev.calebwolfe.project.adventure.Player;
import dev.calebwolfe.project.adventure.enemies.Attack;
import dev.calebwolfe.project.adventure.enemies.Enemy;

public class InvalidFightAction extends FightAction{
    public InvalidFightAction(String s){
        super("STMF");
    }
    @Override
    public void attack(Player p, Enemy e, Attack atk){}
    @Override
    public void doAction(Player p){
        System.out.println("Not an option currently");
    }
    @Override
    public String getActionDescription(){
        return "";
    }
    public boolean isValidKey(String key){
        return key.equals("S") || key.equals("T")
                || key.equals("M") || key.equals("F");
    }
}
