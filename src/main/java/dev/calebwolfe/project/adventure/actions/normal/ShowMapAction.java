package dev.calebwolfe.project.adventure.actions.normal;

import dev.calebwolfe.project.adventure.Player;
import dev.calebwolfe.project.adventure.actions.AbstractAction;

public class ShowMapAction extends AbstractAction {
    public static final String DESCRIPTION = "Show (M)ap";
    public ShowMapAction(String key){
        super(key);
    }
    @Override
    public boolean canDoAction(Player player) {
        return true;
    }

    @Override
    public void doAction(Player player) {
        player.showMap();
    }

    @Override
    public String getActionDescription() {
        return DESCRIPTION;
    }
}
