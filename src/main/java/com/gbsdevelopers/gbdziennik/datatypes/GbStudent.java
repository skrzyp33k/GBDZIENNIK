package com.gbsdevelopers.gbdziennik.datatypes;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

/**
 * Class for row from table uczniowie
 */
public class GbStudent {
    /**
     * ID_ucznia field
     */
    private final SimpleStringProperty iducznia;

    /**
     * imie field
     */
    private final SimpleStringProperty imie;

    /**
     * nazwisko field
     */
    private final SimpleStringProperty nazwisko;

    /**
     * ID_rodzica field
     */
    private final SimpleStringProperty idrodzica;

    /**
     * ID_klasy field
     */
    private final SimpleStringProperty idklasy;

    /**
     * ID_konta field
     */
    private final SimpleStringProperty idkonta;

    /**
     * Constructor that construct object from row data merged into one string
     *
     * @param str Data merged into one string
     */
    public GbStudent(String str) {
        Vector<String> fields = GbsMessage.explode(str, ";");

        this.iducznia = new SimpleStringProperty(fields.get(0));
        this.imie = new SimpleStringProperty(fields.get(1));
        this.nazwisko = new SimpleStringProperty(fields.get(2));
        this.idrodzica = new SimpleStringProperty(fields.get(3));
        this.idklasy = new SimpleStringProperty(fields.get(4));
        this.idkonta = new SimpleStringProperty(fields.get(5));
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
     * Getter for imie
     *
     * @return imie value
     */
    public String getImie() {
        return imie.get();
    }

    /**
     * Setter for imie
     *
     * @param value imie value
     */
    public void setImie(String value) {
        this.imie.set(value);
    }

    /**
     * Getter for nazwisko
     *
     * @return nazwisko value
     */
    public String getNazwisko() {
        return nazwisko.get();
    }

    /**
     * Setter for nazwisko
     *
     * @param value nazwisko value
     */
    public void setNazwisko(String value) {
        this.nazwisko.set(value);
    }

    /**
     * Getter for ID_rodzica
     *
     * @return ID_rodzica value
     */
    public String getIdrodzica() {
        return idrodzica.get();
    }

    /**
     * Setter for ID_rodzica
     *
     * @param value ID_rodzica value
     */
    public void setIdrodzica(String value) {
        this.idrodzica.set(value);
    }

    /**
     * Getter for ID_klasy
     *
     * @return ID_klasy value
     */
    public String getIdklasy() {
        return idklasy.get();
    }

    /**
     * Setter for ID_klasy
     *
     * @param value ID_klasy value
     */
    public void setIdklasy(String value) {
        this.idklasy.set(value);
    }

    /**
     * Getter for ID_konta
     *
     * @return ID_konta value
     */
    public String getIdkonta() {
        return idkonta.get();
    }

    /**
     * Setter for ID_konta
     *
     * @param value ID_konta value
     */
    public void setIdkonta(String value) {
        this.idkonta.set(value);
    }

}
