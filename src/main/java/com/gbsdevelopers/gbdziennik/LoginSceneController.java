package com.gbsdevelopers.gbdziennik;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LoginSceneController implements Initializable {
    @FXML
    private TextField loginTextField;

    @FXML
    private PasswordField passwordPasswordField;

    @FXML
    public ImageView sideImage;

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
    private void loginButtonAction() {

        Vector<String> args = new Vector<String>();

        args.add(loginTextField.getText());
        args.add(MD5(passwordPasswordField.getText()));

        GbsMessage message = new GbsMessage("_loginUser", args);

        GbsMessage reply = Program.socket.executeRequest(message);

        if (reply.header.equals("0")) {
            //gbs
        } else {
            //not gbs
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sideImage.setImage(new Image(Program.class.getResourceAsStream("img/logo_gbdziennik.png")));
    }
}
