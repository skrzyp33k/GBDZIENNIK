package com.gbsdevelopers.gbdziennik;

import com.gbsdevelopers.gbssocket.GbsClient;
import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.json.JSONObject;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Vector;

/**
 * Program main class.
 */
public class Program extends Application {
    /**
     * Socket connected to server.
     */
    public static GbsClient socket;

    /**
     * Logged user Login.
     */
    public static String loggedUser;

    /**
     * Logged user ID.
     */
    public static String loggedID;

    /**
     * Logged user Permissions
     */
    public static String loggedPerms;

    /**
     * Main function.
     *
     * @param args Program args.
     */
    public static void main(String[] args) {
        launch();
    }

    /**
     * Function which is loading config from JSON file.
     *
     * @return JSONObject with config.
     */
    private JSONObject loadConfig() {
        InputStream inputStream = Program.class.getResourceAsStream("config.json");

        StringBuilder stringBuilder = new StringBuilder();

        try {
            assert inputStream != null;
            try (Reader reader = new BufferedReader((new InputStreamReader(inputStream, Charset.forName(StandardCharsets.UTF_8.name()))))) {
                int c;
                while ((c = reader.read()) != -1) {
                    stringBuilder.append((char) c);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return new JSONObject(stringBuilder.toString());
    }

    /**
     * Initialize variable and test connection with server.
     */
    private void initialize() {
        JSONObject config = loadConfig();

        socket = new GbsClient(config.getJSONObject("GbsClientConfig").getInt("serverPort"), config.getJSONObject("GbsClientConfig").getString("serverHostname"));

        Vector<String> dbArgs = new Vector<>();

        dbArgs.add(config.getJSONObject("MySqlConfig").getString("host"));
        dbArgs.add(config.getJSONObject("MySqlConfig").getString("port"));
        dbArgs.add(config.getJSONObject("MySqlConfig").getString("database"));
        dbArgs.add(config.getJSONObject("MySqlConfig").getString("user"));
        dbArgs.add(config.getJSONObject("MySqlConfig").getString("password"));

        try {
            socket.executeRequest(new GbsMessage("_configureDB", dbArgs));
        } catch (IOException ex) {
            AlertBox.show("Nie można połączyć się z serwerem :(", "GbDziennik - ERROR");
            System.exit(1);
        }
    }

    /**
     * FXML start function.
     *
     * @param stage FXML Stage.
     * @throws IOException Throws when can not find or load resources.
     */
    @Override
    public void start(Stage stage) throws IOException {

        initialize();

        FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource("fxml/loginScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("GBDziennik - Zaloguj się!");
        stage.setScene(scene);
        stage.getIcons().add(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/icon.png"))));
        stage.setResizable(false);
        stage.show();
    }
}