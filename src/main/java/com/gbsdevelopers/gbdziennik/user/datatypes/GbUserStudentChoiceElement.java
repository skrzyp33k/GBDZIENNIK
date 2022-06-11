package com.gbsdevelopers.gbdziennik.user.datatypes;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

/**
 * Class for Student elements for ChoiceBox
 */
public class GbUserStudentChoiceElement {
    /**
     * ID ucznia field
     */
    private SimpleStringProperty iducznia;

    /**
     * Dane field
     */
    private SimpleStringProperty dane;

    /**
     * Constructor that construct object from row data merged into one string
     *
     * @param str Data merged into one string
     */
    public GbUserStudentChoiceElement(String str)
    {
        Vector<String> fields = GbsMessage.explode(str,";");

        iducznia = new SimpleStringProperty(fields.get(0));
        dane = new SimpleStringProperty(fields.get(1));
    }

    /**
     * Getter for ID ucznia
     * @return value
     */
    public String getIducznia() {
        return iducznia.get();
    }

    /**
     * Setter for ID ucznia
     * @param value value
     */
    public void setIducznia(String value) {
        this.iducznia.set(value);
    }

    /**
     * Getter for Dane
     * @return value
     */
    public String getDane() {
        return dane.get();
    }

    /**
     * Setter for Dane
     * @param value value
     */
    public void setDane(String value) {
        this.dane.set(value);
    }

    /**
     * Provides text to ChoiceBox
     * @return dane
     */
    @Override
    public String toString()
    {
        return dane.get();
    }
}
