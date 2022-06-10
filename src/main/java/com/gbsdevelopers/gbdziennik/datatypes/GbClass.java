package com.gbsdevelopers.gbdziennik.datatypes;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

/**
 * Class for row from table klasy
 */
public class GbClass {
    /**
     * ID_klasy field
     */
    private final SimpleStringProperty idklasy;

    /**
     * nazwa_klasy field
     */
    private final SimpleStringProperty nazwaklasy;

    /**
     * ID_nauczyciela field
     */
    private final SimpleStringProperty idnauczyciela;

    /**
     * Constructor that construct object from row data merged into one string
     *
     * @param str Data merged into one string
     */
    public GbClass(String str) {
        Vector<String> fields = GbsMessage.explode(str, ";");

        this.idklasy = new SimpleStringProperty(fields.get(0));
        this.nazwaklasy = new SimpleStringProperty(fields.get(1));
        this.idnauczyciela = new SimpleStringProperty(fields.get(2));
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
     * Getter for nazwa_klasy
     *
     * @return nazwa_klasy value
     */
    public String getNazwaklasy() {
        return nazwaklasy.get();
    }

    /**
     * Setter for nazwa_klasy
     *
     * @param value nazwa_klasy value
     */
    public void setNazwaklasy(String value) {
        this.nazwaklasy.set(value);
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
}
