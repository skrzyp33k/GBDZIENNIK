package com.gbsdevelopers.gbdziennik;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Simple alert box.
 */
public class AlertBox {
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
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }
}
