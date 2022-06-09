package com.gbsdevelopers.gbdziennik;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Vector;

import javafx.stage.StageStyle;
import org.json.*;

import com.gbsdevelopers.gbssocket.*;

public class Program extends Application {
    public static GbsClient socket;

    private static JSONObject config;

    public static String loggedUser;

    public static String loggedID;

    private JSONObject loadConfig()
    {
        InputStream inputStream = Program.class.getResourceAsStream("config.json");

        StringBuilder stringBuilder = new StringBuilder();

        try(Reader reader = new BufferedReader((new InputStreamReader(inputStream, Charset.forName(StandardCharsets.UTF_8.name())))))
        {
            int c = 0;
            while((c = reader.read()) != -1)
            {
                stringBuilder.append((char) c);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return new JSONObject(stringBuilder.toString());
    }

    private void initialize() {
        config = loadConfig();

        socket = new GbsClient(config.getJSONObject("GbsClientConfig").getInt("serverPort"), config.getJSONObject("GbsClientConfig").getString("serverHostname"));

        Vector<String> dbArgs = new Vector<String>();

        dbArgs.add(config.getJSONObject("MySqlConfig").getString("host"));
        dbArgs.add(config.getJSONObject("MySqlConfig").getString("port"));
        dbArgs.add(config.getJSONObject("MySqlConfig").getString("database"));
        dbArgs.add(config.getJSONObject("MySqlConfig").getString("user"));
        dbArgs.add(config.getJSONObject("MySqlConfig").getString("password"));

        GbsMessage reply = null;

        try{
            reply = socket.executeRequest(new GbsMessage("_configureDB", dbArgs));
        }
        catch (IOException ex)
        {
            AlertBox.show("Nie można połączyć się z serwerem :(","GbDziennik - ERROR");
            System.exit(1);
        }
    }

    @Override
    public void start(Stage stage) throws IOException {

        initialize();

        FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource("fxml/loginScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("GBDziennik - Zaloguj się!");
        stage.setScene(scene);
        stage.getIcons().add(new Image(Program.class.getResourceAsStream("img/icon.png")));
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}