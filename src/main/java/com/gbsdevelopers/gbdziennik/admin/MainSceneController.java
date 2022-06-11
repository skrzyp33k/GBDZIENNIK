package com.gbsdevelopers.gbdziennik.admin;

import com.gbsdevelopers.gbdziennik.Program;
import com.gbsdevelopers.gbdziennik.admin.datatypes.*;
import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Vector;

/**
 * Controller for AdminPanel
 */
public class MainSceneController implements Initializable {

    /**
     * Logger for log4j2
     */
    private static final Logger logger = LogManager.getLogger(MainSceneController.class);

    /**
     * TableView for accounts
     */
    @FXML
    private TableView<GbAccount> accountsTable;

    /**
     * TableView for teachers
     */
    @FXML
    private TableView<GbTeacher> teachersTable;

    /**
     * TableView for students
     */
    @FXML
    private TableView<GbStudent> studentsTable;

    /**
     * TableView for parents
     */
    @FXML
    private TableView<GbParent> parentsTable;

    /**
     * TableView for classes
     */
    @FXML
    private TableView<GbClass> classesTable;

    /**
     * TableView for courses
     */
    @FXML
    private TableView<GbCourse> coursesTable;

    /**
     * TableView for lessons
     */
    @FXML
    private TableView<GbLesson> lessonsTable;

    /**
     * TabPane for scedules tabs
     */
    @FXML
    private TabPane inSchedulesTab;

    /**
     * TableView for events
     */
    @FXML
    private TableView<GbEvent> eventsTable;

    /**
     * TableView for grades
     */
    @FXML
    private TableView<GbGrade> gradesTable;

    /**
     * TableView for attendances
     */
    @FXML
    private TableView<GbAttendance> attendancesTable;

    /**
     * TableView for messages
     */
    @FXML
    private TableView<GbMessage> messagesTable;

    /**
     * TableView for remarks
     */
    @FXML
    private TableView<GbRemark> remarksTable;

    /**
     * Button for refresh data
     */
    @FXML
    private Button refreshButton;

    /**
     * Handler for addClassButton
     */
    @FXML
    void addClassButtonClicked() {
        logger.info("Clicked addClassButton");

        try {
            Program.showStage("admin/addClassScene.fxml", "Dodawanie klasy");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handler for removeClassButton
     */
    @FXML
    void removeClassButtonClicked() {
        logger.info("Clicked removeClassButton");

        try {
            Program.showStage("admin/removeClassScene.fxml", "Usuwanie klasy");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handler for addStudentButton
     */
    @FXML
    void addStudentButtonClicked() {
        logger.info("Clicked addStudentButton");

        try {
            Program.showStage("admin/addStudentScene.fxml", "Dodawanie ucznia");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handler for removeStudentButton
     */
    @FXML
    void removeStudentButtonClicked() {
        logger.info("Clicked removeStudentButton");

        try {
            Program.showStage("admin/removeStudentScene.fxml", "Usuwanie ucznia");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handler for addTeacherButton
     */
    @FXML
    void addTeacherButtonClicked() {
        logger.info("Clicked addTeacherButton");

        try {
            Program.showStage("admin/addTeacherScene.fxml", "Dodawanie nauczyciela");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handler for removeTeacherButton
     */
    @FXML
    void removeTeacherButtonClicked() {
        logger.info("Clicked removeTeacherButton");

        try {
            Program.showStage("admin/removeTeacherScene.fxml", "Usuwanie nauczyciela");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handler for addCourseButton
     */
    @FXML
    void addCourseButtonClicked() {
        logger.info("Clicked addCourseButton");

        try {
            Program.showStage("admin/addCourseScene.fxml", "Dodawanie przedmiotu");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handler for addLessonButton
     */
    @FXML
    void addLessonButtonClicked() {
        logger.info("Clicked addLessonButton");

        try {
            Program.showStage("admin/addLessonScene.fxml", "Dodawanie lekcji");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handler for changeAttendanceButton
     */
    @FXML
    void changeAttendanceButtonClicked() {
        logger.info("Clicked changeAttendanceButton");

        try {
            Program.showStage("admin/changeAttendanceScene.fxml", "Zmiana frekwencji");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handler for refreshButton
     */
    @FXML
    void refreshButtonClick() {
        logger.info("Clicked refreshButton");

        this.buildSchedulesTabs();
        this.buildAccountsTable();
        this.buildStudentsTable();
        this.buildParentsTable();
        this.buildTeachersTable();
        this.buildClassesTable();
        this.buildCoursesTable();
        this.buildLessonsTable();
        this.buildEventsTable();
        this.buildGradesTable();
        this.buildAttendancesTable();
        this.buildMessagesTable();
        this.buildRemarksTable();
    }

    /**
     * Handler for manualQueryButton
     */
    @FXML
    void manualQueryButtonClick() {
        logger.info("Clicked manualQueryButton");

        try {
            Program.showStage("admin/manualQueryScene.fxml", "Ręczne polecenie");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handler for logoutButton
     */
    @FXML
    void logoutButtonClick(ActionEvent event) {
        logger.info("Clicked logoutButton");

        try {
            Program.showStage("loginScene.fxml", "Zaloguj się!",1280,720);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ((Stage) (((Node) event.getSource()).getScene().getWindow())).close();
    }

    /**
     * Initialize window.
     *
     * @param url            URL location.
     * @param resourceBundle Resource bundle.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logger.info("Window initialized");
        refreshButton.fire();
    }

    /**
     * Generate Schedules Tabs
     */
    private void buildSchedulesTabs() {
        GbsMessage reply = null;
        try {
            reply = Program.socket.executeRequest(new GbsMessage("_listSchedulesTables", null));
        } catch (IOException e) {
            e.printStackTrace();
        }

        inSchedulesTab.getTabs().clear();

        assert reply != null;
        for (String tabName : reply.arguments) {
            Tab newTab = new Tab(tabName);

            AnchorPane newAnchor = new AnchorPane();

            TableView newTableView = new TableView();

            newTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            newTableView.setPrefSize(1280, 618);

            try {
                Vector<String> tableName = new Vector<>();
                tableName.add(tabName);
                reply = Program.socket.executeRequest(new GbsMessage("_listSchedule", tableName));
            } catch (IOException e) {
                e.printStackTrace();
            }

            ArrayList<GbSchedule> scheduleArrayList = new ArrayList<>();

            for (String str : reply.arguments) {
                scheduleArrayList.add(new GbSchedule(str));
            }

            ObservableList<GbSchedule> data = FXCollections.observableArrayList(scheduleArrayList);

            TableColumn columnGodzina = new TableColumn("Godzina");
            TableColumn columnPoniedzialek = new TableColumn("Poniedzialek");
            TableColumn columnWtorek = new TableColumn("Wtorek");
            TableColumn columnSroda = new TableColumn("Sroda");
            TableColumn columnCzwartek = new TableColumn("Czwartek");
            TableColumn columnPiatek = new TableColumn("Piatek");

            columnGodzina.setCellValueFactory(new PropertyValueFactory<GbSchedule, String>("godzina"));
            columnPoniedzialek.setCellValueFactory(new PropertyValueFactory<GbSchedule, String>("poniedzialek"));
            columnWtorek.setCellValueFactory(new PropertyValueFactory<GbSchedule, String>("wtorek"));
            columnSroda.setCellValueFactory(new PropertyValueFactory<GbSchedule, String>("sroda"));
            columnCzwartek.setCellValueFactory(new PropertyValueFactory<GbSchedule, String>("czwartek"));
            columnPiatek.setCellValueFactory(new PropertyValueFactory<GbSchedule, String>("piatek"));

            newTableView.setItems(data);

            newTableView.getColumns().addAll(columnGodzina, columnPoniedzialek, columnWtorek, columnSroda, columnCzwartek, columnPiatek);

            newAnchor.getChildren().add(newTableView);

            newTab.setContent(newAnchor);

            inSchedulesTab.getTabs().add(newTab);

        }
    }

    /**
     * Generate Accounts Tab
     */
    private void buildAccountsTable() {
        GbsMessage reply = null;
        try {
            reply = Program.socket.executeRequest(new GbsMessage("_listAccounts", null));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<GbAccount> accountsArrayList = new ArrayList<>();

        assert reply != null;
        for (String str : reply.arguments) {
            accountsArrayList.add(new GbAccount(str));
        }

        ObservableList<GbAccount> data = FXCollections.observableArrayList(accountsArrayList);

        accountsTable.getColumns().clear();

        TableColumn columnIDKonta = new TableColumn("ID_konta");
        TableColumn columnLogin = new TableColumn("Login");
        TableColumn columnHaslo = new TableColumn("Haslo");
        TableColumn columnUprawnienia = new TableColumn("Uprawnienia");

        columnIDKonta.setCellValueFactory(new PropertyValueFactory<GbAccount, String>("idkonta"));
        columnLogin.setCellValueFactory(new PropertyValueFactory<GbAccount, String>("login"));
        columnHaslo.setCellValueFactory(new PropertyValueFactory<GbAccount, String>("haslo"));
        columnUprawnienia.setCellValueFactory(new PropertyValueFactory<GbAccount, String>("uprawnienia"));

        accountsTable.setItems(data);

        accountsTable.getColumns().addAll(columnIDKonta, columnLogin, columnHaslo, columnUprawnienia);

    }

    /**
     * Generate Teachers Tab
     */
    private void buildTeachersTable() {
        GbsMessage reply = null;
        try {
            reply = Program.socket.executeRequest(new GbsMessage("_listTeachers", null));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<GbTeacher> teachersArrayList = new ArrayList<>();

        assert reply != null;
        for (String str : reply.arguments) {
            teachersArrayList.add(new GbTeacher(str));
        }

        ObservableList<GbTeacher> data = FXCollections.observableArrayList(teachersArrayList);

        teachersTable.getColumns().clear();

        TableColumn columnIDNauczyciela = new TableColumn("ID_nauczyciela");
        TableColumn columnImie = new TableColumn("imie");
        TableColumn columnNazwisko = new TableColumn("nazwisko");
        TableColumn columnTelefonkontaktowy = new TableColumn("telefon_kontaktowy");
        TableColumn columnIDKonta = new TableColumn("ID_konta");

        columnIDNauczyciela.setCellValueFactory(new PropertyValueFactory<GbTeacher, String>("idnauczyciela"));
        columnImie.setCellValueFactory(new PropertyValueFactory<GbTeacher, String>("imie"));
        columnNazwisko.setCellValueFactory(new PropertyValueFactory<GbTeacher, String>("nazwisko"));
        columnTelefonkontaktowy.setCellValueFactory(new PropertyValueFactory<GbTeacher, String>("telefonkontaktowy"));
        columnIDKonta.setCellValueFactory(new PropertyValueFactory<GbTeacher, String>("idkonta"));

        teachersTable.setItems(data);

        teachersTable.getColumns().addAll(columnIDNauczyciela, columnImie, columnNazwisko, columnTelefonkontaktowy, columnIDKonta);
    }

    /**
     * Generate Parents Tab
     */
    private void buildParentsTable() {
        GbsMessage reply = null;
        try {
            reply = Program.socket.executeRequest(new GbsMessage("_listParents", null));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<GbParent> parentsArrayList = new ArrayList<>();

        assert reply != null;
        for (String str : reply.arguments) {
            parentsArrayList.add(new GbParent(str));
        }

        ObservableList<GbParent> data = FXCollections.observableArrayList(parentsArrayList);

        parentsTable.getColumns().clear();

        TableColumn columnIDRodzica = new TableColumn("ID_rodzica");
        TableColumn columnImie = new TableColumn("imie");
        TableColumn columnNazwisko = new TableColumn("nazwisko");
        TableColumn columnIDKonta = new TableColumn("ID_konta");

        columnIDRodzica.setCellValueFactory(new PropertyValueFactory<GbParent, String>("idrodzica"));
        columnImie.setCellValueFactory(new PropertyValueFactory<GbParent, String>("imie"));
        columnNazwisko.setCellValueFactory(new PropertyValueFactory<GbParent, String>("nazwisko"));
        columnIDKonta.setCellValueFactory(new PropertyValueFactory<GbParent, String>("idkonta"));

        parentsTable.setItems(data);

        parentsTable.getColumns().addAll(columnIDRodzica, columnImie, columnNazwisko, columnIDKonta);
    }

    /**
     * Generate Students Tab
     */
    private void buildStudentsTable() {
        GbsMessage reply = null;
        try {
            reply = Program.socket.executeRequest(new GbsMessage("_listStudents", null));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<GbStudent> studentsArrayList = new ArrayList<>();

        assert reply != null;
        for (String str : reply.arguments) {
            studentsArrayList.add(new GbStudent(str));
        }

        ObservableList<GbStudent> data = FXCollections.observableArrayList(studentsArrayList);

        studentsTable.getColumns().clear();

        TableColumn columnIDucznia = new TableColumn("ID_ucznia");
        TableColumn columnImie = new TableColumn("imie");
        TableColumn columnNazwisko = new TableColumn("nazwisko");
        TableColumn columnIDrodzica = new TableColumn("ID_rodzica");
        TableColumn columnIDklasy = new TableColumn("ID_klasy");
        TableColumn columnIDkonta = new TableColumn("ID_konta");

        columnIDucznia.setCellValueFactory(new PropertyValueFactory<GbStudent, String>("idrodzica"));
        columnImie.setCellValueFactory(new PropertyValueFactory<GbStudent, String>("imie"));
        columnNazwisko.setCellValueFactory(new PropertyValueFactory<GbStudent, String>("nazwisko"));
        columnIDrodzica.setCellValueFactory(new PropertyValueFactory<GbStudent, String>("idrodzica"));
        columnIDklasy.setCellValueFactory(new PropertyValueFactory<GbStudent, String>("idklasy"));
        columnIDkonta.setCellValueFactory(new PropertyValueFactory<GbStudent, String>("idkonta"));

        studentsTable.setItems(data);

        studentsTable.getColumns().addAll(columnIDucznia, columnImie, columnNazwisko, columnIDrodzica, columnIDklasy, columnIDkonta);
    }

    /**
     * Generate Classes Tab
     */
    private void buildClassesTable() {
        GbsMessage reply = null;
        try {
            reply = Program.socket.executeRequest(new GbsMessage("_listClasses", null));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<GbClass> classesArrayList = new ArrayList<>();

        assert reply != null;
        for (String str : reply.arguments) {
            classesArrayList.add(new GbClass(str));
        }

        ObservableList<GbClass> data = FXCollections.observableArrayList(classesArrayList);

        classesTable.getColumns().clear();

        TableColumn columnIDklasy = new TableColumn("ID_klasy");
        TableColumn columnNazwaklasy = new TableColumn("nazwa_klasy");
        TableColumn columnIDnauczyciela = new TableColumn("ID_nauczyciela");


        columnIDklasy.setCellValueFactory(new PropertyValueFactory<GbClass, String>("idklasy"));
        columnNazwaklasy.setCellValueFactory(new PropertyValueFactory<GbClass, String>("nazwaklasy"));
        columnIDnauczyciela.setCellValueFactory(new PropertyValueFactory<GbClass, String>("idnauczyciela"));

        classesTable.setItems(data);

        classesTable.getColumns().addAll(columnIDklasy, columnNazwaklasy, columnIDnauczyciela);
    }

    /**
     * Generate Courses Tab
     */
    private void buildCoursesTable() {
        GbsMessage reply = null;
        try {
            reply = Program.socket.executeRequest(new GbsMessage("_listCourses", null));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<GbCourse> coursesArrayList = new ArrayList<>();

        assert reply != null;
        for (String str : reply.arguments) {
            coursesArrayList.add(new GbCourse(str));
        }

        ObservableList<GbCourse> data = FXCollections.observableArrayList(coursesArrayList);

        coursesTable.getColumns().clear();

        TableColumn columnIDprzedmiotu = new TableColumn("ID_przedmiotu");
        TableColumn columnNazwaprzedmiotu = new TableColumn("nazwa_przedmiotu");
        TableColumn columnOpis = new TableColumn("opis");


        columnIDprzedmiotu.setCellValueFactory(new PropertyValueFactory<GbCourse, String>("idprzedmiotu"));
        columnNazwaprzedmiotu.setCellValueFactory(new PropertyValueFactory<GbCourse, String>("nazwaprzedmiotu"));
        columnOpis.setCellValueFactory(new PropertyValueFactory<GbCourse, String>("opis"));

        coursesTable.setItems(data);

        coursesTable.getColumns().addAll(columnIDprzedmiotu, columnNazwaprzedmiotu, columnOpis);
    }

    /**
     * Generate Lessons Tab
     */
    private void buildLessonsTable() {
        GbsMessage reply = null;
        try {
            reply = Program.socket.executeRequest(new GbsMessage("_listLessons", null));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<GbLesson> lessonsArrayList = new ArrayList<>();

        assert reply != null;
        for (String str : reply.arguments) {
            lessonsArrayList.add(new GbLesson(str));
        }

        ObservableList<GbLesson> data = FXCollections.observableArrayList(lessonsArrayList);

        lessonsTable.getColumns().clear();

        TableColumn columnIDlekcji = new TableColumn("ID_lekcji");
        TableColumn columnIDprzedmiotu = new TableColumn("ID_przedmiotu");
        TableColumn columnSala = new TableColumn("Sala");
        TableColumn columnIDnauczyciela = new TableColumn("ID_nauczyciela");
        TableColumn columnIDklasy = new TableColumn("ID_klasy");


        columnIDlekcji.setCellValueFactory(new PropertyValueFactory<GbLesson, String>("idlekcji"));
        columnIDprzedmiotu.setCellValueFactory(new PropertyValueFactory<GbLesson, String>("idprzedmiotu"));
        columnSala.setCellValueFactory(new PropertyValueFactory<GbLesson, String>("sala"));
        columnIDnauczyciela.setCellValueFactory(new PropertyValueFactory<GbLesson, String>("idnauczyciela"));
        columnIDklasy.setCellValueFactory(new PropertyValueFactory<GbLesson, String>("idklasy"));

        lessonsTable.setItems(data);

        lessonsTable.getColumns().addAll(columnIDlekcji, columnIDprzedmiotu, columnSala, columnIDnauczyciela, columnIDklasy);
    }

    /**
     * Generate Events Tab
     */
    private void buildEventsTable() {
        GbsMessage reply = null;
        try {
            reply = Program.socket.executeRequest(new GbsMessage("_listEvents", null));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<GbEvent> eventsArrayList = new ArrayList<>();

        assert reply != null;
        for (String str : reply.arguments) {
            eventsArrayList.add(new GbEvent(str));
        }


        ObservableList<GbEvent> data = FXCollections.observableArrayList(eventsArrayList);

        eventsTable.getColumns().clear();

        TableColumn columnIDwydarzenia = new TableColumn("ID_wydarzenia");
        TableColumn columnKategoria = new TableColumn("Kategoria");
        TableColumn columnOpis = new TableColumn("Opis");
        TableColumn columnIDlekcji = new TableColumn("ID_lekcji");
        TableColumn columnDatawydarzenia = new TableColumn("data_wydarzenia");


        columnIDwydarzenia.setCellValueFactory(new PropertyValueFactory<GbEvent, String>("idwydarzenia"));
        columnKategoria.setCellValueFactory(new PropertyValueFactory<GbEvent, String>("kategoria"));
        columnOpis.setCellValueFactory(new PropertyValueFactory<GbEvent, String>("opis"));
        columnIDlekcji.setCellValueFactory(new PropertyValueFactory<GbEvent, String>("idlekcji"));
        columnDatawydarzenia.setCellValueFactory(new PropertyValueFactory<GbEvent, String>("datawydarzenia"));

        if (!(reply.arguments.isEmpty())) {
            eventsTable.setItems(data);
        }

        eventsTable.getColumns().addAll(columnIDwydarzenia, columnKategoria, columnOpis, columnIDlekcji, columnDatawydarzenia);
    }

    /**
     * Generate Grades Tab
     */
    private void buildGradesTable() {
        GbsMessage reply = null;
        try {
            reply = Program.socket.executeRequest(new GbsMessage("_listGrades", null));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<GbGrade> gradesArrayList = new ArrayList<>();

        assert reply != null;
        for (String str : reply.arguments) {
            gradesArrayList.add(new GbGrade(str));
        }

        ObservableList<GbGrade> data = FXCollections.observableArrayList(gradesArrayList);

        gradesTable.getColumns().clear();

        TableColumn columnIDoceny = new TableColumn("ID_oceny");
        TableColumn columnOcena = new TableColumn("Ocena");
        TableColumn columnWaga = new TableColumn("Waga");
        TableColumn columnOpis = new TableColumn("Opis");
        TableColumn columnIDucznia = new TableColumn("ID_ucznia");
        TableColumn columnIDnauczyciela = new TableColumn("ID_nauczyciela");
        TableColumn columnIDprzedmiotu = new TableColumn("ID_przedmiotu");
        TableColumn columnDatawystawienia = new TableColumn("data_wystawienia");


        columnIDoceny.setCellValueFactory(new PropertyValueFactory<GbGrade, String>("idoceny"));
        columnOcena.setCellValueFactory(new PropertyValueFactory<GbGrade, String>("ocena"));
        columnWaga.setCellValueFactory(new PropertyValueFactory<GbGrade, String>("waga"));
        columnOpis.setCellValueFactory(new PropertyValueFactory<GbGrade, String>("opis"));
        columnIDucznia.setCellValueFactory(new PropertyValueFactory<GbGrade, String>("iducznia"));
        columnIDnauczyciela.setCellValueFactory(new PropertyValueFactory<GbGrade, String>("idnauczyciela"));
        columnIDprzedmiotu.setCellValueFactory(new PropertyValueFactory<GbGrade, String>("idprzedmiotu"));
        columnDatawystawienia.setCellValueFactory(new PropertyValueFactory<GbGrade, String>("datawystawienia"));

        gradesTable.setItems(data);

        gradesTable.getColumns().addAll(columnIDoceny, columnOcena, columnWaga, columnOpis, columnIDucznia, columnIDnauczyciela, columnIDprzedmiotu, columnDatawystawienia);
    }

    /**
     * Generate Attendances Tab
     */
    private void buildAttendancesTable() {
        GbsMessage reply = null;
        try {
            reply = Program.socket.executeRequest(new GbsMessage("_listAttendances", null));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<GbAttendance> attendancesArrayList = new ArrayList<>();

        assert reply != null;
        for (String str : reply.arguments) {
            attendancesArrayList.add(new GbAttendance(str));
        }

        ObservableList<GbAttendance> data = FXCollections.observableArrayList(attendancesArrayList);

        attendancesTable.getColumns().clear();

        TableColumn columnIDnieobecnosci = new TableColumn("ID_nieobecnosci");
        TableColumn columnIDucznia = new TableColumn("ID_ucznia");
        TableColumn columnIDlekcji = new TableColumn("ID_lekcji");
        TableColumn columnDatanieobecnosci = new TableColumn("data_nieobecnosci");
        TableColumn columnTyp = new TableColumn("TYP");

        columnIDnieobecnosci.setCellValueFactory(new PropertyValueFactory<GbAttendance, String>("idnieobecnosci"));
        columnIDucznia.setCellValueFactory(new PropertyValueFactory<GbAttendance, String>("iducznia"));
        columnIDlekcji.setCellValueFactory(new PropertyValueFactory<GbAttendance, String>("idlekcji"));
        columnDatanieobecnosci.setCellValueFactory(new PropertyValueFactory<GbAttendance, String>("datanieobecnosci"));
        columnTyp.setCellValueFactory(new PropertyValueFactory<GbAttendance, String>("typ"));

        attendancesTable.setItems(data);

        attendancesTable.getColumns().addAll(columnIDnieobecnosci, columnIDucznia, columnIDlekcji, columnDatanieobecnosci, columnTyp);
    }

    /**
     * Generate Messages Tab
     */
    private void buildMessagesTable() {
        GbsMessage reply = null;
        try {
            reply = Program.socket.executeRequest(new GbsMessage("_listMessages", null));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<GbMessage> messagesArrayList = new ArrayList<>();

        assert reply != null;
        for (String str : reply.arguments) {
            messagesArrayList.add(new GbMessage(str));
        }

        ObservableList<GbMessage> data = FXCollections.observableArrayList(messagesArrayList);

        messagesTable.getColumns().clear();

        TableColumn columnIDwiadomosci = new TableColumn("ID_wiadomosci");
        TableColumn columnWiadomosc = new TableColumn("Wiadomosc");
        TableColumn columnIDnadawcy = new TableColumn("ID_nadawcy");
        TableColumn columnIDodbiorcy = new TableColumn("ID_odbiorcy");
        TableColumn columnDatawyslania = new TableColumn("data_wyslania");


        columnIDwiadomosci.setCellValueFactory(new PropertyValueFactory<GbMessage, String>("idwiadomosci"));
        columnWiadomosc.setCellValueFactory(new PropertyValueFactory<GbMessage, String>("wiadomosc"));
        columnIDnadawcy.setCellValueFactory(new PropertyValueFactory<GbMessage, String>("idnadawcy"));
        columnIDodbiorcy.setCellValueFactory(new PropertyValueFactory<GbMessage, String>("idodbiorcy"));
        columnDatawyslania.setCellValueFactory(new PropertyValueFactory<GbMessage, String>("datawyslania"));

        messagesTable.setItems(data);

        messagesTable.getColumns().addAll(columnIDwiadomosci, columnWiadomosc, columnIDnadawcy, columnIDodbiorcy, columnDatawyslania);
    }

    /**
     * Generate Remarks Tab
     */
    private void buildRemarksTable() {
        GbsMessage reply = null;
        try {
            reply = Program.socket.executeRequest(new GbsMessage("_listRemarks", null));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<GbRemark> remarksArrayList = new ArrayList<>();

        assert reply != null;
        for (String str : reply.arguments) {
            remarksArrayList.add(new GbRemark(str));
        }

        ObservableList<GbRemark> data = FXCollections.observableArrayList(remarksArrayList);

        remarksTable.getColumns().clear();

        TableColumn columnIDuwagi = new TableColumn("ID_uwagi");
        TableColumn columnTresc = new TableColumn("Tresc");
        TableColumn columnIDnauczyciela = new TableColumn("ID_nauczyciela");
        TableColumn columnIDucznia = new TableColumn("ID_ucznia");
        TableColumn columnDatawystawienia = new TableColumn("data_wystawienia");


        columnIDuwagi.setCellValueFactory(new PropertyValueFactory<GbRemark, String>("iduwagi"));
        columnTresc.setCellValueFactory(new PropertyValueFactory<GbRemark, String>("tresc"));
        columnIDnauczyciela.setCellValueFactory(new PropertyValueFactory<GbRemark, String>("idnauczyciela"));
        columnIDucznia.setCellValueFactory(new PropertyValueFactory<GbRemark, String>("iducznia"));
        columnDatawystawienia.setCellValueFactory(new PropertyValueFactory<GbRemark, String>("datawystawienia"));

        remarksTable.setItems(data);

        remarksTable.getColumns().addAll(columnIDuwagi, columnTresc, columnIDnauczyciela, columnIDucznia, columnDatawystawienia);
    }

}
