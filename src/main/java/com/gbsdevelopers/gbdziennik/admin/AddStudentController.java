package com.gbsdevelopers.gbdziennik.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddStudentController {

    @FXML
    private TextField classIDTextField;

    @FXML
    private TextField studentPassTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField parentPassTextField;

    @FXML
    private Button addButton;

    @FXML
    private TextField surnameTextField;

    @FXML
    void addButtonClicked(ActionEvent event) {

        ((Stage)(((Node) event.getSource()).getScene().getWindow())).close();
    }

}
