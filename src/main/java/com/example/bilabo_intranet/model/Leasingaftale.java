package com.example.bilabo_intranet.model;

public class Leasingaftale {
    private int leasingID;
    private String leasingType;
    private int leasingPeriode;
    private String stelnummer;
    private int kundeID;

    public int getLeasingID() {
        return leasingID;
    }

    public void setLeasingID(int leasingID) {
        this.leasingID = leasingID;
    }

    public String getLeasingType() {
        return leasingType;
    }

    public void setLeasingType(String leasingType) {
        this.leasingType = leasingType;
    }

    public int getLeasingPeriode() {
        return leasingPeriode;
    }

    public void setLeasingPeriode(int leasingPeriode) {
        this.leasingPeriode = leasingPeriode;
    }

    public String getStelnummer() {
        return stelnummer;
    }

    public void setStelnummer(String stelnummer) {
        this.stelnummer = stelnummer;
    }

    public int getKundeID() {
        return kundeID;
    }

    public void setKundeID(int kundeID) {
        this.kundeID = kundeID;
    }
}
