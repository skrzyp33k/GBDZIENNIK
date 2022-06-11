package com.gbsdevelopers.gbdziennik.user;

import com.gbsdevelopers.gbdziennik.Program;
import com.gbsdevelopers.gbdziennik.user.datatypes.GbUserStudentChoiceElement;
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
 * Controller for addRemarkScene
 */
public class AddRemarkController implements Initializable {

    /**
     * Background Image
     */
    @FXML
    private ImageView backgroundImage;

    /**
     * Content TextArea
     */
    @FXML
    private TextArea contentTextArea;

    /**
     * Content Message
     */
    @FXML
    private Label contentMessage;

    /**
     * Students ChoiceBox
     */
    @FXML
    private ChoiceBox<GbUserStudentChoiceElement> studentsChoiceBox;

    /**
     * Handler for addButton
     *
     * @param event ActionEvent
     */
    @FXML
    void addButtonClicked(ActionEvent event) {
        String studentID = studentsChoiceBox.getSelectionModel().getSelectedItem().getIducznia();
        String content = contentTextArea.getText();

        contentMessage.setText("");

        if (!(studentID.isEmpty()) && !(content.isEmpty())) {
            if (!content.contains(";")) {
                GbsMessage message = new GbsMessage();

                message.header = "_manualQuery";

                message.arguments.add("INSERT INTO uwagi VALUES(null,'" + content + "'," + MainSceneController.teacherID + "," + studentID + ",CURRENT_TIMESTAMP());");

                try {
                    Program.socket.executeRequest(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                ((Stage) (((Node) event.getSource()).getScene().getWindow())).close();
            } else {
                contentMessage.setText("Niedozwolony znak (;)");
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

        studentsChoiceBox.setItems(FXCollections.observableList(MainSceneController.choiceStudentsArrayList));
    }
}
