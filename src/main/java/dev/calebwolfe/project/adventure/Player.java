package dev.calebwolfe.project.adventure;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringJoiner;


public class Player implements Serializable {
    private GameTile location;
    private GameMap USERMAP;
    private ArrayList<Item> inventory = new ArrayList<>();
    private int hitPoints = 5;
    private boolean fleeing;

    public Player(GameMap map) {
        this.USERMAP = map;
        this.setLocation(USERMAP.getGameTiles()[4]);
    }

    public Item getWinningItem() {
        return USERMAP.getWinningItem();
    }
    public void setHitPoints(int set){
        this.hitPoints = set;
    }
    public void setFleeing(boolean flee){
        this.fleeing = flee;
    }

    public int getHitPoints(){
        return this.hitPoints;
    }
    public boolean isFleeing(){
        return this.fleeing;
    }

    public boolean isAlive(){
        return this.hitPoints > 0;
    }

    public void travel(String direction) {
        boolean isDone = false;
        do {
            if (direction.equals("N")) {
                if (getLocation().getNorth() != null) {
                    this.setLocation(getLocation().getNorth());
                    this.getLocation().setVisited(true);
                    isDone = true;
                } else {
                    System.out.println("You cannot travel in that location!");
                    break;
                }
            } else if (direction.equals("E")) {
                if (getLocation().getEast() != null) {
                    this.setLocation(getLocation().getEast());
                    this.getLocation().setVisited(true);
                    isDone = true;
                } else {
                    System.out.println("You cannot travel in that location!");
                    break;
                }
            } else if (direction.equals("S")) {
                if (getLocation().getSouth() != null) {
                    this.setLocation(getLocation().getSouth());
                    this.getLocation().setVisited(true);
                    isDone = true;
                } else {
                    System.out.println("You cannot travel in that location!");
                    break;
                }
            } else if (direction.equals("W")) {
                if (getLocation().getWest() != null) {
                    this.setLocation(getLocation().getWest());
                    this.getLocation().setVisited(true);
                    isDone = true;
                } else {
                    System.out.println("You cannot travel in that location!");
                    break;
                }
            }
        } while (!isDone);
    }

    public GameTile getLocation() {
        return location;
    }

    public void setLocation(GameTile location) {
        this.location = location;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            StringJoiner joiner = new StringJoiner(", ");
            int count = 1;
            for (Item item : getInventory()) {
                joiner.add(count+++". "+item.getName());
            }
            System.out.println("Your Inventory: " + joiner);
        }
    }

    public void reduceHitPoints(int points){
        this.hitPoints = this.hitPoints - points;
    }

    public void getItem() {
        if (this.location.canGetItem(this)) {
            this.inventory.add(this.location.getItem());
            System.out.println(this.location.getItem().getName()+" was added to inventory.");
            this.location.removeItem();
        } else if (this.location.getObstacle().isPresent()) {
            System.out.println("You cannot get that item yet.");
        } else {
            System.out.println("There is nothing to get here.");
        }
    }

    public boolean hasItem(Item item){
        return getInventory().stream().anyMatch(playerItem -> playerItem.equals(item));
    }

    public void showMap() {
        this.USERMAP.showMap(this.location);
    }
    public void loadFrom(Player p){
        this.location = p.getLocation();
        this.inventory = p.getInventory();
        this.hitPoints = p.getHitPoints();
        this.fleeing = p.isFleeing();
        this.USERMAP = p.USERMAP;
    }
}

