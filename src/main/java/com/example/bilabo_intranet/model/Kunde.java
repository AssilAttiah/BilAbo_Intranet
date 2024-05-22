package com.example.bilabo_intranet.model;

public class Kunde {
    private int kundeID;
    private String fornavn;
    private String efternavn;
    private int alder;
    private String kørekortnummer;

    public int getKundeID() {
        return kundeID;
    }

    public void setKundeID(int kundeID) {
        this.kundeID = kundeID;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }

    public int getAlder() {
        return alder;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    public String getKørekortnummer() {
        return kørekortnummer;
    }

    public void setKørekortnummer(String kørekortnummer) {
        this.kørekortnummer = kørekortnummer;
    }
}
