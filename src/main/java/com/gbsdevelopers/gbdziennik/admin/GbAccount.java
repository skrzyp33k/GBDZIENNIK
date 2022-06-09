package com.gbsdevelopers.gbdziennik.admin;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

public class GbAccount {
    private final SimpleStringProperty idkonta;
    private final SimpleStringProperty login;
    private final SimpleStringProperty haslo;
    private final SimpleStringProperty uprawnienia;

    public GbAccount(String str) {
        Vector<String> fields = GbsMessage.explode(str, ";");

        idkonta = new SimpleStringProperty(fields.get(0));
        login = new SimpleStringProperty(fields.get(1));
        haslo = new SimpleStringProperty(fields.get(2));
        uprawnienia = new SimpleStringProperty(fields.get(3));
    }

    public String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }

    public String getIdkonta() {
        return idkonta.get();
    }

    public String getLogin() {
        return login.get();
    }

    public String getHaslo() {
        return haslo.get();
    }

    public String getUprawnienia() {
        return uprawnienia.get();
    }

    public void getIDKonta(String value) {
        idkonta.set(value);
    }

    public void getLogin(String value) {
        login.set(value);
    }

    public void getHaslo(String value) {
        haslo.set(value);
    }

    public void getUprawnienia(String value) {
        uprawnienia.set(value);
    }
}
