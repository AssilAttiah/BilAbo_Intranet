package com.example.bilabo_intranet.model;

public class TilstandsrapportModel {
   private String rapportNummer;

   private String pris;
   private String stelnummer;
   private String skadeOgMangler;


    public String getRapportNummer() {
        return rapportNummer;
    }

    public void setRapportNummer(String rapportNummer) {
        this.rapportNummer = rapportNummer;
    }

    public String getPris() {
        return pris;
    }

    public void setPris(String pris) {
        this.pris = pris;
    }

    public String getStelnummer() {
        return stelnummer;
    }

    public void setStelnummer(String stelnummer) {
        this.stelnummer = stelnummer;
    }

    public String getSkadeOgMangler() {
        return skadeOgMangler;
    }

    public void setSkadeOgMangler(String skadeOgMangler) {
        this.skadeOgMangler = skadeOgMangler;
    }

}
