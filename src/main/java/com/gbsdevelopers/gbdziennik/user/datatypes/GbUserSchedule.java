package com.gbsdevelopers.gbdziennik.user.datatypes;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

/**
 * Class for plan for user space
 */
public class GbUserSchedule {
    /**
     * Godzina field
     */
    private final SimpleStringProperty godzina;

    /**
     * Poniedzialek field
     */
    private final SimpleStringProperty poniedzialek;

    /**
     * Wtorek field
     */
    private final SimpleStringProperty wtorek;

    /**
     * Sroda field
     */
    private final SimpleStringProperty sroda;

    /**
     * Czwartek field
     */
    private final SimpleStringProperty czwartek;

    /**
     * Piatek field
     */
    private final SimpleStringProperty piatek;

    /**
     * Constructor that construct object from row data merged into one string
     *
     * @param str Data merged into one string
     */
    public GbUserSchedule(String str) {
        Vector<String> fields = GbsMessage.explode(str, ";");

        godzina = new SimpleStringProperty(fields.get(0));
        poniedzialek = new SimpleStringProperty(fields.get(1));
        wtorek = new SimpleStringProperty(fields.get(2));
        sroda = new SimpleStringProperty(fields.get(3));
        czwartek = new SimpleStringProperty(fields.get(4));
        piatek = new SimpleStringProperty(fields.get(5));
    }

    /**
     * Getter for Godzina
     *
     * @return value
     */
    public String getGodzina() {
        return godzina.get();
    }

    /**
     * Setter for Godzina
     *
     * @param value value
     */
    public void setGodzina(String value) {
        this.godzina.set(value);
    }

    /**
     * Getter for Poniedzialek
     *
     * @return value
     */
    public String getPoniedzialek() {
        return poniedzialek.get();
    }

    /**
     * Setter for Poniedzialek
     *
     * @param value value
     */
    public void setPoniedzialek(String value) {
        this.poniedzialek.set(value);
    }

    /**
     * Getter for Wtorek
     *
     * @return value
     */
    public String getWtorek() {
        return wtorek.get();
    }

    /**
     * Setter for Wtorek
     *
     * @param value value
     */
    public void setWtorek(String value) {
        this.wtorek.set(value);
    }

    /**
     * Getter for Sroda
     *
     * @return value
     */
    public String getSroda() {
        return sroda.get();
    }

    /**
     * Setter for Sroda
     *
     * @param value value
     */
    public void setSroda(String value) {
        this.sroda.set(value);
    }

    /**
     * Getter for Czwartek
     *
     * @return value
     */
    public String getCzwartek() {
        return czwartek.get();
    }

    /**
     * Setter for Czwartek
     *
     * @param value value
     */
    public void setCzwartek(String value) {
        this.czwartek.set(value);
    }

    /**
     * Getter for Piatek
     *
     * @return value
     */
    public String getPiatek() {
        return piatek.get();
    }

    /**
     * Setter for Piatek
     *
     * @param value value
     */
    public void setPiatek(String value) {
        this.piatek.set(value);
    }
}
