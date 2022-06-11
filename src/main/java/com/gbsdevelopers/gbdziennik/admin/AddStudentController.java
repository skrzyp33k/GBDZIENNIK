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
     * Student name TextField
     */
    @FXML
    private TextField studentNameTextField;

    /**
     * Parent name TextField
     */
    @FXML
    private TextField parentNameTextField;

    /**
     * Parent Password TextField
     */
    @FXML
    private TextField parentPassTextField;

    /**
     * Student surname TextField
     */
    @FXML
    private TextField studentSurnameTextField;

    /**
     * Parent surname TextField
     */
    @FXML
    private TextField parentSurnameTextField;

    /**
     * Handler for AddButton
     *
     * @param event Event that invoked action
     */
    @FXML
    void addButtonClicked(ActionEvent event) {

        if (!(classIDTextField.getText().isEmpty()) &&
                !(studentNameTextField.getText().isEmpty()) &&
                !(studentSurnameTextField.getText().isEmpty()) &&
                !(parentNameTextField.getText().isEmpty()) &&
                !(parentSurnameTextField.getText().isEmpty()) &&
                !(parentPassTextField.getText().isEmpty()) &&
                !(studentPassTextField.getText().isEmpty())) {

            GbsMessage message = new GbsMessage();

            message.header = "_addStudent";

            message.arguments.add(studentNameTextField.getText());
            message.arguments.add(studentSurnameTextField.getText());
            message.arguments.add(parentNameTextField.getText());
            message.arguments.add(parentSurnameTextField.getText());
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
