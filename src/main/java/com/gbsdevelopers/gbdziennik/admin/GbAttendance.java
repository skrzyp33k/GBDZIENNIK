package com.gbsdevelopers.gbdziennik.admin;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

public class GbAttendance {
    private final SimpleStringProperty idnieobecnosci;
    private final SimpleStringProperty iducznia;
    private final SimpleStringProperty idlekcji;
    private final SimpleStringProperty datanieobecnosci;
    private final SimpleStringProperty typ;

    public GbAttendance(String str) {
        Vector<String> fields = GbsMessage.explode(str, ";");

        idnieobecnosci = new SimpleStringProperty(fields.get(0));
        iducznia = new SimpleStringProperty(fields.get(1));
        idlekcji = new SimpleStringProperty(fields.get(2));
        datanieobecnosci = new SimpleStringProperty(fields.get(3));
        typ = new SimpleStringProperty(fields.get(4));
    }

    public String getIdnieobecnosci() {
        return idnieobecnosci.get();
    }

    public String getIducznia() {
        return iducznia.get();
    }

    public String getIdlekcji() {
        return idlekcji.get();
    }

    public String getDatanieobecnosci() {
        return datanieobecnosci.get();
    }

    public String getTyp() {
        return typ.get();
    }

    public void setIdnieobecnosci(String idnieobecnosci) {
        this.idnieobecnosci.set(idnieobecnosci);
    }

    public void setIducznia(String iducznia) {
        this.iducznia.set(iducznia);
    }

    public void setIdlekcji(String idlekcji) {
        this.idlekcji.set(idlekcji);
    }

    public void setDatanieobecnosci(String datanieobecnosci) {
        this.datanieobecnosci.set(datanieobecnosci);
    }

    public void setTyp(String typ) {
        this.typ.set(typ);
    }
}
