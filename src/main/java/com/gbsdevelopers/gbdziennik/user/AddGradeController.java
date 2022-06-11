package com.gbsdevelopers.gbdziennik.user;

import com.gbsdevelopers.gbdziennik.Program;
import com.gbsdevelopers.gbdziennik.user.datatypes.GbUserLessonChoiceElement;
import com.gbsdevelopers.gbdziennik.user.datatypes.GbUserStudentChoiceElement;
import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddGradeController implements Initializable {

    @FXML
    Button addButton;
    @FXML
    private TextField weightTextArea;
    @FXML
    private ImageView backgroundImage;
    @FXML
    private TextArea descriptionTextArea;
    @FXML
    private ChoiceBox<GbUserLessonChoiceElement> lessonChoiceBox;
    @FXML
    private TextField gradeTextArea;
    @FXML
    private ChoiceBox<GbUserStudentChoiceElement> studentsChoiceBox;
    @FXML
    private Label gradeMessage;

    @FXML
    private Label weightMessage;

    @FXML
    private Label descriptionMessage;

    private Pattern gradePattern;

    private Pattern weightPattern;

    private Pattern semicolonPattern;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backgroundImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/background_sm.png"))));

        lessonChoiceBox.setItems(FXCollections.observableList(MainSceneController.choiceLessonsArrayList));

        lessonChoiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<GbUserLessonChoiceElement>() {
            @Override
            public void changed(ObservableValue<? extends GbUserLessonChoiceElement> observableValue, GbUserLessonChoiceElement gbUserLessonChoiceElement, GbUserLessonChoiceElement t1) {
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
            }
        });
    }

    @FXML
    private void addButtonClicked(ActionEvent event) {
        String grade = gradeTextArea.getText();
        String weight = weightTextArea.getText();
        String description = descriptionTextArea.getText();

        String lesson = lessonChoiceBox.getSelectionModel().getSelectedItem().getIdlekcji();

        String student = studentsChoiceBox.getSelectionModel().getSelectedItem().getIducznia();

        descriptionMessage.setText("");
        weightMessage.setText("");
        gradeMessage.setText("");

        gradePattern = Pattern.compile("((^[0-6]{1}[+-]?){1,2})$");
        weightPattern = Pattern.compile("((^[1-9]{1}))$");
        semicolonPattern = Pattern.compile("[;]");

        if (!(grade.isEmpty()) && !(weight.isEmpty()) && !(description).isEmpty() && !(lesson.isEmpty()) && !(student.isEmpty())) {
            Matcher matcher = gradePattern.matcher(grade);

            if (matcher.matches()) {
                matcher = weightPattern.matcher(weight);
                if (matcher.matches()) {
                    matcher = semicolonPattern.matcher(description);
                    if (!matcher.matches()) {

                        GbsMessage message = new GbsMessage();

                        message.header = "_manualQuery";

                        if(grade.contains("+"))
                        {
                            grade = GbsMessage.removeLastChar(grade) + ".5";
                        }
                        else if(grade.contains("-"))
                        {
                            grade = Integer.parseInt(GbsMessage.removeLastChar(grade)) + ".75";
                        }

                        String course = lessonChoiceBox.getSelectionModel().getSelectedItem().getIdprzedmiotu();

                        System.out.println("INSERT INTO oceny VALUES(null,"+grade+","+weight+",'"+description+"',"+student+","+MainSceneController.teacherID+","+course+",CURRENT_TIMESTAMP());");

                        message.arguments.add("INSERT INTO oceny VALUES(null,"+grade+","+weight+",'"+description+"',"+student+","+MainSceneController.teacherID+","+course+",CURRENT_TIMESTAMP());");

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
    }
}