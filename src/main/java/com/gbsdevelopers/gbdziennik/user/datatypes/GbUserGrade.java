package com.gbsdevelopers.gbdziennik.user.datatypes;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

/**
 * Class for oceny for user space
 */
public class GbUserGrade {
    /**
     * Uczen field
     */
    private final SimpleStringProperty uczen;

    /**
     * Przedmiot field
     */
    private final SimpleStringProperty przedmiot;

    /**
     * Ocena field
     */
    private final SimpleStringProperty ocena;

    /**
     * Waga field
     */
    private final SimpleStringProperty waga;

    /**
     * Opis field
     */
    private final SimpleStringProperty opis;

    /**
     * Data wystawienia field
     */
    private final SimpleStringProperty datawystawienia;

    /**
     * Constructor that construct object from row data merged into one string
     *
     * @param str Data merged into one string
     */
    public GbUserGrade(String str) {
        Vector<String> fields = GbsMessage.explode(str, ";");

        uczen = new SimpleStringProperty(fields.get(0));
        przedmiot = new SimpleStringProperty(fields.get(1));
        ocena = new SimpleStringProperty(fields.get(2));
        waga = new SimpleStringProperty(fields.get(3));
        opis = new SimpleStringProperty(fields.get(4));
        datawystawienia = new SimpleStringProperty(fields.get(5));
    }

    /**
     * Getter for Uczen
     * @return value
     */
    public String getUczen() {
        return uczen.get();
    }

    /**
     * Getter for Przedmiot
     * @return value
     */
    public String getPrzedmiot() {
        return przedmiot.get();
    }

    /**
     * Getter for Ocena
     * @return value
     */
    public String getOcena() {
        return ocena.get();
    }

    /**
     * Getter for Waga
     * @return value
     */
    public String getWaga() {
        return waga.get();
    }

    /**
     * Getter for Opis
     * @return value
     */
    public String getOpis() {
        return opis.get();
    }

    /**
     * Getter for Data Wystawienia
     * @return value
     */
    public String getDatawystawienia() {
        return datawystawienia.get();
    }

    /**
     * Setter for Uczen
     * @param value value
     */
    public void setUczen(String value) {
        this.uczen.set(value);
    }

    /**
     * Setter for Przedmiot
     * @param value value
     */
    public void setPrzedmiot(String value) {
        this.przedmiot.set(value);
    }

    /**
     * Setter for Ocena
     * @param value value
     */
    public void setOcena(String value) {
        this.ocena.set(value);
    }

    /**
     * Setter for Waga
     * @param value value
     */
    public void setWaga(String value) {
        this.waga.set(value);
    }

    /**
     * Setter for Opis
     * @param value value
     */
    public void setOpis(String value) {
        this.opis.set(value);
    }

    /**
     * Setter for Data Wystawienia
     * @param value value
     */
    public void setDatawystawienia(String value) {
        this.datawystawienia.set(value);
    }
}
