package com.gbsdevelopers.gbdziennik.user;

import com.gbsdevelopers.gbdziennik.Program;
import com.gbsdevelopers.gbdziennik.user.datatypes.GbUserLessonChoiceElement;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import com.gbsdevelopers.gbdziennik.user.DateTimePicker;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class AddEventController implements Initializable {

    @FXML
    private TextField categoryTextArea;

    @FXML
    private ImageView backgroundImage;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private ChoiceBox<GbUserLessonChoiceElement> lessonChoiceBox;

    @FXML
    private Button addButton;

    @FXML
    private HBox dateHBox;

    @FXML
    private DateTimePicker dateTimePicker;

    @FXML
    void addButtonClicked(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backgroundImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/background_sm.png"))));

        dateTimePicker = new DateTimePicker();
        dateHBox.getChildren().add(dateTimePicker);

        lessonChoiceBox.setItems(FXCollections.observableList(MainSceneController.choiceLessonsArrayList));
    }
}

