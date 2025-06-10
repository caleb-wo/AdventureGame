package dev.calebwolfe.project.adventure.actions;
import dev.calebwolfe.project.adventure.Player;

public interface Action {
    boolean canDoAction(Player player);
    void doAction(Player player);
    String getActionDescription();
    boolean validKey(String key);

}

