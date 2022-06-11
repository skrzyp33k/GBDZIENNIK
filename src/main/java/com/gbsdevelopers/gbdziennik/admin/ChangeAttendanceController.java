package com.gbsdevelopers.gbdziennik.admin;

import com.gbsdevelopers.gbdziennik.Program;
import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * Controller for ChangeAttendance
 */
public class ChangeAttendanceController {

    /**
     * Logger for log4j
     */
    private static final Logger logger = LogManager.getLogger(ChangeAttendanceController.class);

    /**
     * Type ToggleGroup
     */
    @FXML
    private ToggleGroup type;

    /**
     * Attendance ID TextField
     */
    @FXML
    private TextField attendanceIDTextField;

    /**
     * Handler for ChangeButton
     *
     * @param event Event that invoked action
     */
    @FXML
    void changeButtonClicked(ActionEvent event) {
        logger.info("Clicked changeButton");

        if (!(attendanceIDTextField.getText().isEmpty())) {
            GbsMessage message = new GbsMessage();

            message.header = "_changeAttendance";

            message.arguments.add(attendanceIDTextField.getText());
            message.arguments.add(((RadioButton) (type.getSelectedToggle())).getText());

            try {
                Program.socket.executeRequest(message);
            } catch (IOException e) {
                e.printStackTrace();
            }

            ((Stage) (((Node) event.getSource()).getScene().getWindow())).close();
        }
    }

}
