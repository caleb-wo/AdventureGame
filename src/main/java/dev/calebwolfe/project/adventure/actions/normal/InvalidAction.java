package dev.calebwolfe.project.adventure.actions.normal;

import dev.calebwolfe.project.adventure.Player;
import dev.calebwolfe.project.adventure.actions.AbstractAction;

import java.util.ArrayList;

public class InvalidAction extends AbstractAction {
    public static final String DESCRIPTION = "";
    public InvalidAction(String key){
        super(key);
    }
    @Override
    public boolean canDoAction(Player player) {
        return false;
    }

    @Override
    public void doAction(Player player) {
        System.out.println("That is not a valid option.");
    }

    @Override
    public String getActionDescription() {
        return DESCRIPTION;
    }

    @Override
    public boolean validKey(String test) {
        ArrayList<String> validOptions = new ArrayList<String>();
        validOptions.add("G"); validOptions.add("I");
        validOptions.add("M"); validOptions.add("N");
        validOptions.add("E"); validOptions.add("S");
        validOptions.add("W"); validOptions.add("Q");
        validOptions.add("L"); validOptions.add("V");
        return !validOptions.contains(test);
    }
}
