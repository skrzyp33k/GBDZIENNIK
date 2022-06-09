package com.gbsdevelopers.gbdziennik.admin;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

public class GbLesson {
    private final SimpleStringProperty idlekcji;
    private final SimpleStringProperty idprzedmiotu;
    private final SimpleStringProperty sala;
    private final SimpleStringProperty idnauczyciela;
    private final SimpleStringProperty idklasy;

    public GbLesson(String str)
    {
        Vector<String> fields = GbsMessage.explode(str,";");

        this.idlekcji = new SimpleStringProperty(fields.get(0));
        this.idprzedmiotu = new SimpleStringProperty(fields.get(1));
        this.sala = new SimpleStringProperty(fields.get(2));
        this.idnauczyciela = new SimpleStringProperty(fields.get(3));
        this.idklasy = new SimpleStringProperty(fields.get(4));
    }

    public String getIdlekcji() {
        return idlekcji.get();
    }

    public String getIdprzedmiotu() {
        return idprzedmiotu.get();
    }

    public String getSala() {
        return sala.get();
    }

    public String getIdnauczyciela() {
        return idnauczyciela.get();
    }

    public String getIdklasy() {
        return idklasy.get();
    }

    public void setIdlekcji(String idlekcji) {
        this.idlekcji.set(idlekcji);
    }

    public void setIdprzedmiotu(String idprzedmiotu) {
        this.idprzedmiotu.set(idprzedmiotu);
    }

    public void setSala(String sala) {
        this.sala.set(sala);
    }

    public void setIdnauczyciela(String idnauczyciela) {
        this.idnauczyciela.set(idnauczyciela);
    }

    public void setIdklasy(String idklasy) {
        this.idklasy.set(idklasy);
    }
}
