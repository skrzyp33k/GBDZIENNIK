package com.gbsdevelopers.gbdziennik.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddLessonController {

    @FXML
    private TextField classIDTextField;

    @FXML
    private TextField teacherIDTextField;

    @FXML
    private TextField classroomTextField;

    @FXML
    private Button addButton;

    @FXML
    private TextField courseIDTextField;

    @FXML
    void addButtonClicked(ActionEvent event) {

        ((Stage)(((Node) event.getSource()).getScene().getWindow())).close();
    }

}
