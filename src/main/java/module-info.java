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
}