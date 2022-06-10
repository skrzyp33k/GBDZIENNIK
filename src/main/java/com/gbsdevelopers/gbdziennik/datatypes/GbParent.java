package com.gbsdevelopers.gbdziennik.datatypes;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

/**
 * Class for row from table rodzice
 */
public class GbParent {
    /**
     * ID_rodzica field
     */
    private final SimpleStringProperty idrodzica;

    /**
     *  imie field
     */
    private final SimpleStringProperty imie;

    /**
     * nazwisko field
     */
    private final SimpleStringProperty nazwisko;

    /**
     * ID_konta field
     */
    private final SimpleStringProperty idkonta;

    /**
     * Constructor that construct object from row data merged into one string
     *
     * @param str Data merged into one string
     */
    public GbParent(String str) {
        Vector<String> fields = GbsMessage.explode(str, ";");

        this.idrodzica = new SimpleStringProperty(fields.get(0));
        this.imie = new SimpleStringProperty(fields.get(1));
        this.nazwisko = new SimpleStringProperty(fields.get(2));
        this.idkonta = new SimpleStringProperty(fields.get(3));
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
