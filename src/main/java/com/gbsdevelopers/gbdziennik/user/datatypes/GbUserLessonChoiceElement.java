package com.gbsdevelopers.gbdziennik.user.datatypes;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

/**
 * Class for Lesson elements for ChoiceBox
 */
public class GbUserLessonChoiceElement {
    /**
     * ID lekcji field
     */
    private SimpleStringProperty idlekcji;

    /**
     * ID przedmiotu field
     */
    private SimpleStringProperty idprzedmiotu;

    /**
     * Nazwa klasy field
     */
    private SimpleStringProperty nazwaprzedmiotu;

    /**
     * Constructor that construct object from row data merged into one string
     *
     * @param str Data merged into one string
     */
    public GbUserLessonChoiceElement(String str)
    {
        Vector<String> fields = GbsMessage.explode(str,";");

        idlekcji = new SimpleStringProperty(fields.get(0));
        idprzedmiotu = new SimpleStringProperty(fields.get(1));
        nazwaprzedmiotu = new SimpleStringProperty(fields.get(2));
    }

    /**
     * Getter for ID lekcji
     * @return value
     */
    public String getIdlekcji() {
        return idlekcji.get();
    }

    /**
     * Setter for ID lekcji
     * @param value value
     */
    public void setIdlekcji(String value) {
        this.idlekcji.set(value);
    }

    /**
     * Getter for ID lekcji
     * @return value
     */
    public String getIdprzedmiotu() {
        return idprzedmiotu.get();
    }

    /**
     * Setter for ID lekcji
     * @param value value
     */
    public void setIdprzedmoitu(String value) {
        this.idprzedmiotu.set(value);
    }

    /**
     * Getter for Nazwa przedmiotu
     * @return value
     */
    public String getNazwaklasy() {
        return nazwaprzedmiotu.get();
    }

    /**
     * Setter for Nazwa przedmiotu
     * @param value value
     */
    public void setNazwaklasy(String value) {
        this.nazwaprzedmiotu.set(value);
    }


    /**
     * Getter for only class number and letter
     * @return value
     */
    public String getClassName()
    {
        return GbsMessage.explode(this.nazwaprzedmiotu.get()," ").lastElement();

    }

    /**
     * Provides text to ChoiceBox
     * @return dane
     */
    @Override
    public String toString()
    {
        return nazwaprzedmiotu.get();
    }
}
