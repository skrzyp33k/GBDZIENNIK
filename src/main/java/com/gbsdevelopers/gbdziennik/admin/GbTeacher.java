package com.gbsdevelopers.gbdziennik.admin;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

public class GbTeacher {
    private final SimpleStringProperty idnauczyciela;
    private final SimpleStringProperty imie;
    private final SimpleStringProperty nazwisko;
    private final SimpleStringProperty telefonkontaktowy;
    private final SimpleStringProperty idkonta;

    public GbTeacher(String str) {
        Vector<String> fields = GbsMessage.explode(str, ";");

        this.idnauczyciela = new SimpleStringProperty(fields.get(0));
        this.imie = new SimpleStringProperty(fields.get(1));
        this.nazwisko = new SimpleStringProperty(fields.get(2));
        this.telefonkontaktowy = new SimpleStringProperty(fields.get(3));
        this.idkonta = new SimpleStringProperty(fields.get(4));
    }

    public String getIdnauczyciela() {
        return idnauczyciela.get();
    }

    public String getImie() {
        return imie.get();
    }

    public String getNazwisko() {
        return nazwisko.get();
    }

    public String getTelefonkontaktowy() {
        return telefonkontaktowy.get();
    }

    public String getIdkonta() {
        return idkonta.get();
    }

    public void setIdnauczyciela(String idnauczyciela) {
        this.idnauczyciela.set(idnauczyciela);
    }

    public void setImie(String imie) {
        this.imie.set(imie);
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko.set(nazwisko);
    }

    public void setTelefonkontaktowy(String telefonkontaktowy) {
        this.telefonkontaktowy.set(telefonkontaktowy);
    }

    public void setIdkonta(String idkonta) {
        this.idkonta.set(idkonta);
    }
}
