package com.gbsdevelopers.gbdziennik.admin;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

public class GbEvent {
    private final SimpleStringProperty idwydarzenia;
    private final SimpleStringProperty kategoria;
    private final SimpleStringProperty opis;
    private final SimpleStringProperty idlekcji;
    private final SimpleStringProperty datawydarzenia;

    public GbEvent(String str) {
        Vector<String> fields = GbsMessage.explode(str, ";");

        this.idwydarzenia = new SimpleStringProperty(fields.get(0));
        this.kategoria = new SimpleStringProperty(fields.get(1));
        this.opis = new SimpleStringProperty(fields.get(2));
        this.idlekcji = new SimpleStringProperty(fields.get(3));
        this.datawydarzenia = new SimpleStringProperty(fields.get(4));
    }

    public String getIdwydarzenia() {
        return idwydarzenia.get();
    }

    public String getKategoria() {
        return kategoria.get();
    }

    public String getOpis() {
        return opis.get();
    }

    public String getIdlekcji() {
        return idlekcji.get();
    }

    public String getDatawydarzenia() {
        return datawydarzenia.get();
    }

    public void setIdwydarzenia(String idwydarzenia) {
        this.idwydarzenia.set(idwydarzenia);
    }

    public void setKategoria(String kategoria) {
        this.kategoria.set(kategoria);
    }

    public void setOpis(String opis) {
        this.opis.set(opis);
    }

    public void setIdlekcji(String idlekcji) {
        this.idlekcji.set(idlekcji);
    }

    public void setDatawydarzenia(String datawydarzenia) {
        this.datawydarzenia.set(datawydarzenia);
    }
}
