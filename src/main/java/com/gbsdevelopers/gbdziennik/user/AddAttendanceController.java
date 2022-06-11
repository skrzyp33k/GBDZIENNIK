package com.gbsdevelopers.gbdziennik.user;

import com.gbsdevelopers.gbdziennik.Program;
import com.gbsdevelopers.gbdziennik.user.datatypes.GbUserLessonChoiceElement;
import com.gbsdevelopers.gbdziennik.user.datatypes.GbUserStudentChoiceElement;
import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Controller for addAttendanceScene
 */
public class AddAttendanceController implements Initializable {
    /**
     * Logger for log4j
     */
    private static final Logger logger = LogManager.getLogger(AddAttendanceController.class);

    /**
     * Lesson ChoiceBox
     */
    @FXML
    private ChoiceBox<GbUserLessonChoiceElement> lessonChoiceBox;

    /**
     * Background Image
     */
    @FXML
    private ImageView backgroundImage;

    /**
     * Attendance Type
     */
    @FXML
    private ToggleGroup type;

    /**
     * Students ChoiceBox
     */
    @FXML
    private ChoiceBox<GbUserStudentChoiceElement> studentsChoiceBox;

    /**
     * Handler for addButton
     *
     * @param event ActionEvent
     */
    @FXML
    void addButtonClicked(ActionEvent event) {
        logger.info("Clicked addButton");
        String lessonID = lessonChoiceBox.getSelectionModel().getSelectedItem().getIdlekcji();
        String studentID = studentsChoiceBox.getSelectionModel().getSelectedItem().getIducznia();
        String typ = ((RadioButton) (type.getSelectedToggle())).getText();
        if (!(lessonID.isEmpty()) && !(studentID.isEmpty()) && !(typ.isEmpty())) {
            GbsMessage message = new GbsMessage();

            message.header = "_manualQuery";

            message.arguments.add("INSERT INTO nieobecnosci VALUES(null," + studentID + "," + lessonID + ",CURRENT_TIMESTAMP(),'" + typ + "');");

            try {
                Program.socket.executeRequest(message);
            } catch (IOException e) {
                e.printStackTrace();
            }

            ((Stage) (((Node) event.getSource()).getScene().getWindow())).close();
        }
    }

    /**
     * Initialize window.
     *
     * @param url            URL location.
     * @param resourceBundle Resource bundle.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backgroundImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/background_sm.png"))));

        lessonChoiceBox.setItems(FXCollections.observableList(MainSceneController.choiceLessonsArrayList));

        lessonChoiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, gbUserLessonChoiceElement, t1) -> {
            studentsChoiceBox.setDisable(false);

            String className = lessonChoiceBox.getSelectionModel().selectedItemProperty().get().getClassName();

            GbsMessage message = new GbsMessage();

            message.header = "_executeSelect";

            message.arguments.add("SELECT u.ID_ucznia, CONCAT(u.nazwisko,\" \", u.imie) AS Dane FROM uczniowie u, klasy k WHERE u.ID_klasy = k.ID_klasy AND k.nazwa_klasy = '" + className + "';");

            GbsMessage reply = null;

            try {
                reply = Program.socket.executeRequest(message);
            } catch (IOException e) {
                e.printStackTrace();
            }

            ArrayList<GbUserStudentChoiceElement> localStudentsArrayList = new ArrayList<>();

            assert reply != null;
            for (String str : reply.arguments) {
                localStudentsArrayList.add(new GbUserStudentChoiceElement(str));
            }

            studentsChoiceBox.setItems(FXCollections.observableList(localStudentsArrayList));

            logger.info("Window initialized");
        });
    }
}