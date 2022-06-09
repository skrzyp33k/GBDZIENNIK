module com.gbsdevelopers.gbdziennik {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires org.json;
    requires GbsClient;

    opens com.gbsdevelopers.gbdziennik to javafx.fxml;
    exports com.gbsdevelopers.gbdziennik;

    opens com.gbsdevelopers.gbdziennik.admin to javafx.fxml;
    exports com.gbsdevelopers.gbdziennik.admin;

    opens com.gbsdevelopers.gbdziennik.student to javafx.fxml;
    exports com.gbsdevelopers.gbdziennik.student;

    opens com.gbsdevelopers.gbdziennik.parent to javafx.fxml;
    exports com.gbsdevelopers.gbdziennik.parent;

    opens com.gbsdevelopers.gbdziennik.teacher to javafx.fxml;
    exports com.gbsdevelopers.gbdziennik.teacher;
}