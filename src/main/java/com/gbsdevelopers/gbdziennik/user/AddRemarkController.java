package com.gbsdevelopers.gbdziennik.user;

import com.gbsdevelopers.gbdziennik.Program;
import com.gbsdevelopers.gbdziennik.user.datatypes.GbUserStudentChoiceElement;
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

public class AddRemarkController  implements Initializable {

    @FXML
    private ImageView backgroundImage;

    @FXML
    private TextArea contentTextArea;

    @FXML
    private Button addButton;

    @FXML
    private ChoiceBox<GbUserStudentChoiceElement> studentsChoiceBox;

    @FXML
    void addButtonClicked(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backgroundImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/background_sm.png"))));

        studentsChoiceBox.setItems(FXCollections.observableList(MainSceneController.choiceStudentsArrayList));
    }
}
