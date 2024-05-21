package com.example.bilabo_intranet.model;

public class Bil {

    private String stelnummer;
    private String mærke;
    private String model;
    private String status;
    private String fornavn;
    private String efternavn;
    private String kørekortnummer;
    private String årgang;
    private String tid;
    private int unlimitedLeasing;

    public String getStelnummer() {
        return stelnummer;
    }

    public void setStelnummer(String stelnummer) {
        this.stelnummer = stelnummer;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getKørekortnummer() {
        return kørekortnummer;
    }

    public void setKørekortnummer(String kørekortnummer) {
        this.kørekortnummer = kørekortnummer;
    }

    public String getÅrgang() {
        return årgang;
    }

    public void setÅrgang(String årgang) {
        this.årgang = årgang;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public int getUnlimitedLeasing() {
        return unlimitedLeasing;
    }

    public void setUnlimitedLeasing(int unlimitedLeasing) {
        this.unlimitedLeasing = unlimitedLeasing;
    }

    public String getMærke() {
        return mærke;
    }

    public void setMærke(String mærke) {
        this.mærke = mærke;
    }
}
