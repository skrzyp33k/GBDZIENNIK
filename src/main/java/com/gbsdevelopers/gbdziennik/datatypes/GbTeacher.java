package com.gbsdevelopers.gbdziennik.datatypes;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

/**
 * Class for row from table nauczyciele
 */
public class GbTeacher {
    /**
     * ID_nauczyciela field
     */
    private final SimpleStringProperty idnauczyciela;

    /**
     * imie field
     */
    private final SimpleStringProperty imie;

    /**
     * nazwisko field
     */
    private final SimpleStringProperty nazwisko;

    /**
     * telefon_kontaktowy field
     */
    private final SimpleStringProperty telefonkontaktowy;

    /**
     * ID_konta
     */
    private final SimpleStringProperty idkonta;

    /**
     * Constructor that construct object from row data merged into one string
     *
     * @param str Data merged into one string
     */
    public GbTeacher(String str) {
        Vector<String> fields = GbsMessage.explode(str, ";");

        this.idnauczyciela = new SimpleStringProperty(fields.get(0));
        this.imie = new SimpleStringProperty(fields.get(1));
        this.nazwisko = new SimpleStringProperty(fields.get(2));
        this.telefonkontaktowy = new SimpleStringProperty(fields.get(3));
        this.idkonta = new SimpleStringProperty(fields.get(4));
    }

    /**
     * Getter for ID_nauczyciela
     *
     * @return ID_nauczyciela value
     */
    public String getIdnauczyciela() {
        return idnauczyciela.get();
    }

    /**
     * Setter for ID_nauczyciela
     *
     * @param value ID_nauczyciela value
     */
    public void setIdnauczyciela(String value) {
        this.idnauczyciela.set(value);
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
     * Getter for telefon_kontaktowy
     *
     * @return telefon_kontaktowy value
     */
    public String getTelefonkontaktowy() {
        return telefonkontaktowy.get();
    }

    /**
     * Setter for telefon_kontaktowy
     *
     * @param value telefon_kontaktowy value
     */
    public void setTelefonkontaktowy(String value) {
        this.telefonkontaktowy.set(value);
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
