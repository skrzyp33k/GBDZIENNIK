package com.gbsdevelopers.gbdziennik.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RemoveClassController {

    @FXML
    private Button removeButton;

    @FXML
    private TextField classNameTextField;

    @FXML
    void removeButtonClicked(ActionEvent event) {

        ((Stage)(((Node) event.getSource()).getScene().getWindow())).close();
    }

}

