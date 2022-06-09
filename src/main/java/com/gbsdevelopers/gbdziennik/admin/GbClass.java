package com.gbsdevelopers.gbdziennik.admin;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

public class GbClass {
    private final SimpleStringProperty idklasy;
    private final SimpleStringProperty nazwaklasy;
    private final SimpleStringProperty idnauczyciela;

    public GbClass(String str)
    {
        Vector<String> fields = GbsMessage.explode(str,";");

        this.idklasy = new SimpleStringProperty(fields.get(0));
        this.nazwaklasy = new SimpleStringProperty(fields.get(1));
        this.idnauczyciela = new SimpleStringProperty(fields.get(2));
    }

    public String getIdklasy() {
        return idklasy.get();
    }

    public String getNazwaklasy() {
        return nazwaklasy.get();
    }

    public String getIdnauczyciela() {
        return idnauczyciela.get();
    }

    public void setIdklasy(String idklasy) {
        this.idklasy.set(idklasy);
    }

    public void setNazwaklasy(String nazwaklasy) {
        this.nazwaklasy.set(nazwaklasy);
    }

    public void setIdnauczyciela(String idnauczyciela) {
        this.idnauczyciela.set(idnauczyciela);
    }
}
