package com.gbsdevelopers.gbdziennik.admin;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

public class GbStudent {

    private final SimpleStringProperty iducznia;
    private final SimpleStringProperty imie;
    private final SimpleStringProperty nazwisko;
    private final SimpleStringProperty idrodzica;
    private final SimpleStringProperty idklasy;
    private final SimpleStringProperty idkonta;

    public GbStudent(String str) {
        Vector<String> fields = GbsMessage.explode(str, ";");

        this.iducznia = new SimpleStringProperty(fields.get(0));
        this.imie = new SimpleStringProperty(fields.get(1));
        this.nazwisko = new SimpleStringProperty(fields.get(2));
        this.idrodzica = new SimpleStringProperty(fields.get(3));
        this.idklasy = new SimpleStringProperty(fields.get(4));
        this.idkonta = new SimpleStringProperty(fields.get(5));
    }

    public String getIducznia() {
        return iducznia.get();
    }

    public void setIducznia(String iducznia) {
        this.iducznia.set(iducznia);
    }

    public String getImie() {
        return imie.get();
    }

    public void setImie(String imie) {
        this.imie.set(imie);
    }

    public String getNazwisko() {
        return nazwisko.get();
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko.set(nazwisko);
    }

    public String getIdrodzica() {
        return idrodzica.get();
    }

    public void setIdrodzica(String idrodzica) {
        this.idrodzica.set(idrodzica);
    }

    public String getIdklasy() {
        return idklasy.get();
    }

    public void setIdklasy(String idklasy) {
        this.idklasy.set(idklasy);
    }

    public String getIdkonta() {
        return idkonta.get();
    }

    public void setIdkonta(String idkonta) {
        this.idkonta.set(idkonta);
    }

}
