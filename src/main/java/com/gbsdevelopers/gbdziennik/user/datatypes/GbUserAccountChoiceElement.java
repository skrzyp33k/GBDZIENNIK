package com.gbsdevelopers.gbdziennik.user.datatypes;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

/**
 * Class for Account elements for ChoiceBox
 */
public class GbUserAccountChoiceElement {

    /**
     * ID konta field
     */
    private SimpleStringProperty idkonta;

    /**
     * Imię i nazwisko field
     */
    private SimpleStringProperty dane;

    /**
     * Constructor that construct object from row data merged into one string
     *
     * @param str Data merged into one string
     */
    public GbUserAccountChoiceElement(String str)
    {
        Vector<String> fields = GbsMessage.explode(str,";");

        idkonta = new SimpleStringProperty(fields.get(0));
        dane = new SimpleStringProperty(fields.get(1));
    }

    /**
     * Getter for ID konta
     * @return value(String)
     */
    public String getIdkonta() {
        return idkonta.get();
    }

    /**
     * Setter for ID konta
     * @param value value
     */
    public void setIdkonta(String value) {
        this.idkonta.set(value);
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
