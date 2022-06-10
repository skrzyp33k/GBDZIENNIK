package com.gbsdevelopers.gbdziennik.user.datatypes;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

/**
 * Class for wiadomosci for user space
 */
public class GbUserMessage {
    /**
     * Nadawca field
     */
    private final SimpleStringProperty nadawca;

    /**
     * Wiadomosc field
     */
    private final SimpleStringProperty wiadomosc;

    /**
     * Data wyslania field
     */
    private final SimpleStringProperty data;

    /**
     * Constructor that construct object from row data merged into one string
     *
     * @param str Data merged into one string
     */
    public GbUserMessage(String str)
    {
        Vector<String> fields = GbsMessage.explode(str,";");

        nadawca = new SimpleStringProperty(fields.get(0));
        wiadomosc = new SimpleStringProperty(fields.get(1));
        data = new SimpleStringProperty(fields.get(2));
    }

    /**
     * Getter for nadawca
     * @return value
     */
    public String getNadawca() {
        return nadawca.get();
    }

    /**
     * Setter for nadawca
     * @param value value
     */
    public void setNadawca(String value) {
        this.nadawca.set(value);
    }

    /**
     * Getter for wiadomosc
     * @return value
     */
    public String getWiadomosc() {
        return wiadomosc.get();
    }

    /**
     * Setter for wiadomosc
     * @param value value
     */
    public void setWiadomosc(String value) {
        this.wiadomosc.set(value);
    }

    /**
     * Getter for data
     * @return value
     */
    public String getData() {
        return data.get();
    }

    /**
     * Setter for data
     * @param value value
     */
    public void setData(String value) {
        this.data.set(value);
    }
}
