package com.gbsdevelopers.gbdziennik.user.datatypes;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

public class GbUserEvent {
    /**
     * Przedmiot field
     */
    private final SimpleStringProperty przedmiot;

    /**
     * Klasa field
     */
    private final SimpleStringProperty klasa;

    /**
     * Kategoria field
     */
    private final SimpleStringProperty kategoria;

    /**
     * Opis field
     */
    private final SimpleStringProperty opis;

    /**
     * Data wydarzenia field
     */
    private final SimpleStringProperty datawydarzenia;

    /**
     * Constructor that construct object from row data merged into one string
     *
     * @param str Data merged into one string
     */
    public GbUserEvent(String str)
    {
        Vector<String> fields = GbsMessage.explode(str,";");

        przedmiot = new SimpleStringProperty(fields.get(0));
        klasa = new SimpleStringProperty(fields.get(1));
        kategoria = new SimpleStringProperty(fields.get(2));
        opis = new SimpleStringProperty(fields.get(3));
        datawydarzenia = new SimpleStringProperty(fields.get(4));
    }

    /**
     * Getter for Przedmiot
     * @return value
     */
    public String getPrzedmiot() {
        return przedmiot.get();
    }

    /**
     * Setter for Przedmiot
     * @param value value
     */
    public void setPrzedmiot(String value) {
        this.przedmiot.set(value);
    }

    /**
     * Getter for Klasa
     * @return value
     */
    public String getKlasa() {
        return klasa.get();
    }

    /**
     * Setter for Klasa
     * @param value value
     */
    public void setklasa(String value) {
        this.klasa.set(value);
    }

    /**
     * Getter for Kategoria
     * @return value
     */
    public String getKategoria() {
        return kategoria.get();
    }

    /**
     * Setter for Kategoria
     * @param value value
     */
    public void setKategoria(String value) {
        this.kategoria.set(value);
    }

    /**
     * Getter for Opis
     * @return value
     */
    public String getOpis() {
        return opis.get();
    }

    /**
     * Setter for Opis
     * @param value value
     */
    public void setOpis(String value) {
        this.opis.set(value);
    }

    /**
     * Getter for Data wydarzenia
     * @return value
     */
    public String getDatawydarzenia() {
        return datawydarzenia.get();
    }

    /**
     * Setter for Data wydarzenia
     * @param value value
     */
    public void setDatawydarzenia(String value) {
        this.datawydarzenia.set(value);
    }
}
