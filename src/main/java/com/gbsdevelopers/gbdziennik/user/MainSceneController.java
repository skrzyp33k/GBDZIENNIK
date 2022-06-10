package com.gbsdevelopers.gbdziennik.user;

import com.gbsdevelopers.gbdziennik.Program;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Controller for userMainScene
 */
public class MainSceneController implements Initializable {
    /**
     * logoutImage ImageView
     */
    @FXML
    private ImageView logoutImage;

    /**
     * refreshImage ImageView
     */
    @FXML
    private ImageView refreshImage;

    /**
     * attendanceImage ImageView
     */
    @FXML
    private ImageView attendanceImage;

    /**
     * messagesImage ImageView
     */
    @FXML
    private ImageView messagesImage;

    /**
     * actualUser Label
     */
    @FXML
    private Label actualUser;

    /**
     * backgroundImage ImageView
     */
    @FXML
    private ImageView backgroundImage;

    /**
     * avatarImage ImageView
     */
    @FXML
    private ImageView avatarImage;

    /**
     * remarksImage ImageView
     */
    @FXML
    private ImageView remarksImage;

    /**
     * gradesImage ImageView
     */
    @FXML
    private ImageView gradesImage;

    /**
     * eventsImage ImageView
     */
    @FXML
    private ImageView eventsImage;

    /**
     * scheduleImage ImageView
     */
    @FXML
    private ImageView scheduleImage;

    /**
     * Student ID
     */
    private String studentID;

    /**
     * Parent ID
     */
    private String parentID;

    /**
     * Teacher ID
     */
    private String teacherID;

    /**
     * Initialize window.
     *
     * @param url            URL location.
     * @param resourceBundle Resource bundle.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentID = null;
        parentID = null;
        teacherID = null;

        gradesImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/grade.png"))));
        attendanceImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/attendance.png"))));
        messagesImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/messages.png"))));
        remarksImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/remarks.png"))));
        eventsImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/events.png"))));
        scheduleImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/schedule.png"))));

        switch(Program.loggedPerms)
        {
            case "u" -> {avatarImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/student.png"))));}
            case "r" -> {avatarImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/parent.png"))));}
            case "n" -> {avatarImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/teacher.png"))));}
        }

        refreshImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/refresh.png"))));
        logoutImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/logout.png"))));
        backgroundImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/background.png"))));

        actualUser.setText(Program.loggedUser + " (" + Program.loggedID + ")");
    }


    /**
     * Handler for mouse clicking on gradeImage
     * @param event Mouse Event
     */
    @FXML
    void gradeClicked(MouseEvent event) {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {

        }
    }

    /**
     * Handler for mouse clicking on attendanceImage
     * @param event Mouse Event
     */
    @FXML
    void attendanceClicked(MouseEvent event) {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {

        }
    }

    /**
     * Handler for mouse clicking on messagesImage
     * @param event Mouse Event
     */
    @FXML
    void messagesClicked(MouseEvent event) {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {

        }
    }

    /**
     * Handler for mouse clicking on remarksImage
     * @param event Mouse Event
     */
    @FXML
    void remarksClicked(MouseEvent event) {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {

        }
    }

    /**
     * Handler for mouse clicking on eventsImage
     * @param event Mouse Event
     */
    @FXML
    void eventsClicked(MouseEvent event) {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {

        }
    }

    /**
     * Handler for mouse clicking on scheduleImage
     * @param event Mouse Event
     */
    @FXML
    void scheduleClicked(MouseEvent event) {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {

        }
    }

    /**
     * Handler for mouse clicking on refreshImage
     * @param event Mouse Event
     */
    @FXML
    void refreshClicked(MouseEvent event) {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {

        }
    }

    /**
     * Handler for mouse clicking on logoutImage
     * @param event Mouse Event
     */
    @FXML
    void logoutClicked(MouseEvent event) throws IOException {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {
            FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource("fxml/loginScene.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
            Stage stage = new Stage();
            stage.setTitle("GBDziennik - Zaloguj się!");
            stage.setScene(scene);
            stage.getIcons().add(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/icon.png"))));
            stage.setResizable(false);
            stage.show();

            ((Stage) (((Node) event.getSource()).getScene().getWindow())).close();
        }
    }
}
