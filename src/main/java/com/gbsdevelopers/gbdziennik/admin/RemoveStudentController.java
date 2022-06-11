package com.gbsdevelopers.gbdziennik.admin;

import com.gbsdevelopers.gbdziennik.Program;
import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * Controller for RemoveStudent
 */
public class RemoveStudentController {

    /**
     * Logger for log4j
     */
    private static final Logger logger = LogManager.getLogger(RemoveStudentController.class);

    /**
     * Student ID TextField
     */
    @FXML
    private TextField studentIdTextField;

    /**
     * Handler for RemoveButton
     *
     * @param event Event that invoked action
     */
    @FXML
    void removeButtonClicked(ActionEvent event) {
        logger.info("Clicked removeButton");

        if (!(studentIdTextField.getText().isEmpty())) {
            GbsMessage message = new GbsMessage();

            message.header = "_removeStudent";

            message.arguments.add(studentIdTextField.getText());

            try {
                Program.socket.executeRequest(message);
            } catch (IOException e) {
                e.printStackTrace();
            }

            ((Stage) (((Node) event.getSource()).getScene().getWindow())).close();
        }

    }

}
