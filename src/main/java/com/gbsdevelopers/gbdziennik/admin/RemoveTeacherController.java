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
 * Controller for RemoveTeacher
 */
public class RemoveTeacherController {

    /**
     * Teacher ID TextField
     */
    @FXML
    private TextField teacherIDTextField;

    /**
     * Handler for RemoveButton
     *
     * @param event Event that invoked action
     */
    @FXML
    void removeButtonClicked(ActionEvent event) {

        if (!(teacherIDTextField.getText().isEmpty())) {
            GbsMessage message = new GbsMessage();

            message.header = "_removeTeacher";

            message.arguments.add(teacherIDTextField.getText());

            try {
                Program.socket.executeRequest(message);
            } catch (IOException e) {
                e.printStackTrace();
            }

            ((Stage) (((Node) event.getSource()).getScene().getWindow())).close();
        }
    }

}