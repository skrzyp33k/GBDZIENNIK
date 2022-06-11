package com.gbsdevelopers.gbdziennik.user;


import com.gbsdevelopers.gbdziennik.Program;
import com.gbsdevelopers.gbdziennik.user.datatypes.GbUserAccountChoiceElement;
import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Controller for sendMessageScene
 */
public class SendMessageController implements Initializable {

    /**
     * Background Image
     */
    @FXML
    private ImageView backgroundImage;

    /**
     * Message TextArea
     */
    @FXML
    private TextArea messageTextArea;

    /**
     * Message Message
     */
    @FXML
    private Label messageMessage;

    /**
     * Receiver ChoiceBox
     */
    @FXML
    private ChoiceBox<GbUserAccountChoiceElement> receiverChoiceBox;

    /**
     * Handler for sendButton
     * @param event ActionEvent
     */
    @FXML
    void sendButtonClicked(ActionEvent event) {
        String receiverID = receiverChoiceBox.getSelectionModel().getSelectedItem().getIdkonta();
        String messageText = messageTextArea.getText();

        messageMessage.setText("");

        if(!(receiverID.isEmpty()) && !(messageText.isEmpty()))
        {
            if(messageText.contains(";"))
            {
                messageMessage.setText("Niedozwolony znak (;)");
            }
            else
            {
                GbsMessage message = new GbsMessage();

                message.header = "_manualQuery";

                message.arguments.add("INSERT INTO wiadomosci VALUES(null,'"+messageText+"',"+Program.loggedID+","+receiverID+",CURRENT_TIMESTAMP());");

                try {
                    Program.socket.executeRequest(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                ((Stage) (((Node) event.getSource()).getScene().getWindow())).close();
            }
        }
    }

    /**
     * Initialize window.
     *
     * @param url            URL location.
     * @param resourceBundle Resource bundle.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backgroundImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/background_sm.png"))));

        receiverChoiceBox.setItems(FXCollections.observableList(MainSceneController.choiceAccountsArrayList));

    }
}
