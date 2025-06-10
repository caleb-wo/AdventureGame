package dev.calebwolfe.project.adventure.actions.normal;

import dev.calebwolfe.project.adventure.GameLoader;
import dev.calebwolfe.project.adventure.Player;
import dev.calebwolfe.project.adventure.actions.AbstractAction;

public class QuitAction extends AbstractAction {
    public static final String DESCRIPTION = "(Q)uit the game";
    public QuitAction(String key){
        super(key);
    }
    @Override
    public boolean canDoAction(Player player) {
        return true;
    }

    @Override
    public void doAction(Player player) {
        System.out.println();
        GameLoader.showMessage( "quit.txt", "It's over. You quit." );
        System.exit(0);
    }

    @Override
    public String getActionDescription() {
        return DESCRIPTION;
    }
}