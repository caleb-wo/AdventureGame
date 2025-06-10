package dev.calebwolfe.project.adventure;

import java.io.Serializable;
import java.util.Optional;

public class GameTile implements Serializable {
    private final Terrain terrain;
    private GameTile north;
    private GameTile east;
    private GameTile south;
    private GameTile west;
    private Item item;
    private boolean isVisited;
    private Obstacle obstacle;
//  CONSTUCTORS
    public GameTile(Terrain terrain ,Item item ,Obstacle obstacle){
        this.terrain = terrain;
        this.item = item;
        this.obstacle = obstacle;
    }
    public Optional<Obstacle> getObstacle() {
        return Optional.ofNullable(this.obstacle);
    }
    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }
    public boolean getVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        this.isVisited = visited;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public GameTile getNorth() {
        return north;
    }

    public void setNorth(GameTile north) {
        this.north = north;
    }

    public GameTile getEast() {
        return east;
    }

    public void setEast(GameTile east) {
        this.east = east;
    }

    public GameTile getSouth() {
        return south;
    }

    public void setSouth(GameTile south) {
        this.south = south;
    }

    public GameTile getWest() {
        return west;
    }

    public void setWest(GameTile west) {
        this.west = west;
    }

    public Item getItem() {
        return this.item;
    }

    public void setItem(Item i) {
        this.item = i;
    }

    public void removeItem() {
        this.item = null;
    }

    public boolean hasItem() {
        return this.item != null;
    }

    public void showTile() {
        if (getVisited()) {
            System.out.print(this.terrain.name());
        } else {
            System.out.print("********");
        }
    }
    public boolean canGetItem(Player player){
        GameTile location = player.getLocation();
        return location.hasItem() && !location.getObstacle().isPresent();
    }
}
