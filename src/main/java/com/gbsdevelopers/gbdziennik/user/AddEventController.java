package com.gbsdevelopers.gbdziennik.user;

import com.gbsdevelopers.gbdziennik.Program;
import com.gbsdevelopers.gbdziennik.user.datatypes.GbUserLessonChoiceElement;
import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


/**
 * Controller for addEventScene
 */
public class AddEventController implements Initializable {

    /**
     * Category TextField
     */
    @FXML
    private TextField categoryTextField;

    /**
     * Category Message
     */
    @FXML
    private Label categoryMessage;

    /**
     * Background Image
     */
    @FXML
    private ImageView backgroundImage;

    /**
     * Description TextArea
     */
    @FXML
    private TextArea descriptionTextArea;

    /**
     * Description Message
     */
    @FXML
    private Label descriptionMessage;


    /**
     * Lesson ChoiceBox
     */
    @FXML
    private ChoiceBox<GbUserLessonChoiceElement> lessonChoiceBox;

    /**
     * Date HBox
     */
    @FXML
    private HBox dateHBox;

    /**
     * Date and Time Picker
     */
    @FXML
    private DateTimePicker dateTimePicker;

    /**
     * Handler for addButton
     * @param event ActionEvent
     */
    @FXML
    void addButtonClicked(ActionEvent event) {
        String lessonID = lessonChoiceBox.getSelectionModel().getSelectedItem().getIdlekcji();
        String category = categoryTextField.getText();
        String date = dateTimePicker.toString();
        String description = descriptionTextArea.getText();

        categoryMessage.setText("");
        descriptionMessage.setText("");

        if(!(lessonID.isEmpty()) && !(category.isEmpty()) && !(date.isEmpty()) && !(description.isEmpty()))
        {
            if(category.contains(";"))
            {
                //category ;
                categoryMessage.setText("Niedozwolony znak (;)");
            }
            else
            {
                if(description.contains(";"))
                {
                    //description ;
                    descriptionMessage.setText("Niedozwolony znak (;)");
                }
                else
                {
                    //success
                    GbsMessage message = new GbsMessage();

                    message.header = "_manualQuery";

                    message.arguments.add("INSERT INTO wydarzenia VALUES(null,'"+category+"','"+description+"',"+lessonID+",'"+date+"');");

                    try {
                        Program.socket.executeRequest(message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    ((Stage) (((Node) event.getSource()).getScene().getWindow())).close();
                }
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

        dateTimePicker = new DateTimePicker();
        dateHBox.getChildren().add(dateTimePicker);

        lessonChoiceBox.setItems(FXCollections.observableList(MainSceneController.choiceLessonsArrayList));
    }
}

