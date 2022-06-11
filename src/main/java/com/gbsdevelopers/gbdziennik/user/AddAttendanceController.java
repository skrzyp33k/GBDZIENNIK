package com.gbsdevelopers.gbdziennik.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ToggleGroup;

public class AddAttendanceController {

    @FXML
    private ChoiceBox<?> lessonChoiceBox;

    @FXML
    private Button addButton;

    @FXML
    private ToggleGroup type;

    @FXML
    private ChoiceBox<?> studentsChoiceBox;

    @FXML
    void addButtonClicked(ActionEvent event) {

    }
}