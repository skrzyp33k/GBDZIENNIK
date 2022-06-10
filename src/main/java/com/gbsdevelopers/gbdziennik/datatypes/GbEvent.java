package com.gbsdevelopers.gbdziennik.datatypes;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

/**
 * Class for row from table wydarzenia
 */
public class GbEvent {
    /**
     * ID_wydarzenia field
     */
    private final SimpleStringProperty idwydarzenia;

    /**
     * Kategoria field
     */
    private final SimpleStringProperty kategoria;

    /**
     * Opis field
     */
    private final SimpleStringProperty opis;

    /**
     * ID_lekcji field
     */
    private final SimpleStringProperty idlekcji;

    /**
     * data_wydarzenia field
     */
    private final SimpleStringProperty datawydarzenia;

    /**
     * Constructor that construct object from row data merged into one string
     *
     * @param str Data merged into one string
     */
    public GbEvent(String str) {
        Vector<String> fields = GbsMessage.explode(str, ";");

        this.idwydarzenia = new SimpleStringProperty(fields.get(0));
        this.kategoria = new SimpleStringProperty(fields.get(1));
        this.opis = new SimpleStringProperty(fields.get(2));
        this.idlekcji = new SimpleStringProperty(fields.get(3));
        this.datawydarzenia = new SimpleStringProperty(fields.get(4));
    }

    /**
     * Getter for ID_wydarzenia
     *
     * @return ID_wydarzenia value
     */
    public String getIdwydarzenia() {
        return idwydarzenia.get();
    }

    /**
     * Setter for ID_wydarzenia
     *
     * @param value ID_wydarzenia value
     */
    public void setIdwydarzenia(String value) {
        this.idwydarzenia.set(value);
    }

    /**
     * Getter for Kategoria
     *
     * @return Kategoria value
     */
    public String getKategoria() {
        return kategoria.get();
    }

    /**
     * Setter for Kategoria
     *
     * @param value Kategoria value
     */
    public void setKategoria(String value) {
        this.kategoria.set(value);
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
     * Getter for data_wydarzenia
     *
     * @return data_wydarzenia value
     */
    public String getDatawydarzenia() {
        return datawydarzenia.get();
    }

    /**
     * Setter for data_wydarzenia
     *
     * @param value data_wydarzenia value
     */
    public void setDatawydarzenia(String value) {
        this.datawydarzenia.set(value);
    }
}
