package com.gbsdevelopers.gbdziennik.datatypes;

import com.gbsdevelopers.gbssocket.GbsMessage;
import javafx.beans.property.SimpleStringProperty;

import java.util.Vector;

/**
 * Class for row from table konta
 */
public class GbAccount {
    /**
     * ID_konta field
     */
    private final SimpleStringProperty idkonta;

    /**
     * Login field
     */
    private final SimpleStringProperty login;

    /**
     * Haslo field
     */
    private final SimpleStringProperty haslo;

    /**
     * Uprawnienia field
     */
    private final SimpleStringProperty uprawnienia;

    /**
     * Constructor that construct object from row data merged into one string
     *
     * @param str Data merged into one string
     */
    public GbAccount(String str) {
        Vector<String> fields = GbsMessage.explode(str, ";");

        idkonta = new SimpleStringProperty(fields.get(0));
        login = new SimpleStringProperty(fields.get(1));
        haslo = new SimpleStringProperty(fields.get(2));
        uprawnienia = new SimpleStringProperty(fields.get(3));
    }

    /**
     * This function calculates MD5 hash.
     *
     * @param md5 String to hash.
     * @return MD5 checksum.
     */
    public static String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : array) {
                sb.append(Integer.toHexString((b & 0xFF) | 0x100), 1, 3);
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException ignored) {
        }
        return null;
    }

    /**
     * Getter for ID_konta
     *
     * @return ID_konta value
     */
    public String getIdkonta() {
        return idkonta.get();
    }

    /**
     * Setter for ID_konta
     *
     * @param value ID_konta value
     */
    public void setIdkonta(String value) {
        idkonta.set(value);
    }

    /**
     * Getter for Login
     *
     * @return Login value
     */
    public String getLogin() {
        return login.get();
    }

    /**
     * Setter for Login
     *
     * @param value Login value
     */
    public void setLogin(String value) {
        login.set(value);
    }

    /**
     * Getter for Haslo
     *
     * @return Haslo value
     */
    public String getHaslo() {
        return haslo.get();
    }

    /**
     * Setter for Haslo
     *
     * @param value Haslo value
     */
    public void setHaslo(String value) {
        haslo.set(value);
    }

    /**
     * Getter for Uprawnienia
     *
     * @return Uprawnienia value
     */
    public String getUprawnienia() {
        return uprawnienia.get();
    }

    /**
     * Setter for Uprawnienia
     *
     * @param value Uprawnienia value
     */
    public void setUprawnienia(String value) {
        uprawnienia.set(value);
    }
}
