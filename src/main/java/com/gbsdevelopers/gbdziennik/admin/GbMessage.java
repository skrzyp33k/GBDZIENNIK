package com.gbsdevelopers.gbdziennik.admin;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

public class GbMessage {
    private final SimpleStringProperty idwiadomosci;
    private final SimpleStringProperty wiadomosc;
    private final SimpleStringProperty idnadawcy;
    private final SimpleStringProperty idodbiorcy;
    private final SimpleStringProperty datawyslania;

    public GbMessage(String str)
    {
        Vector<String> fields = GbsMessage.explode(str,";");

        this.idwiadomosci = new SimpleStringProperty(fields.get(0));
        this.wiadomosc = new SimpleStringProperty(fields.get(1));
        this.idnadawcy = new SimpleStringProperty(fields.get(2));
        this.idodbiorcy = new SimpleStringProperty(fields.get(3));
        this.datawyslania = new SimpleStringProperty(fields.get(4));
    }

    public String getIdwiadomosci() {
        return idwiadomosci.get();
    }

    public String getWiadomosc() {
        return wiadomosc.get();
    }

    public String getIdnadawcy() {
        return idnadawcy.get();
    }

    public String getIdodbiorcy() {
        return idodbiorcy.get();
    }

    public String getDatawyslania() {
        return datawyslania.get();
    }

    public void setIdwiadomosci(String idwiadomosci) {
        this.idwiadomosci.set(idwiadomosci);
    }

    public void setWiadomosc(String wiadomosc) {
        this.wiadomosc.set(wiadomosc);
    }

    public void setIdnadawcy(String idnadawcy) {
        this.idnadawcy.set(idnadawcy);
    }

    public void setIdodbiorcy(String idodbiorcy) {
        this.idodbiorcy.set(idodbiorcy);
    }

    public void setDatawyslania(String datawyslania) {
        this.datawyslania.set(datawyslania);
    }
}
