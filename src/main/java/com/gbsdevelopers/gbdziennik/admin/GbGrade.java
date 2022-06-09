package com.gbsdevelopers.gbdziennik.admin;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

public class GbGrade {
    private final SimpleStringProperty idoceny;
    private final SimpleStringProperty ocena;
    private final SimpleStringProperty waga;
    private final SimpleStringProperty opis;
    private final SimpleStringProperty iducznia;
    private final SimpleStringProperty idnauczyciela;
    private final SimpleStringProperty idprzedmiotu;
    private final SimpleStringProperty datawystawienia;

    public GbGrade(String str)
    {
        Vector<String> fields = GbsMessage.explode(str,";");

       this.idoceny = new SimpleStringProperty(fields.get(0));
       this.ocena = new SimpleStringProperty(fields.get(1));
       this.waga = new SimpleStringProperty(fields.get(2));
       this.opis = new SimpleStringProperty(fields.get(3));
       this.iducznia = new SimpleStringProperty(fields.get(4));
       this.idnauczyciela = new SimpleStringProperty(fields.get(5));
       this.idprzedmiotu = new SimpleStringProperty(fields.get(6));
       this.datawystawienia = new SimpleStringProperty(fields.get(7));
    }

    public String getIdoceny() {
        return idoceny.get();
    }

    public String getOcena() {
        return ocena.get();
    }

    public String getWaga() {
        return waga.get();
    }

    public String getOpis() {
        return opis.get();
    }

    public String getIducznia() {
        return iducznia.get();
    }

    public String getIdnauczyciela() {
        return idnauczyciela.get();
    }

    public String getIdprzedmiotu() {
        return idprzedmiotu.get();
    }

    public String getDatawystawienia() {
        return datawystawienia.get();
    }

    public void setIdoceny(String idoceny) {
        this.idoceny.set(idoceny);
    }

    public void setOcena(String ocena) {
        this.ocena.set(ocena);
    }

    public void setWaga(String waga) {
        this.waga.set(waga);
    }

    public void setOpis(String opis) {
        this.opis.set(opis);
    }

    public void setIducznia(String iducznia) {
        this.iducznia.set(iducznia);
    }

    public void setIdnauczyciela(String idnauczyciela) {
        this.idnauczyciela.set(idnauczyciela);
    }

    public void setIdprzedmiotu(String idprzedmiotu) {
        this.idprzedmiotu.set(idprzedmiotu);
    }

    public void setDatawystawienia(String datawystawienia) {
        this.datawystawienia.set(datawystawienia);
    }
}
