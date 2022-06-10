package com.gbsdevelopers.gbdziennik.parent;

import com.gbsdevelopers.gbdziennik.Program;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainSceneController implements Initializable {
    @FXML
    private ImageView logoutImage;
    @FXML
    private ImageView attendanceImage;
    @FXML
    private ImageView messagesImage;
    @FXML
    private Label actualUser;
    @FXML
    private ImageView backgroundImage;
    @FXML
    private ImageView avatarImage;
    @FXML
    private ImageView remarksImage;
    @FXML
    private ImageView gradesImage;
    @FXML
    private ImageView scheduleImage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gradesImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/grade.png"))));
        attendanceImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/attendance.png"))));
        messagesImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/messages.png"))));
        remarksImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/remarks.png"))));
        scheduleImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/schedule.png"))));
        avatarImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/parent.png"))));
        logoutImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/logout.png"))));
        backgroundImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/background.png"))));

        actualUser.setText(Program.loggedUser + " (" + Program.loggedID + ")");
    }

    @FXML
    void gradeClicked(MouseEvent event) {

    }

    @FXML
    void attendanceClicked(MouseEvent event) {

    }

    @FXML
    void messagesClicked(MouseEvent event) {

    }

    @FXML
    void remarksClicked(MouseEvent event) {

    }

    @FXML
    void scheduleClicked(MouseEvent event) {

    }

    @FXML
    void logoutClicked(MouseEvent event) throws IOException {
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
