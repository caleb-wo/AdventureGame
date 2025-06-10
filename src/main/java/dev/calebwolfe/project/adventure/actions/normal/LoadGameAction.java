package dev.calebwolfe.project.adventure.actions.normal;

import dev.calebwolfe.project.adventure.GameLoader;
import dev.calebwolfe.project.adventure.Player;
import dev.calebwolfe.project.adventure.actions.AbstractAction;

import java.util.Optional;

public class LoadGameAction extends AbstractAction {
    public LoadGameAction(String key){
        super(key);
    }
    public static final String DESCRIPTION = "(L)oad the game.";
    public boolean canDoAction(Player p){return true;}
    public String getActionDescription(){return DESCRIPTION;}
    public void doAction(Player p){
        Optional<Player> loadedP = GameLoader.loadPlayer();
        loadedP.ifPresent(p::loadFrom);
    }
}
