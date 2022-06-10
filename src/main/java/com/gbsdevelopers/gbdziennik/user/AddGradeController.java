package com.gbsdevelopers.gbdziennik.user;

import com.gbsdevelopers.gbdziennik.admin.datatypes.GbLesson;
import com.gbsdevelopers.gbdziennik.admin.datatypes.GbStudent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class AddGradeController {

    @FXML
    private TextField weightTextArea;

    @FXML
    private ImageView backgroundImage;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private ChoiceBox<GbLesson> lessonChoiceBox;

    @FXML
    private TextField gradeTextArea;

    @FXML
    private ChoiceBox<GbStudent> studentsChoiceBox;

}
