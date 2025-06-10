package dev.calebwolfe.project.adventure.actions.normal;

import dev.calebwolfe.project.adventure.Item;
import dev.calebwolfe.project.adventure.Obstacle;
import dev.calebwolfe.project.adventure.Player;
import dev.calebwolfe.project.adventure.actions.AbstractAction;

import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;


public class UseItemAction extends AbstractAction {
    public static final String DESCRIPTION = "(U)se an item";

    public UseItemAction(String key) {
        super(key);
    }

    @Override
    public boolean canDoAction(Player player) {
       return !player.getInventory().isEmpty();
    }

    @Override
    public String getActionDescription() {
        return DESCRIPTION;
    }

    @Override
    public void doAction(Player player) {
        if(!player.getInventory().isEmpty()) {
            if(player.getLocation().getObstacle().isPresent()) {
                if (canDoAction(player)) {
                    player.showInventory();
                    Scanner sc = new java.util.Scanner(System.in);
                    String itemChoice = sc.nextLine();
                    Pattern pattern = Pattern.compile("\\d");
                    if (pattern.matcher(itemChoice).matches()) {
                        int numChoice = Integer.parseInt(itemChoice);
                        if (numChoice > 0 && numChoice <= player.getInventory().size()) {
                            Item key = player.getInventory().get(numChoice - 1);
                            Optional<Obstacle> obst = player.getLocation().getObstacle();
                            Optional<Item> req = obst.get().getRequired();
                            if ((obst.isPresent()) && (Objects.equals(key, req.get()))) {
                                StringBuilder sb = new StringBuilder();
                                sb
                                        .append("The ")
                                        .append(obst.get().toString())
                                        .append(" is defeated by the ")
                                        .append(key.toString())
                                        .append(".");
                                System.out.println(sb.toString());
                                player.getLocation().setObstacle(null);
                                return;
                            } else {
                                System.out.println("Using the " + key.toString() + " has no effect.");
                            }
                        }
                    } else {
                        System.out.println("That is not a valid option.");
                    }
                } else {
                    System.out.println("You have nothing to use here.");
                }
            } else {
                System.out.println("There is no obstacle in your path currently.");
            }
        } else {
                System.out.println("Your inventory is empty.");
        }
    }
}
