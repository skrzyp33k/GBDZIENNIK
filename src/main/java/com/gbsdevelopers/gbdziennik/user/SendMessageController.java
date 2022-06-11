package com.gbsdevelopers.gbdziennik.user;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

public class SendMessageController {

    @FXML
    private ImageView backgroundImage;

    @FXML
    private TextArea messageTextArea;

    @FXML
    private ChoiceBox<?> receiverChoiceBox;

    @FXML
    private Button sendButton;

    @FXML
    void sendButtonClicked(ActionEvent event) {

    }

}
