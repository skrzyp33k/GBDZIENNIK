package com.gbsdevelopers.gbdziennik.admin;

import com.gbsdevelopers.gbdziennik.Program;
import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * Controller for AddClass
 */
public class AddClassController {
    /**
     * Logger for log4j
     */
    private static final Logger logger = LogManager.getLogger(AddClassController.class);

    /**
     * Teacher ID TextField
     */
    @FXML
    private TextField teacherIdTextField;

    /**
     * Add Button
     */
    @FXML
    private Button addButton;

    /**
     * Class name TextField
     */
    @FXML
    private TextField classNameTextField;

    /**
     * Handler for AddButton
     *
     * @param event Event that invoked action
     */
    @FXML
    void addButtonClicked(ActionEvent event) {
        logger.info("Clicked addButton");
        if (!(classNameTextField.getText().isEmpty()) && !(teacherIdTextField.getText().isEmpty())) {
            GbsMessage message = new GbsMessage();

            message.header = "_createClass";

            message.arguments.add(classNameTextField.getText());
            message.arguments.add(teacherIdTextField.getText());

            try {
                Program.socket.executeRequest(message);
            } catch (IOException e) {
                e.printStackTrace();
            }

            ((Stage) (((Node) event.getSource()).getScene().getWindow())).close();
        }
    }

}
