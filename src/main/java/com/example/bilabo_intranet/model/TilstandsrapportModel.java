package com.example.bilabo_intranet.model;

import java.math.BigDecimal;

public class TilstandsrapportModel {
   private String rapportNummer;

   private BigDecimal pris;
   private String stelnummer;
   private String skadeOgMangler;


    public String getRapportNummer() {
        return rapportNummer;
    }

    public void setRapportNummer(String rapportNummer) {
        this.rapportNummer = rapportNummer;
    }

    public BigDecimal getPris() {
        return pris;
    }

    public void setPris(BigDecimal pris) {
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
