package com.gbsdevelopers.gbdziennik.datatypes;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

/**
 * Class for row from table plan_*
 */
public class GbSchedule {
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
    public GbSchedule(String str) {
        Vector<String> fields = GbsMessage.explode(str, ";");

        this.godzina = new SimpleStringProperty(fields.get(0));
        this.poniedzialek = new SimpleStringProperty(fields.get(1));
        this.wtorek = new SimpleStringProperty(fields.get(2));
        this.sroda = new SimpleStringProperty(fields.get(3));
        this.czwartek = new SimpleStringProperty(fields.get(4));
        this.piatek = new SimpleStringProperty(fields.get(5));
    }

    /**
     * Getter for Godzina
     *
     * @return Godzina value
     */
    public String getGodzina() {
        return godzina.get();
    }

    /**
     * Setter for Godzina
     *
     * @param value Godzina value
     */
    public void setGodzina(String value) {
        this.godzina.set(value);
    }

    /**
     * Getter for Poniedzialek
     *
     * @return Poniedzialek value
     */
    public String getPoniedzialek() {
        return poniedzialek.get();
    }

    /**
     * Setter for Poniedzialek
     *
     * @param value Poniedzialek value
     */
    public void setPoniedzialek(String value) {
        this.poniedzialek.set(value);
    }

    /**
     * Getter for Wtorek
     *
     * @return Wtorek value
     */
    public String getWtorek() {
        return wtorek.get();
    }

    /**
     * Setter for Wtorek
     *
     * @param value Wtorek value
     */
    public void setWtorek(String value) {
        this.wtorek.set(value);
    }

    /**
     * Getter for Sroda
     *
     * @return Sroda value
     */
    public String getSroda() {
        return sroda.get();
    }

    /**
     * Setter for Sroda
     *
     * @param value Sroda value
     */
    public void setSroda(String value) {
        this.sroda.set(value);
    }

    /**
     * Getter for Czwartek
     *
     * @return Czwartek value
     */
    public String getCzwartek() {
        return czwartek.get();
    }

    /**
     * Setter for Czwartek
     *
     * @param value Czwartek value
     */
    public void setCzwartek(String value) {
        this.czwartek.set(value);
    }

    /**
     * Getter for Piatek
     *
     * @return Piatek value
     */
    public String getPiatek() {
        return piatek.get();
    }

    /**
     * Setter for Piatek
     *
     * @param value Piatek value
     */
    public void setPiatek(String value) {
        this.piatek.set(value);
    }
}
