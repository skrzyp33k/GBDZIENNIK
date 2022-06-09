package com.gbsdevelopers.gbdziennik.admin;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

public class GbParent {
    private final SimpleStringProperty idrodzica;
    private final SimpleStringProperty imie;
    private final SimpleStringProperty nazwisko;
    private final SimpleStringProperty idkonta;

    public GbParent(String str)
    {
        Vector<String> fields = GbsMessage.explode(str,";");

        this.idrodzica = new SimpleStringProperty(fields.get(0));
        this.imie = new SimpleStringProperty(fields.get(1));
        this.nazwisko = new SimpleStringProperty(fields.get(2));
        this.idkonta = new SimpleStringProperty(fields.get(3));
    }

    public String getIdrodzica() {
        return idrodzica.get();
    }

    public String getImie() {
        return imie.get();
    }

    public String getNazwisko() {
        return nazwisko.get();
    }

    public String getIdkonta() {
        return idkonta.get();
    }

    public void setIdrodzica(String idrodzica) {
        this.idrodzica.set(idrodzica);
    }

    public void setImie(String imie) {
        this.imie.set(imie);
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko.set(nazwisko);
    }

    public void setIdkonta(String idkonta) {
        this.idkonta.set(idkonta);
    }
}
