package com.gbsdevelopers.gbdziennik;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Simple alert box.
 */
public class AlertBox {

    /**
     * Logger for log4j2
     */
    private static final Logger logger = LogManager.getLogger(AlertBox.class);

    /**
     * Shows simple alert box.
     *
     * @param infoMessage Message.
     * @param titleBar    Title.
     */
    public static void show(String infoMessage, String titleBar) {
        show(infoMessage, titleBar, null);
    }

    /**
     * Shows simple alert box.
     *
     * @param infoMessage   Message.
     * @param titleBar      Title.
     * @param headerMessage Header.
     */
    public static void show(String infoMessage, String titleBar, String headerMessage) {

        logger.warn("Alert box showed!");
        logger.warn("Message: "+ infoMessage);

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }
}
