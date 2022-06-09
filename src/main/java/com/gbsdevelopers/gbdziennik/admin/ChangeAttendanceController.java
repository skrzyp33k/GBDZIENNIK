package com.gbsdevelopers.gbdziennik.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class ChangeAttendanceController {

    @FXML
    private ToggleGroup type;

    @FXML
    private TextField attendanceIDTextField;

    @FXML
    private Button changeButton;

    @FXML
    void changeButtonClicked(ActionEvent event) {

        ((Stage)(((Node) event.getSource()).getScene().getWindow())).close();
    }

}
