package com.gbsdevelopers.gbdziennik.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddCourseController {

    @FXML
    private TextField nameTextField;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private Button addButton;

    @FXML
    void addButtonClick(ActionEvent event) {

        ((Stage)(((Node) event.getSource()).getScene().getWindow())).close();
    }

}