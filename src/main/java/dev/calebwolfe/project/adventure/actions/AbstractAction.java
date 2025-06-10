package dev.calebwolfe.project.adventure.actions;

import java.io.Serializable;
import java.util.Objects;

public abstract class AbstractAction implements Action, Serializable {
    String actionKey;
    public AbstractAction(String key) {
        actionKey = key;
    }
    @Override
    public boolean validKey(String test) {
        return Objects.equals(test ,this.actionKey);
    }
}
