package com.gbsdevelopers.gbdziennik.admin;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

public class GbCourse {
    private final SimpleStringProperty idprzedmiotu;
    private final SimpleStringProperty nazwaprzedmiotu;
    private final SimpleStringProperty opis;

    public GbCourse(String str)
    {
        Vector<String> fields = GbsMessage.explode(str,";");

        this.idprzedmiotu = new SimpleStringProperty(fields.get(0));
        this.nazwaprzedmiotu = new SimpleStringProperty(fields.get(1));
        this.opis = new SimpleStringProperty(fields.get(2));
    }

    public String getIdprzedmiotu() {
        return idprzedmiotu.get();
    }

    public String getNazwaprzedmiotu() {
        return nazwaprzedmiotu.get();
    }

    public String getOpis() {
        return opis.get();
    }

    public void setIdprzedmiotu(String idprzedmiotu) {
        this.idprzedmiotu.set(idprzedmiotu);
    }

    public void setNazwaprzedmiotu(String nazwaprzedmiotu) {
        this.nazwaprzedmiotu.set(nazwaprzedmiotu);
    }

    public void setOpis(String opis) {
        this.opis.set(opis);
    }
}
