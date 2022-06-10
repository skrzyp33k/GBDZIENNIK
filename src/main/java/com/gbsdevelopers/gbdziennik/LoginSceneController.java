package com.gbsdevelopers.gbdziennik;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Vector;

/**
 * Controller for LoginScene
 */
public class LoginSceneController implements Initializable {

    /**
     * Password field.
     */
    @FXML
    private PasswordField passwordPasswordField;

    /**
     * Background image.
     */
    @FXML
    private ImageView backgroundImage;

    /**
     * Login info.
     */
    @FXML
    private Label loginInfo;

    /**
     * Login button.
     */
    @FXML
    private Button loginButton;

    /**
     * Login field.
     */
    @FXML
    private TextField loginTextField;

    /**
     * This function calculates MD5 hash.
     *
     * @param md5 String to hash.
     * @return MD5 checksum.
     */
    private String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : array) {
                sb.append(Integer.toHexString((b & 0xFF) | 0x100), 1, 3);
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException ignored) {
        }
        return null;
    }

    /**
     * LoginButton action handler.
     *
     * @param event Event that invoked action.
     * @throws IOException Throws when can not find or load resources.
     */
    @FXML
    private void loginButtonAction(ActionEvent event) throws IOException {
        loginInfo.setText("");
        Program.loggedUser = "";
        Program.loggedID = "";

        Vector<String> args = new Vector<>();

        args.add(loginTextField.getText());
        args.add(MD5(passwordPasswordField.getText()));

        GbsMessage message = new GbsMessage("_loginUser", args);

        GbsMessage reply = Program.socket.executeRequest(message);

        if (reply.header.equals("0")) {
            Program.loggedUser = reply.arguments.get(0);
            Program.loggedID = reply.arguments.get(2);

            Stage newStage = new Stage();

            if(reply.arguments.get(1).equals("a"))
            {
                FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource("fxml/admin/adminMainScene.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
                newStage.setTitle("GBDziennik - Panel administratora. Zalogowany jako: " + reply.arguments.get(0));
                newStage.setScene(scene);
            }
            else {
                FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource("fxml/user/userMainScene.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
                switch (reply.arguments.get(1)) {
                    case "u" -> {
                        //uczen
                        newStage.setTitle("GBDziennik - Panel ucznia. Zalogowany jako: " + reply.arguments.get(0));
                    }
                    case "r" -> {
                        //rodzic
                        newStage.setTitle("GBDziennik - Panel rodzica. Zalogowany jako: " + reply.arguments.get(0));
                    }
                    case "n" -> {
                        //nauczyciel
                        newStage.setTitle("GBDziennik - Panel nauczyciela. Zalogowany jako: " + reply.arguments.get(0));
                    }
                }
                newStage.setScene(scene);
            }

            newStage.getIcons().add(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/icon.png"))));
            newStage.setResizable(false);
            newStage.show();

            loginTextField.clear();
            passwordPasswordField.clear();

            ((Stage) (((Node) event.getSource()).getScene().getWindow())).close();
        } else {
            loginInfo.setText("Nieprawidłowe dane logowania!");
        }
    }

    /**
     * Initialize window.
     *
     * @param location  URL location.
     * @param resources Resource bundle.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loginTextField.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                loginButton.fire();
            }
        });

        passwordPasswordField.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                loginButton.fire();
            }
        });

        backgroundImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/background.png"))));
    }
}
