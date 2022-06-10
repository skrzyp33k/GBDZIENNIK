package com.gbsdevelopers.gbdziennik.admin;

import com.gbsdevelopers.gbdziennik.Program;
import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for AddStudent
 */
public class AddStudentController {

    /**
     * Class ID TextField
     */
    @FXML
    private TextField classIDTextField;

    /**
     * Student Password TextField
     */
    @FXML
    private TextField studentPassTextField;

    /**
     * Name TextField
     */
    @FXML
    private TextField nameTextField;

    /**
     * Parent Password TextField
     */
    @FXML
    private TextField parentPassTextField;

    /**
     * Surname TextField
     */
    @FXML
    private TextField surnameTextField;

    /**
     * Handler for AddButton
     *
     * @param event Event that invoked action
     */
    @FXML
    void addButtonClicked(ActionEvent event) {

        if (!(classIDTextField.getText().isEmpty()) &&
                !(nameTextField.getText().isEmpty()) &&
                !(surnameTextField.getText().isEmpty()) &&
                !(parentPassTextField.getText().isEmpty()) &&
                !(studentPassTextField.getText().isEmpty())) {

            GbsMessage message = new GbsMessage();

            message.header = "_addStudent";

            message.arguments.add(nameTextField.getText());
            message.arguments.add(surnameTextField.getText());
            message.arguments.add(classIDTextField.getText());
            message.arguments.add(GbsMessage.MD5(studentPassTextField.getText()));
            message.arguments.add(GbsMessage.MD5(parentPassTextField.getText()));

            try {
                Program.socket.executeRequest(message);
            } catch (IOException e) {
                e.printStackTrace();
            }

            ((Stage) (((Node) event.getSource()).getScene().getWindow())).close();
        }
    }

}
