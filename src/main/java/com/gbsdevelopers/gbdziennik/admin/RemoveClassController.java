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
 * Controller for RemoveClass
 */
public class RemoveClassController {

    /**
     * Class Name TextField
     */
    @FXML
    private TextField classNameTextField;

    /**
     * Handler for RemoveButton
     *
     * @param event Event that invoked action
     */
    @FXML
    void removeButtonClicked(ActionEvent event) {

        if (!(classNameTextField.getText().isEmpty())) {
            GbsMessage message = new GbsMessage();

            message.header = "_removeClass";

            message.arguments.add(classNameTextField.getText());

            try {
                Program.socket.executeRequest(message);
            } catch (IOException e) {
                e.printStackTrace();
            }

            ((Stage) (((Node) event.getSource()).getScene().getWindow())).close();
        }
    }

}

