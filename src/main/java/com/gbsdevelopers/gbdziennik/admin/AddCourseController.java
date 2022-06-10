package com.gbsdevelopers.gbdziennik.admin;

import com.gbsdevelopers.gbdziennik.Program;
import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for AddCourse
 */
public class AddCourseController {

    /**
     * Name TextField
     */
    @FXML
    private TextField nameTextField;

    /**
     * Description TextArea
     */
    @FXML
    private TextArea descriptionTextArea;

    /**
     * Add Button
     */
    @FXML
    private Button addButton;

    /**
     * Handler for AddButton
     *
     * @param event Event that invoked action
     */
    @FXML
    void addButtonClick(ActionEvent event) {

        if (!(nameTextField.getText().isEmpty()) && !(descriptionTextArea.getText().isEmpty())) {
            GbsMessage message = new GbsMessage();

            message.header = "_manualQuery";

            message.arguments.add("INSERT INTO przedmioty (nazwa_przedmiotu,opis) VALUES('" + nameTextField.getText() + "','" + descriptionTextArea.getText() + "')");

            try {
                Program.socket.executeRequest(message);
            } catch (IOException e) {
                e.printStackTrace();
            }

            ((Stage) (((Node) event.getSource()).getScene().getWindow())).close();
        }
    }

}