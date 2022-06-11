package com.gbsdevelopers.gbdziennik.user;


import com.gbsdevelopers.gbdziennik.Program;
import com.gbsdevelopers.gbdziennik.user.datatypes.GbUserAccountChoiceElement;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class SendMessageController implements Initializable {

    @FXML
    private ImageView backgroundImage;

    @FXML
    private TextArea messageTextArea;

    @FXML
    private ChoiceBox<GbUserAccountChoiceElement> receiverChoiceBox;

    @FXML
    private Button sendButton;

    @FXML
    void sendButtonClicked(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backgroundImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/background_sm.png"))));

        receiverChoiceBox.setItems(FXCollections.observableList(MainSceneController.choiceAccountsArrayList));

    }
}
