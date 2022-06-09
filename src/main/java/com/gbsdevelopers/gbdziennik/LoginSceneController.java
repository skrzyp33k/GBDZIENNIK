package com.gbsdevelopers.gbdziennik;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class LoginSceneController implements Initializable {
    private Stage thisStage;

    @FXML
    private PasswordField passwordPasswordField;

    @FXML
    private ImageView backgroundImage;

    @FXML
    private Label loginInfo;

    @FXML
    private Button loginButton;

    @FXML
    private TextField loginTextField;

    private String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }

    @FXML
    private void loginButtonAction(ActionEvent event) throws IOException {
        loginInfo.setText("");
        Program.loggedUser = "";
        Program.loggedID = "";

        Vector<String> args = new Vector<String>();

        args.add(loginTextField.getText());
        args.add(MD5(passwordPasswordField.getText()));

        GbsMessage message = new GbsMessage("_loginUser", args);

        GbsMessage reply = Program.socket.executeRequest(message);

        if (reply.header.equals("0")) {
            Program.loggedUser = reply.arguments.get(0);
            Program.loggedID = reply.arguments.get(2);
            Stage newStage = new Stage();
            if (reply.arguments.get(1).equals("a")) {
                //admin
                FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource("fxml/adminMainScene.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
                newStage.setTitle("GBDziennik - Panel administratora. Zalogowany jako: " + reply.arguments.get(0));
                newStage.setScene(scene);
            } else if (reply.arguments.get(1).equals("u")) {
                //uczen
                FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource("fxml/studentMainScene.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
                newStage.setTitle("GBDziennik - Panel ucznia. Zalogowany jako: " + reply.arguments.get(0));
                newStage.setScene(scene);
            } else if (reply.arguments.get(1).equals("r")) {
                //rodzic
                FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource("fxml/parentMainScene.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
                newStage.setTitle("GBDziennik - Panel rodzica. Zalogowany jako: " + reply.arguments.get(0));
                newStage.setScene(scene);
            } else if (reply.arguments.get(1).equals("n")) {
                //nauczyciel
                FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource("fxml/teacherMainScene.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
                newStage.setTitle("GBDziennik - Panel nauczyciela. Zalogowany jako: " + reply.arguments.get(0));
                newStage.setScene(scene);
            }
            newStage.getIcons().add(new Image(Program.class.getResourceAsStream("img/icon.png")));
            newStage.setResizable(false);
            newStage.show();

            loginTextField.clear();
            passwordPasswordField.clear();

            ((Stage)(((Node) event.getSource()).getScene().getWindow())).close();
        } else {
            loginInfo.setText("Nieprawidłowe dane logowania!");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loginTextField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                    loginButton.fire();
                }
            }
        });

        passwordPasswordField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                    loginButton.fire();
                }
            }
        });

        backgroundImage.setImage(new Image(Program.class.getResourceAsStream("img/background.png")));
    }
}
