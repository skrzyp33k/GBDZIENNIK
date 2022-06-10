package com.gbsdevelopers.gbdziennik.datatypes;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

/**
 * Class for row from table oceny
 */
public class GbGrade {
    /**
     * ID_oceny field
     */
    private final SimpleStringProperty idoceny;

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
     * ID_ucznia field
     */
    private final SimpleStringProperty iducznia;

    /**
     * ID_nauczyciela field
     */
    private final SimpleStringProperty idnauczyciela;

    /**
     * ID_przedmiotu field
     */
    private final SimpleStringProperty idprzedmiotu;

    /**
     * data_wystawienia field
     */
    private final SimpleStringProperty datawystawienia;

    /**
     * Constructor that construct object from row data merged into one string
     *
     * @param str Data merged into one string
     */
    public GbGrade(String str) {
        Vector<String> fields = GbsMessage.explode(str, ";");

        this.idoceny = new SimpleStringProperty(fields.get(0));
        this.ocena = new SimpleStringProperty(fields.get(1));
        this.waga = new SimpleStringProperty(fields.get(2));
        this.opis = new SimpleStringProperty(fields.get(3));
        this.iducznia = new SimpleStringProperty(fields.get(4));
        this.idnauczyciela = new SimpleStringProperty(fields.get(5));
        this.idprzedmiotu = new SimpleStringProperty(fields.get(6));
        this.datawystawienia = new SimpleStringProperty(fields.get(7));
    }

    /**
     * Getter for ID_oceny
     *
     * @return ID_oceny value
     */
    public String getIdoceny() {
        return idoceny.get();
    }

    /**
     * Setter for ID_oceny
     *
     * @param value ID_oceny value
     */
    public void setIdoceny(String value) {
        this.idoceny.set(value);
    }

    /**
     * Getter for Ocena
     *
     * @return Ocena value
     */
    public String getOcena() {
        return ocena.get();
    }

    /**
     * Setter for Ocena
     *
     * @param value Ocena value
     */
    public void setOcena(String value) {
        this.ocena.set(value);
    }

    /**
     * Getter for Waga
     *
     * @return Waga value
     */
    public String getWaga() {
        return waga.get();
    }

    /**
     * Setter for Waga
     *
     * @param value Waga value
     */
    public void setWaga(String value) {
        this.waga.set(value);
    }

    /**
     * Getter for Opis
     *
     * @return Opis value
     */
    public String getOpis() {
        return opis.get();
    }

    /**
     * Setter for Opis
     *
     * @param value Opis value
     */
    public void setOpis(String value) {
        this.opis.set(value);
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
     * Getter for ID_przedmiotu
     *
     * @return ID_przedmiotu value
     */
    public String getIdprzedmiotu() {
        return idprzedmiotu.get();
    }

    /**
     * Setter for ID_przedmiotu
     *
     * @param value ID_przedmiotu value
     */
    public void setIdprzedmiotu(String value) {
        this.idprzedmiotu.set(value);
    }

    /**
     * Getter for data_wystawienia
     *
     * @return data_wystawienia value
     */
    public String getDatawystawienia() {
        return datawystawienia.get();
    }

    /**
     * Setter for data_wystawienia
     *
     * @param value data_wystawienia value
     */
    public void setDatawystawienia(String value) {
        this.datawystawienia.set(value);
    }
}
