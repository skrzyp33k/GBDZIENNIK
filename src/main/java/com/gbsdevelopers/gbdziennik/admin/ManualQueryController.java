package com.gbsdevelopers.gbdziennik.admin;

import com.gbsdevelopers.gbdziennik.AlertBox;
import com.gbsdevelopers.gbdziennik.Program;
import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for ManualQuery
 */
public class ManualQueryController {

    /**
     * Query TextArea
     */
    @FXML
    private TextArea queryTextArea;

    /**
     * Handler for ExecuteQuery
     *
     * @param event Event that invoked action
     */
    @FXML
    void executeButtonClicked(ActionEvent event) {

        if (!(queryTextArea.getText().isEmpty())) {
            GbsMessage message = new GbsMessage();

            message.header = "_manualQuery";

            message.arguments.add(queryTextArea.getText());

            GbsMessage reply = null;

            try {
                reply = Program.socket.executeRequest(message);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                assert reply != null;
                if (!(reply.arguments.get(0).isEmpty())) {
                    AlertBox.show(reply.arguments.get(0), "ERROR");
                }
            } catch (Exception e) {
                //e.printStackTrace();
            }

            ((Stage) (((Node) event.getSource()).getScene().getWindow())).close();
        }

    }

}
