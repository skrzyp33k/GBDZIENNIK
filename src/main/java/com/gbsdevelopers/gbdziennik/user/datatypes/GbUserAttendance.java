package com.gbsdevelopers.gbdziennik.user.datatypes;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

/**
 * Class for nieobecnosci for user space
 */
public class GbUserAttendance {
    /**
     * Uczen field
     */
    private final SimpleStringProperty uczen;

    /**
     * Przedmiot field
     */
    private final SimpleStringProperty przedmiot;

    /**
     * Data field
     */
    private final SimpleStringProperty data;

    /**
     * Typ field
     */
    private final SimpleStringProperty typ;

    /**
     * Constructor that construct object from row data merged into one string
     *
     * @param str Data merged into one string
     */
    public GbUserAttendance(String str) {
        Vector<String> fields = GbsMessage.explode(str,";");

        uczen = new SimpleStringProperty(fields.get(0));
        przedmiot = new SimpleStringProperty(fields.get(1));
        data = new SimpleStringProperty(fields.get(2));
        typ = new SimpleStringProperty(fields.get(3));
    }
    /**
     * Getter for Uczen
     * @return value
     */
    public String getUczen() {
        return uczen.get();
    }

    /**
     * Getter for przedmiot
     * @return value
     */
    public String getPrzedmiot() {
        return przedmiot.get();
    }

    /**
     * Setter for przedmiot
     * @param value value
     */
    public void setPrzedmiot(String value) {
        this.przedmiot.set(value);
    }

    /**
     * Getter for data
     * @return value
     */
    public String getData() {
        return data.get();
    }

    /**
     * Setter for Uczen
     * @param value value
     */
    public void setUczen(String value) {
        this.uczen.set(value);
    }

    /**
     * Setter for data
     * @param value value
     */
    public void setData(String value) {
        this.data.set(value);
    }

    /**
     * Getter for typ
     * @return value
     */
    public String getTyp() {
        return typ.get();
    }

    /**
     * Setter for typ
     * @param value value
     */
    public void setTyp(String value) {
        this.typ.set(value);
    }
}
