package com.gbsdevelopers.gbdziennik.user;

import com.gbsdevelopers.gbdziennik.Program;
import com.gbsdevelopers.gbdziennik.user.datatypes.GbUserLessonChoiceElement;
import com.gbsdevelopers.gbdziennik.user.datatypes.GbUserStudentChoiceElement;
import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class AddGradeController implements Initializable {

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
}