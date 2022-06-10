package com.gbsdevelopers.gbdziennik.datatypes;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

/**
 * Class for row from table przedmioty
 */
public class GbCourse {
    /**
     * ID_przedmiotu field
     */
    private final SimpleStringProperty idprzedmiotu;

    /**
     * nazwa_przedmiotu field
     */
    private final SimpleStringProperty nazwaprzedmiotu;

    /**
     * opis field
     */
    private final SimpleStringProperty opis;

    /**
     * Constructor that construct object from row data merged into one string
     *
     * @param str Data merged into one string
     */
    public GbCourse(String str) {
        Vector<String> fields = GbsMessage.explode(str, ";");

        this.idprzedmiotu = new SimpleStringProperty(fields.get(0));
        this.nazwaprzedmiotu = new SimpleStringProperty(fields.get(1));
        this.opis = new SimpleStringProperty(fields.get(2));
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
     * Getter for nazwa_przedmiotu
     *
     * @return nazwa_przedmiotu value
     */
    public String getNazwaprzedmiotu() {
        return nazwaprzedmiotu.get();
    }

    /**
     * Setter for nazwa_przedmiotu
     *
     * @param value nazwa_przedmiotu value
     */
    public void setNazwaprzedmiotu(String value) {
        this.nazwaprzedmiotu.set(value);
    }

    /**
     * Getter for opis
     *
     * @return opis value
     */
    public String getOpis() {
        return opis.get();
    }

    /**
     * Setter for opis
     *
     * @param value opis value
     */
    public void setOpis(String value) {
        this.opis.set(value);
    }
}
