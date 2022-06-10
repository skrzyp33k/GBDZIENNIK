package com.gbsdevelopers.gbdziennik.datatypes;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

/**
 * Class for row from table uwagi
 */
public class GbRemark {
    /**
     * ID_uwagi field
     */
    private final SimpleStringProperty iduwagi;

    /**
     * Tresc field
     */
    private final SimpleStringProperty tresc;

    /**
     * ID_nauczyciela field
     */
    private final SimpleStringProperty idnauczyciela;

    /**
     * ID_ucznia field
     */
    private final SimpleStringProperty iducznia;

    /**
     * data_wystawienia field
     */
    private final SimpleStringProperty datawystawienia;

    /**
     * Constructor that construct object from row data merged into one string
     *
     * @param str Data merged into one string
     */
    public GbRemark(String str) {
        Vector<String> fields = GbsMessage.explode(str, ";");

        this.iduwagi = new SimpleStringProperty(fields.get(0));
        this.tresc = new SimpleStringProperty(fields.get(1));
        this.idnauczyciela = new SimpleStringProperty(fields.get(2));
        this.iducznia = new SimpleStringProperty(fields.get(3));
        this.datawystawienia = new SimpleStringProperty(fields.get(4));
    }

    /**
     * Getter for ID_uwagi
     *
     * @return ID_uwagi value
     */
    public String getIduwagi() {
        return iduwagi.get();
    }

    /**
     * Setter for ID_uwagi
     *
     * @param value ID_uwagi value
     */
    public void setIduwagi(String value) {
        this.iduwagi.set(value);
    }

    /**
     * Getter for Tresc
     *
     * @return Tresc value
     */
    public String getTresc() {
        return tresc.get();
    }

    /**
     * Setter for Tresc
     *
     * @param value Tresc value
     */
    public void setTresc(String value) {
        this.tresc.set(value);
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
