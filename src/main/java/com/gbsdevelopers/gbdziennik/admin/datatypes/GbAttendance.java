package com.gbsdevelopers.gbdziennik.admin.datatypes;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

/**
 * Class for row from table nieobecnosci
 */
public class GbAttendance {
    /**
     * ID_nieobecnosci field
     */
    private final SimpleStringProperty idnieobecnosci;

    /**
     * ID_ucznia field
     */
    private final SimpleStringProperty iducznia;

    /**
     * ID_lekcji field
     */
    private final SimpleStringProperty idlekcji;

    /**
     * data_nieobecnosci field
     */
    private final SimpleStringProperty datanieobecnosci;

    /**
     * TYP field
     */
    private final SimpleStringProperty typ;

    /**
     * Constructor that construct object from row data merged into one string
     *
     * @param str Data merged into one string
     */
    public GbAttendance(String str) {
        Vector<String> fields = GbsMessage.explode(str, ";");

        idnieobecnosci = new SimpleStringProperty(fields.get(0));
        iducznia = new SimpleStringProperty(fields.get(1));
        idlekcji = new SimpleStringProperty(fields.get(2));
        datanieobecnosci = new SimpleStringProperty(fields.get(3));
        typ = new SimpleStringProperty(fields.get(4));
    }

    /**
     * Getter for ID_nieobecnosci
     *
     * @return ID_nieobecnosci value
     */
    public String getIdnieobecnosci() {
        return idnieobecnosci.get();
    }

    /**
     * Setter for ID_nieobecnosci
     *
     * @param value ID_nieobecnosci value
     */
    public void setIdnieobecnosci(String value) {
        this.idnieobecnosci.set(value);
    }

    /**
     * Getter for ID_ucznia
     *
     * @return ID_ucznia value
     */
    public String getIducznia() {
        return iducznia.get();
    }

    /**
     * Setter for ID_ucznia
     *
     * @param value ID_ucznia value
     */
    public void setIducznia(String value) {
        this.iducznia.set(value);
    }

    /**
     * Getter for ID_lekcji
     *
     * @return ID_lekcji value
     */
    public String getIdlekcji() {
        return idlekcji.get();
    }

    /**
     * Setter for ID_lekcji
     *
     * @param value ID_lekcji value
     */
    public void setIdlekcji(String value) {
        this.idlekcji.set(value);
    }

    /**
     * Getter for data_nieobecnosci
     *
     * @return data_nieobecnosci value
     */
    public String getDatanieobecnosci() {
        return datanieobecnosci.get();
    }

    /**
     * Setter for data_nieobecnosci
     *
     * @param value data_nieobecnosci value
     */
    public void setDatanieobecnosci(String value) {
        this.datanieobecnosci.set(value);
    }

    /**
     * Getter for TYP
     *
     * @return TYP value
     */
    public String getTyp() {
        return typ.get();
    }

    /**
     * Setter for TYP
     *
     * @param value TYP value
     */
    public void setTyp(String value) {
        this.typ.set(value);
    }
}
