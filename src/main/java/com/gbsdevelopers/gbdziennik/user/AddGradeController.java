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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Controller for addGradeScene
 */
public class AddGradeController implements Initializable {
    /**
     * Logger for log4j
     */
    private static final Logger logger = LogManager.getLogger(AddGradeController.class);

    /**
     * Weight TextField
     */
    @FXML
    private TextField weightTextField;

    /**
     * Background image
     */
    @FXML
    private ImageView backgroundImage;

    /**
     * Description TextArea
     */
    @FXML
    private TextArea descriptionTextArea;

    /**
     * Lesson ChoiceBox
     */
    @FXML
    private ChoiceBox<GbUserLessonChoiceElement> lessonChoiceBox;

    /**
     * Grade TextField
     */
    @FXML
    private TextField gradeTextField;

    /**
     * Student ChoiceBox
     */
    @FXML
    private ChoiceBox<GbUserStudentChoiceElement> studentsChoiceBox;

    /**
     * Grade Message Label
     */
    @FXML
    private Label gradeMessage;

    /**
     * Weight Message Label
     */
    @FXML
    private Label weightMessage;

    /**
     * Description Message Label
     */
    @FXML
    private Label descriptionMessage;

    /**
     * RegEx Pattern for grade
     */
    private Pattern gradePattern;

    /**
     * RegEx Pattern for weight
     */
    private Pattern weightPattern;

    /**
     * RegEx Pattern for no semicolon
     */
    private Pattern semicolonPattern;

    /**
     * Initialize window.
     *
     * @param location  URL location.
     * @param resources Resource bundle.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
        });

        gradePattern = Pattern.compile("((^[0-6]{1}[+-]?){1,2})$");
        weightPattern = Pattern.compile("((^[1-9]{1}))$");
        semicolonPattern = Pattern.compile("[;]");
    }

    /**
     * Handler for addButton
     *
     * @param event ActionEvent
     */
    @FXML
    private void addButtonClicked(ActionEvent event) {
        logger.info("Clicked addButton");
        String grade = gradeTextField.getText();
        String weight = weightTextField.getText();
        String description = descriptionTextArea.getText();

        String lesson = lessonChoiceBox.getSelectionModel().getSelectedItem().getIdlekcji();

        String student = studentsChoiceBox.getSelectionModel().getSelectedItem().getIducznia();

        descriptionMessage.setText("");
        weightMessage.setText("");
        gradeMessage.setText("");

        if (!(grade.isEmpty()) && !(weight.isEmpty()) && !(description).isEmpty() && !(lesson.isEmpty()) && !(student.isEmpty())) {
            Matcher matcher = gradePattern.matcher(grade);

            if (matcher.matches()) {
                matcher = weightPattern.matcher(weight);
                if (matcher.matches()) {
                    matcher = semicolonPattern.matcher(description);
                    if (!matcher.matches()) {

                        GbsMessage message = new GbsMessage();

                        message.header = "_manualQuery";

                        if (grade.contains("+")) {
                            grade = GbsMessage.removeLastChar(grade) + ".5";
                        } else if (grade.contains("-")) {
                            grade = Integer.parseInt(GbsMessage.removeLastChar(grade)) - 1 + ".75";
                        }

                        String course = lessonChoiceBox.getSelectionModel().getSelectedItem().getIdprzedmiotu();

                        message.arguments.add("INSERT INTO oceny VALUES(null," + grade + "," + weight + ",'" + description + "'," + student + "," + MainSceneController.teacherID + "," + course + ",CURRENT_TIMESTAMP());");

                        try {
                            Program.socket.executeRequest(message);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        ((Stage) (((Node) event.getSource()).getScene().getWindow())).close();
                    } else {
                        descriptionMessage.setText("Niedozwolony znak! (;)");
                    }
                } else {
                    weightMessage.setText("Niedozwolona waga!");
                }
            } else {
                gradeMessage.setText("Niedozwolona ocena!");
            }
        }

        logger.info("Window initialized");

    }
}