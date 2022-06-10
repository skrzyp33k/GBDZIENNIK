package com.gbsdevelopers.gbdziennik.user.datatypes;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

/**
 * Class for uwagi for user space
 */
public class GbUserRemark {
    /**
     * Osoba field
     */
    private final SimpleStringProperty osoba;

    /**
     * Tresc field
     */
    private final SimpleStringProperty tresc;

    /**
     * Data field
     */
    private final SimpleStringProperty data;

    /**
     * Constructor that construct object from row data merged into one string
     *
     * @param str Data merged into one string
     */
    public GbUserRemark(String str) {
        Vector<String> fields = GbsMessage.explode(str, ";");

        osoba = new SimpleStringProperty(fields.get(0));
        tresc = new SimpleStringProperty(fields.get(1));
        data = new SimpleStringProperty(fields.get(2));
    }

    /**
     * Getter for osoba
     *
     * @return value
     */
    public String getOsoba() {
        return osoba.get();
    }

    /**
     * Setter for osoba
     *
     * @param value value
     */
    public void setOsoba(String value) {
        this.osoba.set(value);
    }

    /**
     * Getter for tresc
     *
     * @return value
     */
    public String getTresc() {
        return tresc.get();
    }

    /**
     * Setter for tresc
     *
     * @param value value
     */
    public void setTresc(String value) {
        this.tresc.set(value);
    }

    /**
     * Getter for data
     *
     * @return value
     */
    public String getData() {
        return data.get();
    }

    /**
     * Setter for data
     *
     * @param value value
     */
    public void setData(String value) {
        this.data.set(value);
    }
}
