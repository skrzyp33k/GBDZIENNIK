package com.gbsdevelopers.gbdziennik.admin;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

public class GbRemark {
    private final SimpleStringProperty iduwagi;
    private final SimpleStringProperty tresc;
    private final SimpleStringProperty idnauczyciela;
    private final SimpleStringProperty iducznia;
    private final SimpleStringProperty datawystawienia;

    public GbRemark(String str)
    {
        Vector<String> fields = GbsMessage.explode(str,";");

        this.iduwagi = new SimpleStringProperty(fields.get(0));
        this.tresc = new SimpleStringProperty(fields.get(1));
        this.idnauczyciela = new SimpleStringProperty(fields.get(2));
        this.iducznia = new SimpleStringProperty(fields.get(3));
        this.datawystawienia = new SimpleStringProperty(fields.get(4));
    }

    public String getIduwagi() {
        return iduwagi.get();
    }

    public String getTresc() {
        return tresc.get();
    }

    public String getIdnauczyciela() {
        return idnauczyciela.get();
    }

    public String getIducznia() {
        return iducznia.get();
    }

    public String getDatawystawienia() {
        return datawystawienia.get();
    }

    public void setIduwagi(String iduwagi) {
        this.iduwagi.set(iduwagi);
    }

    public void setTresc(String tresc) {
        this.tresc.set(tresc);
    }

    public void setIdnauczyciela(String idnauczyciela) {
        this.idnauczyciela.set(idnauczyciela);
    }

    public void setIducznia(String iducznia) {
        this.iducznia.set(iducznia);
    }

    public void setDatawystawienia(String datawystawienia) {
        this.datawystawienia.set(datawystawienia);
    }
}
