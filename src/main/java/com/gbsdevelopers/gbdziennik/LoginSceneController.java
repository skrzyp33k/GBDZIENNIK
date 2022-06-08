package com.gbsdevelopers.gbdziennik;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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


public class LoginSceneController implements Initializable {

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

        Vector<String> args = new Vector<String>();

        args.add(loginTextField.getText());
        args.add(MD5(passwordPasswordField.getText()));

        GbsMessage message = new GbsMessage("_loginUser", args);

        GbsMessage reply = Program.socket.executeRequest(message);

        if (reply.header.equals("0")) {
            //gbs
        } else {
            loginInfo.setText("Nieprawidłowe dane logowania!");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loginTextField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode().equals(KeyCode.ENTER))
                {
                    try {
                        loginButtonAction(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        passwordPasswordField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode().equals(KeyCode.ENTER))
                {
                    try {
                        loginButtonAction(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        backgroundImage.setImage(new Image(Program.class.getResourceAsStream("img/BACKGROUND.png")));
    }
}
