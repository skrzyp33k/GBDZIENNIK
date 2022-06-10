package com.gbsdevelopers.gbdziennik.user.datatypes;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

public class GbUserSchedule {
    private final SimpleStringProperty godzina;
    private final SimpleStringProperty poniedzialek;
    private final SimpleStringProperty wtorek;
    private final SimpleStringProperty sroda;
    private final SimpleStringProperty czwartek;
    private final SimpleStringProperty piatek;

    public GbUserSchedule(String str)
    {
        Vector<String> fields = GbsMessage.explode(str,";");

        godzina = new SimpleStringProperty(fields.get(0));
        poniedzialek = new SimpleStringProperty(fields.get(1));
        wtorek = new SimpleStringProperty(fields.get(2));
        sroda = new SimpleStringProperty(fields.get(3));
        czwartek = new SimpleStringProperty(fields.get(4));
        piatek = new SimpleStringProperty(fields.get(5));
    }

    public String getGodzina() {
        return godzina.get();
    }

    public SimpleStringProperty godzinaProperty() {
        return godzina;
    }

    public void setGodzina(String godzina) {
        this.godzina.set(godzina);
    }

    public String getPoniedzialek() {
        return poniedzialek.get();
    }

    public SimpleStringProperty poniedzialekProperty() {
        return poniedzialek;
    }

    public void setPoniedzialek(String poniedzialek) {
        this.poniedzialek.set(poniedzialek);
    }

    public String getWtorek() {
        return wtorek.get();
    }

    public SimpleStringProperty wtorekProperty() {
        return wtorek;
    }

    public void setWtorek(String wtorek) {
        this.wtorek.set(wtorek);
    }

    public String getSroda() {
        return sroda.get();
    }

    public SimpleStringProperty srodaProperty() {
        return sroda;
    }

    public void setSroda(String sroda) {
        this.sroda.set(sroda);
    }

    public String getCzwartek() {
        return czwartek.get();
    }

    public SimpleStringProperty czwartekProperty() {
        return czwartek;
    }

    public void setCzwartek(String czwartek) {
        this.czwartek.set(czwartek);
    }

    public String getPiatek() {
        return piatek.get();
    }

    public SimpleStringProperty piatekProperty() {
        return piatek;
    }

    public void setPiatek(String piatek) {
        this.piatek.set(piatek);
    }
}
