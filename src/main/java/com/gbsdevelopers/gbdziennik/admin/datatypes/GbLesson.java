package com.gbsdevelopers.gbdziennik.admin.datatypes;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

/**
 * Class for row from table lekcje
 */
public class GbLesson {
    /**
     * ID_lekcji field
     */
    private final SimpleStringProperty idlekcji;

    /**
     * ID_przedmiotu field
     */
    private final SimpleStringProperty idprzedmiotu;

    /**
     * Sala field
     */
    private final SimpleStringProperty sala;

    /**
     * ID_nauczyciela field
     */
    private final SimpleStringProperty idnauczyciela;

    /**
     * ID_klasy field
     */
    private final SimpleStringProperty idklasy;

    /**
     * Constructor that construct object from row data merged into one string
     *
     * @param str Data merged into one string
     */
    public GbLesson(String str) {
        Vector<String> fields = GbsMessage.explode(str, ";");

        this.idlekcji = new SimpleStringProperty(fields.get(0));
        this.idprzedmiotu = new SimpleStringProperty(fields.get(1));
        this.sala = new SimpleStringProperty(fields.get(2));
        this.idnauczyciela = new SimpleStringProperty(fields.get(3));
        this.idklasy = new SimpleStringProperty(fields.get(4));
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
     * Getter for Sala
     *
     * @return Sala value
     */
    public String getSala() {
        return sala.get();
    }

    /**
     * Setter for Sala
     *
     * @param value Sala value
     */
    public void setSala(String value) {
        this.sala.set(value);
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
}
