package com.gbsdevelopers.gbdziennik.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddTeacherController {

    @FXML
    private TextField phoneTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private Button addButton;

    @FXML
    private TextField surnameTextField;

    @FXML
    void addButtonClicked(ActionEvent event) {

        ((Stage)(((Node) event.getSource()).getScene().getWindow())).close();
    }

}