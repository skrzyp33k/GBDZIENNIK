package com.gbsdevelopers.gbdziennik.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddClassController {

    @FXML
    private TextField teacherIdTextField;

    @FXML
    private Button addButton;

    @FXML
    private TextField classNameTextField;

    @FXML
    void addButtonClicked(ActionEvent event) {

        ((Stage)(((Node) event.getSource()).getScene().getWindow())).close();
    }

}
