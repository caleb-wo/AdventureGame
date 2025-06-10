package dev.calebwolfe.project.adventure.actions.normal;

import dev.calebwolfe.project.adventure.GameLoader;
import dev.calebwolfe.project.adventure.Player;
import dev.calebwolfe.project.adventure.actions.AbstractAction;

public class SaveGameAction extends AbstractAction {
    public SaveGameAction(String key){
        super(key);
    }
    public static final String DESCRIPTION = "Sa(V)e the game.";
    public boolean canDoAction(Player p){return true;}
    public String getActionDescription(){return DESCRIPTION;}
    public void doAction(Player p){
        GameLoader.savePlayer(p);
    }
}
