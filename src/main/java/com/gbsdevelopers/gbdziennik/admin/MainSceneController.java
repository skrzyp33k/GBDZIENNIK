package com.gbsdevelopers.gbdziennik.admin;

import com.gbsdevelopers.gbdziennik.Program;
import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.*;


public class MainSceneController implements Initializable {
    @FXML
    private TabPane mainTab;

    @FXML
    private Tab accountsTab;

    @FXML
    private TableView<GbAccount> accountsTable;

    private ArrayList<GbAccount> accountsArrayList;

    @FXML
    private Tab teachersTab;

    @FXML
    private TableView<GbTeacher> teachersTable;

    private ArrayList<GbTeacher> teachersArrayList;

    @FXML
    private Tab studentsTab;

    @FXML
    private TableView<GbStudent> studentsTable;

    private ArrayList<GbStudent> studentsArrayList;

    @FXML
    private Tab parentsTab;

    @FXML
    private TableView<GbParent> parentsTable;

    private ArrayList<GbParent> parentsArrayList;

    @FXML
    private Tab classesTab;

    @FXML
    private TableView<GbClass> classesTable;

    private ArrayList<GbClass> classesArrayList;

    @FXML
    private Tab coursesTab;

    @FXML
    private TableView<GbCourse> coursesTable;

    private ArrayList<GbCourse> coursesArrayList;

    @FXML
    private Tab lessonsTab;

    @FXML
    private TableView<GbLesson> lessonsTable;

    private ArrayList<GbLesson> lessonsArrayList;

    @FXML
    private Tab schedulesTab;

    @FXML
    private TabPane inSchedulesTab;

    private HashMap<String, Tab> tabMap;

    private HashMap<String, AnchorPane> anchorMap;

    @FXML
    private Tab eventsTab;

    @FXML
    private TableView<GbEvent> eventsTable;

    private ArrayList<GbEvent> eventsArrayList;

    @FXML
    private Tab gradesTab;

    @FXML
    private TableView<GbGrade> gradesTable;

    private ArrayList<GbGrade> gradeArrayList;

    @FXML
    private Tab attendanceTab;

    @FXML
    private TableView<GbAttendance> attendanceTable;

    private ArrayList<GbAttendance> attendancesArrayList;

    @FXML
    private Tab messagesTab;

    @FXML
    private TableView<GbMessage> messagesTable;

    private ArrayList<GbMessage> messagesArrayList;

    @FXML
    private Tab remarksTab;

    @FXML
    private TableView<GbRemark> remarksTable;

    private ArrayList<GbRemark> remarksArrayList;

    @FXML
    private Button addButton;

    @FXML
    private Button editButton;

    @FXML
    private Button removeButton;

    @FXML
    private Button refreshButton;

    @FXML
    void addButtonClick(ActionEvent event) {

    }

    @FXML
    void removeButtonClick(ActionEvent event) {

    }

    @FXML
    void editButtonClick(ActionEvent event) {

    }

    @FXML
    void refreshButtonClick(ActionEvent event) {
        this.buildSchedulesTab();
        this.buildAccountsTable();
        this.buildStudentsTable();
        this.buildParentsTable();
        this.buildTeachersTable();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        refreshButton.fire();
    }

    private void buildSchedulesTab() {
        GbsMessage reply = null;
        try {
            reply = Program.socket.executeRequest(new GbsMessage("_listClass", null));
        } catch (IOException e) {
            e.printStackTrace();
        }

        tabMap = new HashMap<String, Tab>();
        anchorMap = new HashMap<String, AnchorPane>();

        inSchedulesTab.getTabs().clear();

        for (String tabName : reply.arguments) {
            Tab newTab = new Tab(tabName);
            tabMap.put(tabName, newTab);
            inSchedulesTab.getTabs().add(tabMap.get(tabName));

            AnchorPane newAnchor = new AnchorPane();
            anchorMap.put(tabName, newAnchor);
        }
    }

    private void buildAccountsTable() {
        GbsMessage reply = null;
        try {
            reply = Program.socket.executeRequest(new GbsMessage("_listAccounts", null));
        } catch (IOException e) {
            e.printStackTrace();
        }

        accountsArrayList = new ArrayList<GbAccount>();

        for (String str : reply.arguments) {
            GbAccount acc = new GbAccount(str);
            accountsArrayList.add(acc);
        }

        ObservableList<GbAccount> data = FXCollections.observableArrayList(accountsArrayList);

        accountsTable.getColumns().clear();

        TableColumn columnIDKonta = new TableColumn("ID_Konta");
        TableColumn columnLogin = new TableColumn("Login");
        TableColumn columnHaslo = new TableColumn("Haslo");
        TableColumn columnUprawnienia = new TableColumn("Uprawnienia");

        columnIDKonta.setCellValueFactory(new PropertyValueFactory<GbAccount,String>("idkonta"));
        columnLogin.setCellValueFactory(new PropertyValueFactory<GbAccount,String>("login"));
        columnHaslo.setCellValueFactory(new PropertyValueFactory<GbAccount,String>("haslo"));
        columnUprawnienia.setCellValueFactory(new PropertyValueFactory<GbAccount,String>("uprawnienia"));

        accountsTable.setItems(data);

        accountsTable.getColumns().addAll(columnIDKonta, columnLogin, columnHaslo, columnUprawnienia);

    }

    private void buildTeachersTable() {

    }

    private void buildParentsTable() {

    }

    private void buildStudentsTable() {

    }

}
