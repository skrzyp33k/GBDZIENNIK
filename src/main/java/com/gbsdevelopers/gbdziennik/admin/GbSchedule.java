package com.gbsdevelopers.gbdziennik.admin;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

public class GbSchedule {
    private final SimpleStringProperty godzina;
    private final SimpleStringProperty poniedzialek;
    private final SimpleStringProperty wtorek;
    private final SimpleStringProperty sroda;
    private final SimpleStringProperty czwartek;
    private final SimpleStringProperty piatek;

    public GbSchedule(String str)
    {
        Vector<String> fields = GbsMessage.explode(str,";");

        this.godzina = new SimpleStringProperty(fields.get(0));
        this.poniedzialek = new SimpleStringProperty(fields.get(1));
        this.wtorek = new SimpleStringProperty(fields.get(2));
        this.sroda = new SimpleStringProperty(fields.get(3));
        this.czwartek = new SimpleStringProperty(fields.get(4));
        this.piatek = new SimpleStringProperty(fields.get(5));
    }

    public String getGodzina() {
        return godzina.get();
    }

    public String getPoniedzialek() {
        return poniedzialek.get();
    }

    public String getWtorek() {
        return wtorek.get();
    }

    public String getSroda() {
        return sroda.get();
    }

    public String getCzwartek() {
        return czwartek.get();
    }

    public String getPiatek() {
        return piatek.get();
    }

    public void setGodzina(String godzina) {
        this.godzina.set(godzina);
    }

    public void setPoniedzialek(String poniedzialek) {
        this.poniedzialek.set(poniedzialek);
    }

    public void setWtorek(String wtorek) {
        this.wtorek.set(wtorek);
    }

    public void setSroda(String sroda) {
        this.sroda.set(sroda);
    }

    public void setCzwartek(String czwartek) {
        this.czwartek.set(czwartek);
    }

    public void setPiatek(String piatek) {
        this.piatek.set(piatek);
    }
}
