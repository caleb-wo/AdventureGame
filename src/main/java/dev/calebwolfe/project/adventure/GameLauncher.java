package dev.calebwolfe.project.adventure;

public class GameLauncher {
    public static void main(String[] args) {
        Game instance = Game.getInstance();
        instance.start();
    }
}
