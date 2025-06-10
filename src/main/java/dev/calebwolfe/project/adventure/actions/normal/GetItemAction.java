package dev.calebwolfe.project.adventure.actions.normal;

import dev.calebwolfe.project.adventure.Player;
import dev.calebwolfe.project.adventure.actions.AbstractAction;

public class GetItemAction extends AbstractAction {
    public static final String DESCRIPTION = "(G)et the item.";
    public GetItemAction(String key){
       super(key);
    }
    @Override
    public boolean canDoAction(Player player) {
        return player.getLocation().hasItem();
    }

    @Override
    public void doAction(Player player) {
        player.getItem();
    }

    @Override
    public String getActionDescription() {
        return DESCRIPTION;
    }
}
