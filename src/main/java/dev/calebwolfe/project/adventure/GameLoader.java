package dev.calebwolfe.project.adventure;
import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.util.Optional;

public class GameLoader {
    public static Optional<Player> loadPlayer() {
        Optional<Player> playerOptional = Optional.empty();
        try(
                FileInputStream in = new FileInputStream("game.ser");
                ObjectInputStream objIn = new ObjectInputStream(in);
                ){
            Player player = ( Player ) objIn.readObject();
            playerOptional = Optional.ofNullable(player);
            System.out.println("The game was loaded successfully!");
            System.out.println();
        } catch ( IOException e ) {
            System.out.println("An error occurred while loading the game.");
            System.out.println("Load failed.");
            System.out.println();
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("An error occurred while loading the game.");
            System.out.println("Load failed.");
            System.out.println();
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return playerOptional;
    }
    public static void savePlayer( Player p ){
        try (
                FileOutputStream out = new FileOutputStream("game.ser");
                ObjectOutputStream outObj = new ObjectOutputStream(out);
                ){
            outObj.writeObject(p);
            System.out.println("Your game was save successfully!");
        } catch ( Exception e ){
            System.out.print("Error saving."+e.getMessage());
            e.printStackTrace();
        }
    }
    public static void showMessage(String filename, String defaultMessage){
        String baseURL = "https://qrbriggs-byui.github.io/apj-files/adventure/";
        String mainURL = ( baseURL + filename );
        try {
            URL url = new URL(mainURL);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            try (
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            ){
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
            connection.disconnect();
        } catch (Exception e) {
            System.out.println(defaultMessage);
        }
    }
}
