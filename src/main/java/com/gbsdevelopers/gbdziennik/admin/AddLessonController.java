package com.gbsdevelopers.gbdziennik.admin;

import com.gbsdevelopers.gbdziennik.Program;
import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for AddLesson
 */
public class AddLessonController {

    /**
     * Class ID TextField
     */
    @FXML
    private TextField classIDTextField;

    /**
     * Teacher ID TextField
     */
    @FXML
    private TextField teacherIDTextField;

    /**
     * Classroom TextField
     */
    @FXML
    private TextField classroomTextField;

    /**
     * Add Button
     */
    @FXML
    private Button addButton;

    /**
     * Course ID TextField
     */
    @FXML
    private TextField courseIDTextField;

    /**
     * Handler for AddButton
     *
     * @param event Event that invoked action
     */
    @FXML
    void addButtonClicked(ActionEvent event) {
        if (!(classIDTextField.getText().isEmpty()) && !(teacherIDTextField.getText().isEmpty()) && !(classroomTextField.getText().isEmpty()) && !(courseIDTextField.getText().isEmpty())) {
            GbsMessage message = new GbsMessage();

            message.header = "_manualQuery";

            message.arguments.add("INSERT INTO lekcje VALUES(null," + courseIDTextField.getText() + "," + classroomTextField.getText() + "," + teacherIDTextField.getText() + "," + classIDTextField.getText() + ")");

            try {
                Program.socket.executeRequest(message);
            } catch (IOException e) {
                e.printStackTrace();
            }

            ((Stage) (((Node) event.getSource()).getScene().getWindow())).close();
        }
    }
}
