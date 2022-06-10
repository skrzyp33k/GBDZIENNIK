package com.gbsdevelopers.gbdziennik.admin.datatypes;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

/**
 * Class for row from table wiadomosci
 */
public class GbMessage {
    /**
     * ID_wiadomosci field
     */
    private final SimpleStringProperty idwiadomosci;

    /**
     * Wiadomosc field
     */
    private final SimpleStringProperty wiadomosc;

    /**
     * ID_nadawcy (ID_konta) field
     */
    private final SimpleStringProperty idnadawcy;

    /**
     * ID_odbiorcy (ID_konta) field
     */
    private final SimpleStringProperty idodbiorcy;

    /**
     * data_wyslania field
     */
    private final SimpleStringProperty datawyslania;

    /**
     * Constructor that construct object from row data merged into one string
     *
     * @param str Data merged into one string
     */
    public GbMessage(String str) {
        Vector<String> fields = GbsMessage.explode(str, ";");

        this.idwiadomosci = new SimpleStringProperty(fields.get(0));
        this.wiadomosc = new SimpleStringProperty(fields.get(1));
        this.idnadawcy = new SimpleStringProperty(fields.get(2));
        this.idodbiorcy = new SimpleStringProperty(fields.get(3));
        this.datawyslania = new SimpleStringProperty(fields.get(4));
    }

    /**
     * Getter for ID_wiadomosci
     *
     * @return ID_wiadomosci value
     */
    public String getIdwiadomosci() {
        return idwiadomosci.get();
    }

    /**
     * Setter for ID_wiadomosci
     *
     * @param value ID_wiadomosci value
     */
    public void setIdwiadomosci(String value) {
        this.idwiadomosci.set(value);
    }

    /**
     * Getter for Wiadomosc
     *
     * @return Wiadomosc value
     */
    public String getWiadomosc() {
        return wiadomosc.get();
    }

    /**
     * Setter for Wiadomosc
     *
     * @param value Wiadomosc value
     */
    public void setWiadomosc(String value) {
        this.wiadomosc.set(value);
    }

    /**
     * Getter for ID_nadawcy
     *
     * @return ID_nadawcy value
     */
    public String getIdnadawcy() {
        return idnadawcy.get();
    }

    /**
     * Setter for ID_nadawcy
     *
     * @param value ID_nadawcy value
     */
    public void setIdnadawcy(String value) {
        this.idnadawcy.set(value);
    }

    /**
     * Getter for ID_odbiorcy
     *
     * @return ID_odbiorcy value
     */
    public String getIdodbiorcy() {
        return idodbiorcy.get();
    }

    /**
     * Setter for ID_odbiorcy
     *
     * @param value ID_odbiorcy value
     */
    public void setIdodbiorcy(String value) {
        this.idodbiorcy.set(value);
    }

    /**
     * Getter for data_wyslania
     *
     * @return data_wyslania value
     */
    public String getDatawyslania() {
        return datawyslania.get();
    }

    /**
     * Setter for data_wyslania
     *
     * @param value data_wyslania value
     */
    public void setDatawyslania(String value) {
        this.datawyslania.set(value);
    }
}
