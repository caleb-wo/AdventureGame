package dev.calebwolfe.project.adventure;

import dev.calebwolfe.project.adventure.enemies.Drake;
import dev.calebwolfe.project.adventure.enemies.Kobold;
import dev.calebwolfe.project.adventure.enemies.Scorpion;

import java.io.Serializable;

public class GameMap implements Serializable {
    private GameTile[] tiles;
    private Item winningItem;

    public GameMap(){
        init();
    }
    private void init() {
        setTiles(new GameTile[9]);
//        ITEMS
        Item i1 = new Item("Amulet of Power", "At last - the amulet you seek."); winningItem = i1;
                Item.AMULET_OF_POWER = i1;
        Item i2 = new Item("Hoard of Gold", "The man accepts your gold and offers you his fishing pole.");
        Item i3 = new Item("Fishing Pole", "You cast your line into the lake and pull out a pair of boots.");
        Item i4 = new Item("Old Raft", "You board the old raft and float across the river.");
        Item i5 = new Item("Sword of Justice", "You wield the sword of justice with a flair.");
                Item.SWORD_OF_JUSTICE = i5;
        Item i6 = new Item("Ermine Cloak", "This ermine cloak looks good on you.");
        Item i7 = new Item("Gold Key", "With trembling hands you insert the key into the chest. The lock clicks open!");
        Item i8 = new Item("Thick-Soled Boots", "These boots are thick and offer protection.");
        Item i9 = new Item("Scarf", "You wind the scarf around your nose and mouth and you can breath easy now.");
//        OBSTACLES
        Obstacle o1 = new Obstacle("Wooden Chest", "You see an old wooden chest which is securely locked." ,i7);
        Obstacle o2 = new Drake("Dreadful Drake", "The Mountain Drake opens his maw as a freezing fog gathers around."  ,i6);
        Obstacle o3 = new Obstacle("Freezing Man in Hut", "You see an old man sitting in his mountain hut. Looks like he needs money to make some repairs."  ,i2);
        Obstacle o4 = new Scorpion("Scary Scorpion", "The Scary Scorpion wields his stinger menacingly."  ,i8);
        Obstacle o5 = null;
        Obstacle o6 = new Kobold("Cringing Kobold", "The Cringing Kobold bares his sharp teeth in challenge."  ,i5);
        Obstacle o7 = new Obstacle("Dust Storm", "A blinding sandstorm arises - it is difficult to breathe without something to cover your mouth."  ,i9);
        Obstacle o8 = new Obstacle("Fishing Dock", "There is a dock here that would be perfect for fishing."  ,i3);
        Obstacle o9 = new Obstacle("Wide River", "There is a wide river here that is difficult to cross without a way across."  ,i4);
//        TILE ONE
        getGameTiles()[0] = new GameTile(Terrain.DESSERT ,i1 ,o1);
//        TILE TWO
        getGameTiles()[1] = new GameTile(Terrain.MOUNTAINS ,i2 ,o2);
//        TILE THREE
        getGameTiles()[2] = new GameTile(Terrain.MOUNTAINS ,i3 ,o3);
//        TILE FOUR
        getGameTiles()[3] = new GameTile(Terrain.DESSERT ,i4 ,o4);
//        TILE FIVE; Start
        getGameTiles()[4] = new GameTile(Terrain.FOREST ,i5 ,o5);
        getGameTiles()[4].setVisited(true);
//        TILE SIX
        getGameTiles()[5] = new GameTile(Terrain.FOREST ,i6 ,o6);
//        TILE SEVEN
        getGameTiles()[6] = new GameTile(Terrain.DESSERT ,i7 ,o7);
//        TILE EIGHT
        getGameTiles()[7] = new GameTile(Terrain.LAKE ,i8 ,o8);
//        TILE NINE
        getGameTiles()[8] = new GameTile(Terrain.RIVER ,i9 ,o9);
//        LOCATIONS
//        ONE
        getGameTiles()[0].setNorth(null);
        getGameTiles()[0].setEast(getGameTiles()[1]);
        getGameTiles()[0].setSouth(getGameTiles()[3]);
        getGameTiles()[0].setWest(null);
//        TWO
        getGameTiles()[1].setNorth(null);
        getGameTiles()[1].setEast(getGameTiles()[2]);
        getGameTiles()[1].setSouth(getGameTiles()[4]);
        getGameTiles()[1].setWest(getGameTiles()[0]);
//        THREE
        getGameTiles()[2].setNorth(null);
        getGameTiles()[2].setEast(null);
        getGameTiles()[2].setSouth(getGameTiles()[5]);
        getGameTiles()[2].setWest(getGameTiles()[1]);
//        FOUR
        getGameTiles()[3].setNorth(getGameTiles()[0]);
        getGameTiles()[3].setEast(getGameTiles()[4]);
        getGameTiles()[3].setSouth(getGameTiles()[6]);
        getGameTiles()[3].setWest(null);
//        FIVE
        getGameTiles()[4].setNorth(getGameTiles()[1]);
        getGameTiles()[4].setEast(getGameTiles()[5]);
        getGameTiles()[4].setSouth(getGameTiles()[7]);
        getGameTiles()[4].setWest(getGameTiles()[3]);
//        SIX
        getGameTiles()[5].setNorth(getGameTiles()[2]);
        getGameTiles()[5].setEast(null);
        getGameTiles()[5].setSouth(getGameTiles()[8]);
        getGameTiles()[5].setWest(getGameTiles()[4]);
//        SEVEN
        getGameTiles()[6].setNorth(getGameTiles()[3]);
        getGameTiles()[6].setEast(getGameTiles()[7]);
        getGameTiles()[6].setSouth(null);
        getGameTiles()[6].setWest(null);
//        EIGHT
        getGameTiles()[7].setNorth(getGameTiles()[4]);
        getGameTiles()[7].setEast(getGameTiles()[8]);
        getGameTiles()[7].setSouth(null);
        getGameTiles()[7].setWest(getGameTiles()[6]);
//        NINE
        getGameTiles()[8].setNorth(getGameTiles()[5]);
        getGameTiles()[8].setEast(null);
        getGameTiles()[8].setSouth(null);
        getGameTiles()[8].setWest(getGameTiles()[7]);
    }

    public GameTile[] getGameTiles() {
        return tiles;
    }

    public void setTiles(GameTile[] tiles) {
        this.tiles = tiles;
    }

    public void showMap(GameTile playerLocation) {
        int count = 0;
        for(GameTile tile :this.tiles) {
            if (count % 3 == 0) {
                System.out.println();
            }
            if (playerLocation.equals(tile)) {
                System.out.print(" |[");
                tile.showTile();
                System.out.print("]| ");
            } else {
                System.out.print(" | ");
                tile.showTile();
                System.out.print(" | ");
            }
            ++count;
        }
        System.out.println();
    }


    public Item getWinningItem() {
        return winningItem;
    }
    public void setWinningItemFromLoadedPlayer(Player p) {
        this.winningItem = p.getWinningItem();
    }
}
