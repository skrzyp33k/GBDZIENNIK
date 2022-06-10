package com.gbsdevelopers.gbdziennik.user;

import com.gbsdevelopers.gbdziennik.Program;
import com.gbsdevelopers.gbdziennik.user.datatypes.*;
import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Vector;

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

    @FXML
    private VBox sideVBox;

    @FXML
    TableView<GbUserGrade> gradesTableView;

    @FXML
    TableView<GbUserAttendance> attendancesTableView;

    @FXML
    TableView<GbUserMessage> messagesTableView;

    @FXML
    TableView<GbUserRemark> remarksTableView;

    @FXML
    TableView<GbUserEvent> eventsTableView;

    @FXML
    TableView<GbUserSchedule> scheduleTableView;

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
     * Class ID
     */
    private String classID;

    /**
     * Class name
     */
    private String className;

    /**
     * Get studentID for logged user
     *
     * @return studentID
     */
    private String getStudentID() {
        String query;
        if(Program.loggedPerms.equals("u"))
        {
            query = "SELECT ID_ucznia FROM uczniowie WHERE ID_konta = " + Program.loggedID + ";";
        }
        else
        {
            query = "SELECT ID_ucznia FROM uczniowie WHERE ID_rodzica = " + parentID + ";";
        }

        GbsMessage message = new GbsMessage();

        message.header = "_executeSelect";

        message.arguments.add(query);

        GbsMessage reply = null;

        try {
            reply = Program.socket.executeRequest(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert reply != null;
        return reply.arguments.get(0);

    }

    /**
     * Get parentID for logged user
     *
     * @return parentID
     */
    private String getParentID() {
        String query = "SELECT ID_rodzica FROM rodzice WHERE ID_konta = " + Program.loggedID + ";";

        GbsMessage message = new GbsMessage();

        message.header = "_executeSelect";

        message.arguments.add(query);

        GbsMessage reply = null;

        try {
            reply = Program.socket.executeRequest(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert reply != null;
        return reply.arguments.get(0);
    }

    /**
     * Get classID for logged user
     *
     * @return classID
     */
    private String getTeacherID() {
        String query = "SELECT ID_nauczyciela FROM nauczyciele WHERE ID_konta = " + Program.loggedID + ";";

        GbsMessage message = new GbsMessage();

        message.header = "_executeSelect";

        message.arguments.add(query);

        GbsMessage reply = null;

        try {
            reply = Program.socket.executeRequest(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert reply != null;
        return reply.arguments.get(0);

    }

    /**
     * Get classID for logged user
     *
     * @return classID
     */
    private String getClassID() {
        String query = "SELECT ID_klasy FROM uczniowie WHERE ID_ucznia = " + studentID + ";";

        GbsMessage message = new GbsMessage();

        message.header = "_executeSelect";

        message.arguments.add(query);

        GbsMessage reply = null;

        try {
            reply = Program.socket.executeRequest(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert reply != null;
        return reply.arguments.get(0);
    }

    private String getClassName()
    {
        String query = "SELECT nazwa_klasy FROM klasy WHERE ID_klasy = " + classID + ";";

        GbsMessage message = new GbsMessage();

        message.header = "_executeSelect";

        message.arguments.add(query);

        GbsMessage reply = null;

        try {
            reply = Program.socket.executeRequest(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert reply != null;
        return reply.arguments.get(0);
    }

    /**
     * Get IDs for actual user
     */
    private void getIDs() {
        switch (Program.loggedPerms) {
            case "n":
                teacherID = getTeacherID();
                break;
            case "r":
                parentID = getParentID();
            case "u":
                studentID = getStudentID();
                classID = getClassID();
                className = getClassName();
                break;
            default:
                break;
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
        studentID = null;
        parentID = null;
        teacherID = null;
        classID = null;
        className = null;

        getIDs();

        gradesImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/grade.png"))));
        attendanceImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/attendance.png"))));
        messagesImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/messages.png"))));
        remarksImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/remarks.png"))));
        eventsImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/events.png"))));
        scheduleImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/schedule.png"))));

        switch (Program.loggedPerms) {
            case "u" -> avatarImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/student.png"))));
            case "r" -> avatarImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/parent.png"))));
            case "n" -> avatarImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/teacher.png"))));
        }

        refreshImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/refresh.png"))));
        logoutImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/logout.png"))));
        backgroundImage.setImage(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/background.png"))));

        actualUser.setText(Program.loggedUser + " (" + Program.loggedID + ")");

        gradeClickedFunc();
    }

    /**
     * Function that opens new window from Stage.
     *
     * @param fxml  FXML name
     * @param title Window title
     * @throws IOException Throws when can not find or load resources.
     */
    private void showStage(String fxml, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource("fxml/" + fxml));
        Scene scene = new Scene(fxmlLoader.load(), 480, 640);

        Stage stage = new Stage();

        stage.setTitle("GBDziennik - " + title);
        stage.setScene(scene);
        stage.getIcons().add(new Image(Objects.requireNonNull(Program.class.getResourceAsStream("img/icon.png"))));
        stage.setResizable(false);
        stage.show();
    }

    //region TableViews functions

    /**
     * Changes TableViews visibility
     *
     * @param tableView TableView that is should be visible
     */
    private void tablesVisibility(TableView<?> tableView) {
        gradesTableView.setVisible(false);
        attendancesTableView.setVisible(false);
        messagesTableView.setVisible(false);
        remarksTableView.setVisible(false);
        eventsTableView.setVisible(false);
        scheduleTableView.setVisible(false);

        tableView.setVisible(true);
    }

    /**
     * GradesTable builder
     */
    private void buildGradesTable() {
        String query = switch (Program.loggedPerms) {
            case "n" -> "SELECT CONCAT((SELECT nazwisko FROM uczniowie WHERE ID_ucznia = o.ID_ucznia),\" \",(SELECT imie FROM uczniowie WHERE ID_ucznia = o.ID_ucznia)) AS uczen, p.nazwa_przedmiotu AS Przedmiot, o.Ocena AS Ocena, o.Waga AS Waga, o.Opis AS Opis, o.data_wystawienia AS Data_wystawienia FROM oceny o, przedmioty p WHERE o.ID_przedmiotu = p.ID_przedmiotu AND ID_nauczyciela = " + teacherID + " ORDER BY p.nazwa_przedmiotu ASC, uczen ASC, o.data_wystawienia DESC;";
            default -> "SELECT null,p.nazwa_przedmiotu AS Przedmiot, o.Ocena AS Ocena, o.Waga AS Waga, o.Opis AS Opis, o.data_wystawienia AS Data_wystawienia FROM oceny o, przedmioty p WHERE o.ID_przedmiotu = p.ID_przedmiotu AND ID_ucznia = " + studentID + " ORDER BY p.nazwa_przedmiotu ASC, o.data_wystawienia DESC;";
        };

        GbsMessage message = new GbsMessage();

        message.header = "_executeSelect";

        message.arguments.add(query);

        GbsMessage reply = null;

        try {
            reply = Program.socket.executeRequest(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<GbUserGrade> resultArrayList = new ArrayList<>();

        assert reply != null;
        for (String str : reply.arguments) {
            resultArrayList.add(new GbUserGrade(str));
        }

        ObservableList<GbUserGrade> data = FXCollections.observableArrayList(resultArrayList);

        gradesTableView.getColumns().clear();

        TableColumn columnUczen = new TableColumn("Uczeń");
        TableColumn columnPrzedmiot = new TableColumn("Przedmiot");
        TableColumn columnOcena = new TableColumn("Ocena");
        TableColumn columnWaga = new TableColumn("Waga");
        TableColumn columnOpis = new TableColumn("Opis");
        TableColumn columnDatawystawienia = new TableColumn("Data wystawienia");

        columnUczen.setCellValueFactory(new PropertyValueFactory<>("uczen"));
        columnPrzedmiot.setCellValueFactory(new PropertyValueFactory<GbUserGrade, String>("przedmiot"));
        columnOcena.setCellValueFactory(new PropertyValueFactory<GbUserGrade, String>("ocena"));
        columnWaga.setCellValueFactory(new PropertyValueFactory<GbUserGrade, String>("waga"));
        columnOpis.setCellValueFactory(new PropertyValueFactory<GbUserGrade, String>("opis"));
        columnDatawystawienia.setCellValueFactory(new PropertyValueFactory<GbUserGrade, String>("datawystawienia"));

        gradesTableView.setItems(data);

        if(Program.loggedPerms.equals("n"))
        {
            gradesTableView.getColumns().addAll(columnUczen,columnPrzedmiot, columnOcena, columnWaga, columnOpis, columnDatawystawienia);
        }
        else
        {
            gradesTableView.getColumns().addAll(columnPrzedmiot, columnOcena, columnWaga, columnOpis, columnDatawystawienia);
        }
    }

    /**
     * AttendancesTable builder
     */
    private void buildAttendancesTable() {
        String query = switch (Program.loggedPerms) {
            case "n" -> "SELECT CONCAT((SELECT nazwisko FROM uczniowie WHERE ID_ucznia = n.ID_ucznia),\" \",(SELECT imie FROM uczniowie WHERE ID_ucznia = n.ID_ucznia)) AS uczen, p.nazwa_przedmiotu, n.data_nieobecnosci, n.TYP FROM nieobecnosci n, lekcje l, przedmioty p WHERE n.ID_lekcji = l.ID_lekcji AND l.ID_przedmiotu = p.ID_przedmiotu AND l.ID_nauczyciela = " + teacherID + " ORDER BY p.nazwa_przedmiotu ASC, uczen ASC, n.data_nieobecnosci DESC;";
            default -> "SELECT null, p.nazwa_przedmiotu, n.data_nieobecnosci, n.TYP FROM nieobecnosci n, lekcje l, przedmioty p WHERE n.ID_lekcji = l.ID_lekcji AND l.ID_przedmiotu = p.ID_przedmiotu AND n.ID_ucznia = " + studentID + " ORDER BY p.nazwa_przedmiotu ASC, n.data_nieobecnosci DESC;";
        };

        GbsMessage message = new GbsMessage();

        message.header = "_executeSelect";

        message.arguments.add(query);

        GbsMessage reply = null;

        try {
            reply = Program.socket.executeRequest(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<GbUserAttendance> resultArrayList = new ArrayList<>();

        assert reply != null;
        for (String str : reply.arguments) {
            resultArrayList.add(new GbUserAttendance(str));
        }

        ObservableList<GbUserAttendance> data = FXCollections.observableArrayList(resultArrayList);

        attendancesTableView.getColumns().clear();

        TableColumn columnUczen = new TableColumn("Uczeń");
        TableColumn columnPrzedmiot = new TableColumn("Przedmiot");
        TableColumn columnData = new TableColumn("Data");
        TableColumn columnTyp = new TableColumn("Typ");


        columnUczen.setCellValueFactory(new PropertyValueFactory<GbUserAttendance, String>("uczen"));
        columnPrzedmiot.setCellValueFactory(new PropertyValueFactory<GbUserAttendance, String>("przedmiot"));
        columnData.setCellValueFactory(new PropertyValueFactory<GbUserAttendance, String>("data"));
        columnTyp.setCellValueFactory(new PropertyValueFactory<GbUserAttendance, String>("typ"));

        attendancesTableView.setItems(data);

        if(Program.loggedPerms.equals("n"))
        {
            attendancesTableView.getColumns().addAll(columnUczen, columnPrzedmiot, columnData, columnTyp);
        }
        else
        {
            attendancesTableView.getColumns().addAll(columnPrzedmiot, columnData, columnTyp);
        }
    }

    /**
     * MessagesTable builder
     */
    private void buildMessagesTable() {
        String query = switch (Program.loggedPerms) {
            case "n" -> "SELECT CONCAT((SELECT imie FROM rodzice WHERE ID_konta = w.ID_nadawcy UNION SELECT imie FROM uczniowie WHERE ID_konta = w.ID_nadawcy),\" \",(SELECT nazwisko FROM rodzice WHERE ID_konta = w.ID_nadawcy UNION SELECT nazwisko FROM uczniowie WHERE ID_konta = w.ID_nadawcy)),  w.Wiadomosc, w.data_wyslania FROM wiadomosci w WHERE ID_odbiorcy = " + Program.loggedID + " ORDER BY data_wyslania DESC;";
            case "u", "r" -> "SELECT CONCAT(n.imie,\" \", n.nazwisko), w.Wiadomosc, w.data_wyslania FROM wiadomosci w, konta k, nauczyciele n WHERE w.ID_nadawcy = k.ID_konta AND k.ID_konta = n.ID_konta AND w.ID_odbiorcy =  " + Program.loggedID + " ORDER BY data_wyslania DESC;";
            default -> "";
        };

        GbsMessage message = new GbsMessage();

        message.header = "_executeSelect";

        message.arguments.add(query);

        GbsMessage reply = null;

        try {
            reply = Program.socket.executeRequest(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<GbUserMessage> resultArrayList = new ArrayList<>();

        assert reply != null;
        for (String str : reply.arguments) {
            resultArrayList.add(new GbUserMessage(str));
        }

        ObservableList<GbUserMessage> data = FXCollections.observableArrayList(resultArrayList);

        messagesTableView.getColumns().clear();

        TableColumn columnNadawca = new TableColumn("Nadawca");
        TableColumn columnWiadomosc = new TableColumn("Wiadomość");
        TableColumn columnData = new TableColumn("Data Wysłania");


        columnNadawca.setCellValueFactory(new PropertyValueFactory<>("nadawca"));
        columnWiadomosc.setCellValueFactory(new PropertyValueFactory<>("wiadomosc"));
        columnData.setCellValueFactory(new PropertyValueFactory<>("data"));

        messagesTableView.setItems(data);

        messagesTableView.getColumns().addAll(columnNadawca, columnWiadomosc, columnData);
    }

    /**
     * RemarksTable builder
     */
    private void buildRemarksTable() {
        String query = switch (Program.loggedPerms) {
            case "n" -> "SELECT CONCAT(n.imie,\" \",n.nazwisko), u.Tresc, u.data_wystawienia FROM uwagi u, uczniowie n WHERE u.ID_ucznia = n.ID_ucznia AND ID_nauczyciela = " + teacherID + " ORDER BY data_wystawienia DESC;";
            default -> "SELECT CONCAT(n.imie,\" \",n.nazwisko), u.Tresc, u.data_wystawienia FROM uwagi u, nauczyciele n WHERE u.ID_nauczyciela = n.ID_nauczyciela AND ID_ucznia = " + studentID + " ORDER BY data_wystawienia DESC;";
        };

        GbsMessage message = new GbsMessage();

        message.header = "_executeSelect";

        message.arguments.add(query);

        GbsMessage reply = null;

        try {
            reply = Program.socket.executeRequest(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<GbUserRemark> resultArrayList = new ArrayList<>();

        assert reply != null;
        for (String str : reply.arguments) {
            resultArrayList.add(new GbUserRemark(str));
        }

        ObservableList<GbUserRemark> data = FXCollections.observableArrayList(resultArrayList);

        remarksTableView.getColumns().clear();

        TableColumn columnOsoba;
        if (Program.loggedPerms.equals("n")) {
            columnOsoba = new TableColumn<>("Imię i nazwisko ucznia");
        } else {
            columnOsoba = new TableColumn<>("Imię i nazwisko nauczyciela");
        }
        TableColumn columnTresc = new TableColumn("Treść");
        TableColumn columnData = new TableColumn("Data Wysłania");


        columnOsoba.setCellValueFactory(new PropertyValueFactory<GbUserRemark, String>("osoba"));
        columnTresc.setCellValueFactory(new PropertyValueFactory<GbUserRemark, String>("tresc"));
        columnData.setCellValueFactory(new PropertyValueFactory<GbUserRemark, String>("data"));

        remarksTableView.setItems(data);

        remarksTableView.getColumns().addAll(columnOsoba, columnTresc, columnData);
    }

    /**
     * EventsTable builder
     */
    private void buildEventsTable() {
        String query = switch (Program.loggedPerms) {
            case "n" -> "SELECT p.nazwa_przedmiotu, k.nazwa_klasy, w.Kategoria, w.Opis, w.data_wydarzenia FROM wydarzenia w, przedmioty p, lekcje l, klasy k WHERE w.ID_lekcji = l.ID_lekcji AND l.ID_przedmiotu = p.ID_przedmiotu AND l.ID_klasy = k.ID_klasy AND l.ID_nauczyciela = "+teacherID+" ORDER BY p.nazwa_przedmiotu ASC, w.data_wydarzenia DESC;";
            default -> "SELECT p.nazwa_przedmiotu, null, w.Kategoria, w.Opis, w.data_wydarzenia FROM wydarzenia w, przedmioty p, lekcje l, klasy k, uczniowie u WHERE w.ID_lekcji = l.ID_lekcji AND l.ID_przedmiotu = p.ID_przedmiotu AND u.ID_klasy = l.ID_klasy AND u.ID_ucznia = "+studentID+" ORDER BY w.data_wydarzenia DESC;";
        };

        GbsMessage message = new GbsMessage();

        message.header = "_executeSelect";

        message.arguments.add(query);

        GbsMessage reply = null;

        try {
            reply = Program.socket.executeRequest(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<GbUserEvent> resultArrayList = new ArrayList<>();

        assert reply != null;
        for (String str : reply.arguments) {
            resultArrayList.add(new GbUserEvent(str));
        }

        ObservableList<GbUserEvent> data = FXCollections.observableArrayList(resultArrayList);

        eventsTableView.getColumns().clear();

        TableColumn columnPrzedmiot = new TableColumn("Przedmiot");
        TableColumn columnKlasa = new TableColumn("Klasa");
        TableColumn columnKategoria = new TableColumn("Kategoria");
        TableColumn columnOpis = new TableColumn("Opis");
        TableColumn columnDatawydarzenia = new TableColumn("Data wydarzenia");


        columnPrzedmiot.setCellValueFactory(new PropertyValueFactory<GbUserGrade, String>("przedmiot"));
        columnKlasa.setCellValueFactory(new PropertyValueFactory<GbUserGrade, String>("klasa"));
        columnKategoria.setCellValueFactory(new PropertyValueFactory<GbUserGrade, String>("kategoria"));
        columnOpis.setCellValueFactory(new PropertyValueFactory<GbUserGrade, String>("opis"));
        columnDatawydarzenia.setCellValueFactory(new PropertyValueFactory<GbUserGrade, String>("datawydarzenia"));

        eventsTableView.setItems(data);

        if(Program.loggedPerms.equals("n"))
        {
            eventsTableView.getColumns().addAll(columnPrzedmiot, columnKlasa, columnKategoria, columnOpis, columnDatawydarzenia);
        }
        else
        {
            eventsTableView.getColumns().addAll(columnPrzedmiot, columnKategoria, columnOpis, columnDatawydarzenia);
        }
    }

    /**
     * ScheduleTable builder
     */
    private void buildScheduleTable() {
        String query;

        if(Program.loggedPerms.equals("n"))
        {
            query = "SELECT Godzina,(SELECT CONCAT(p.nazwa_przedmiotu,\", \", l.Sala,\", \", k.nazwa_klasy) FROM lekcje l, nauczyciele n, klasy k, przedmioty p WHERE l.ID_przedmiotu = p.ID_przedmiotu AND l.ID_nauczyciela = n.ID_nauczyciela AND l.ID_klasy = k.ID_klasy AND l.ID_nauczyciela = " + teacherID + "  AND l.ID_lekcji = pl.Poniedzialek),(SELECT CONCAT(p.nazwa_przedmiotu,\", \", l.Sala,\", \", k.nazwa_klasy) FROM lekcje l, nauczyciele n, klasy k, przedmioty p WHERE l.ID_przedmiotu = p.ID_przedmiotu AND l.ID_nauczyciela = n.ID_nauczyciela AND l.ID_klasy = k.ID_klasy AND l.ID_nauczyciela = " + teacherID + "  AND l.ID_lekcji = pl.Wtorek),(SELECT CONCAT(p.nazwa_przedmiotu,\", \", l.Sala,\", \", k.nazwa_klasy) FROM lekcje l, nauczyciele n, klasy k, przedmioty p WHERE l.ID_przedmiotu = p.ID_przedmiotu AND l.ID_nauczyciela = n.ID_nauczyciela AND l.ID_klasy = k.ID_klasy AND l.ID_nauczyciela = " + teacherID + "  AND l.ID_lekcji = pl.Sroda),(SELECT CONCAT(p.nazwa_przedmiotu,\", \", l.Sala,\", \", k.nazwa_klasy) FROM lekcje l, nauczyciele n, klasy k, przedmioty p WHERE l.ID_przedmiotu = p.ID_przedmiotu AND l.ID_nauczyciela = n.ID_nauczyciela AND l.ID_klasy = k.ID_klasy AND l.ID_nauczyciela = " + teacherID + "  AND l.ID_lekcji = pl.Czwartek),(SELECT CONCAT(p.nazwa_przedmiotu,\", \", l.Sala,\", \", k.nazwa_klasy) FROM lekcje l, nauczyciele n, klasy k, przedmioty p WHERE l.ID_przedmiotu = p.ID_przedmiotu AND l.ID_nauczyciela = n.ID_nauczyciela AND l.ID_klasy = k.ID_klasy AND l.ID_nauczyciela = " + teacherID + "  AND l.ID_lekcji = pl.Piatek) FROM plan_1a pl;";
        }
        else
        {
            query = "SELECT Godzina,(SELECT CONCAT(p.nazwa_przedmiotu, \", \", l.Sala, \", \",CONCAT((SELECT nazwisko FROM nauczyciele WHERE ID_nauczyciela = l.ID_nauczyciela),\" \",(SELECT imie FROM nauczyciele WHERE ID_nauczyciela = l.ID_nauczyciela))) FROM lekcje l, przedmioty p, nauczyciele n, klasy k WHERE l.ID_przedmiotu = p.ID_przedmiotu AND l.ID_nauczyciela = n.ID_nauczyciela AND l.ID_klasy = k.ID_klasy AND l.ID_klasy = '" + className + "' AND l.ID_lekcji = pl.Poniedzialek),(SELECT CONCAT(p.nazwa_przedmiotu, \", \", l.Sala, \", \",CONCAT((SELECT nazwisko FROM nauczyciele WHERE ID_nauczyciela = l.ID_nauczyciela),\" \",(SELECT imie FROM nauczyciele WHERE ID_nauczyciela = l.ID_nauczyciela))) FROM lekcje l, przedmioty p, nauczyciele n, klasy k WHERE l.ID_przedmiotu = p.ID_przedmiotu AND l.ID_nauczyciela = n.ID_nauczyciela AND l.ID_klasy = k.ID_klasy AND l.ID_klasy = '" + className + "' AND l.ID_lekcji = pl.Wtorek),(SELECT CONCAT(p.nazwa_przedmiotu, \", \", l.Sala, \", \",CONCAT((SELECT nazwisko FROM nauczyciele WHERE ID_nauczyciela = l.ID_nauczyciela),\" \",(SELECT imie FROM nauczyciele WHERE ID_nauczyciela = l.ID_nauczyciela))) FROM lekcje l, przedmioty p, nauczyciele n, klasy k WHERE l.ID_przedmiotu = p.ID_przedmiotu AND l.ID_nauczyciela = n.ID_nauczyciela AND l.ID_klasy = k.ID_klasy AND l.ID_klasy = '" + className + "' AND l.ID_lekcji = pl.Sroda),(SELECT CONCAT(p.nazwa_przedmiotu, \", \", l.Sala, \", \",CONCAT((SELECT nazwisko FROM nauczyciele WHERE ID_nauczyciela = l.ID_nauczyciela),\" \",(SELECT imie FROM nauczyciele WHERE ID_nauczyciela = l.ID_nauczyciela))) FROM lekcje l, przedmioty p, nauczyciele n, klasy k WHERE l.ID_przedmiotu = p.ID_przedmiotu AND l.ID_nauczyciela = n.ID_nauczyciela AND l.ID_klasy = k.ID_klasy AND l.ID_klasy = '" + className + "' AND l.ID_lekcji = pl.Czwartek),(SELECT CONCAT(p.nazwa_przedmiotu, \", \", l.Sala, \", \",CONCAT((SELECT nazwisko FROM nauczyciele WHERE ID_nauczyciela = l.ID_nauczyciela),\" \",(SELECT imie FROM nauczyciele WHERE ID_nauczyciela = l.ID_nauczyciela))) FROM lekcje l, przedmioty p, nauczyciele n, klasy k WHERE l.ID_przedmiotu = p.ID_przedmiotu AND l.ID_nauczyciela = n.ID_nauczyciela AND l.ID_klasy = k.ID_klasy AND l.ID_klasy = '" + className + "' AND l.ID_lekcji = pl.Piatek) FROM plan_1a pl;";
        }

        GbsMessage message = new GbsMessage();

        message.header = "_executeSelect";

        message.arguments.add(query);

        GbsMessage reply = null;

        try {
            reply = Program.socket.executeRequest(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<GbUserSchedule> replyArrayList = new ArrayList<>();

        for(String str : reply.arguments)
        {
            replyArrayList.add(new GbUserSchedule(str));
        }

        ObservableList<GbUserSchedule> data = FXCollections.observableArrayList(replyArrayList);

        scheduleTableView.getColumns().clear();

        TableColumn columnGodzina = new TableColumn("Przedmiot");
        TableColumn columnPoniedzialek = new TableColumn("Poniedziałek");
        TableColumn columnWtorek = new TableColumn("Wtorek");
        TableColumn columnSroda = new TableColumn("Środa");
        TableColumn columnCzwartek = new TableColumn("Czwartek");
        TableColumn columnPiatek = new TableColumn("Piątek");


        columnGodzina.setCellValueFactory(new PropertyValueFactory<GbUserSchedule, String>("godzina"));
        columnPoniedzialek.setCellValueFactory(new PropertyValueFactory<GbUserSchedule, String>("poniedzialek"));
        columnWtorek.setCellValueFactory(new PropertyValueFactory<GbUserSchedule, String>("wtorek"));
        columnSroda.setCellValueFactory(new PropertyValueFactory<GbUserSchedule, String>("sroda"));
        columnCzwartek.setCellValueFactory(new PropertyValueFactory<GbUserSchedule, String>("czwartek"));
        columnPiatek.setCellValueFactory(new PropertyValueFactory<GbUserSchedule, String>("piatek"));


        scheduleTableView.setItems(data);

        scheduleTableView.getColumns().addAll(columnGodzina, columnPoniedzialek, columnWtorek, columnSroda, columnCzwartek, columnPiatek);
    }

    //endregion

    /**
     * Function body for gradeClicked()
     */
    void gradeClickedFunc() {
        tablesVisibility(gradesTableView);

        buildGradesTable();
    }

    /**
     * Handler for mouse clicking on gradeImage
     *
     * @param event Mouse Event
     */
    @FXML
    void gradeClicked(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            gradeClickedFunc();
        }
    }

    /**
     * Handler for mouse clicking on attendanceImage
     *
     * @param event Mouse Event
     */
    @FXML
    void attendanceClicked(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            tablesVisibility(attendancesTableView);
            buildAttendancesTable();
        }
    }

    /**
     * Handler for mouse clicking on messagesImage
     *
     * @param event Mouse Event
     */
    @FXML
    void messagesClicked(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            tablesVisibility(messagesTableView);
            buildMessagesTable();
        }
    }

    /**
     * Handler for mouse clicking on remarksImage
     *
     * @param event Mouse Event
     */
    @FXML
    void remarksClicked(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            tablesVisibility(remarksTableView);
            buildRemarksTable();
        }
    }

    /**
     * Handler for mouse clicking on eventsImage
     *
     * @param event Mouse Event
     */
    @FXML
    void eventsClicked(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            tablesVisibility(eventsTableView);
            buildEventsTable();
        }
    }

    /**
     * Handler for mouse clicking on scheduleImage
     *
     * @param event Mouse Event
     */
    @FXML
    void scheduleClicked(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            tablesVisibility(scheduleTableView);
            buildScheduleTable();
        }
    }

    /**
     * Handler for mouse clicking on refreshImage
     *
     * @param event Mouse Event
     */
    @FXML
    void refreshClicked(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            buildGradesTable();
            buildAttendancesTable();
            buildMessagesTable();
            buildRemarksTable();
            buildEventsTable();
            buildScheduleTable();
        }
    }

    /**
     * Handler for mouse clicking on logoutImage
     *
     * @param event Mouse Event
     */
    @FXML
    void logoutClicked(MouseEvent event) throws IOException {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
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
