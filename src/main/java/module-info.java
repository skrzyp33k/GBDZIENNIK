module com.gbsdevelopers.gbdziennik {
    requires javafx.controls;
    requires javafx.fxml;

    requires javafx.graphics;
    requires javafx.base;
    requires org.json;
    requires GbsClient;
    requires org.apache.logging.log4j.core;
    requires org.apache.logging.log4j;
    requires org.testng;

    opens com.gbsdevelopers.gbdziennik to javafx.fxml;
    exports com.gbsdevelopers.gbdziennik;

    opens com.gbsdevelopers.gbdziennik.admin to javafx.fxml;
    exports com.gbsdevelopers.gbdziennik.admin;

    opens com.gbsdevelopers.gbdziennik.user to javafx.fxml;
    exports com.gbsdevelopers.gbdziennik.user;

    exports com.gbsdevelopers.gbdziennik.admin.datatypes;
    opens com.gbsdevelopers.gbdziennik.admin.datatypes to javafx.fxml, com.gbsdevelopers.gbdziennik.admin;

    exports com.gbsdevelopers.gbdziennik.user.datatypes;
    opens com.gbsdevelopers.gbdziennik.user.datatypes to javafx.fxml, com.gbsdevelopers.gbdziennik.user;

}