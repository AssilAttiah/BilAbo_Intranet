package com.example.bilabo_intranet.controller;

import com.example.bilabo_intranet.model.Bil;
import com.example.bilabo_intranet.model.Kunde;
import com.example.bilabo_intranet.service.BilService;
import com.example.bilabo_intranet.service.KundeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BilController {

    @Autowired
    private BilService bilService;

    @Autowired
    private KundeService kundeService;

    @GetMapping("/dataregistrering")
    public String dataregistreringPage() {
        return "dataregistrering";
    }

    @PostMapping("/gemdata")
    public String gemData(@RequestParam("stelnummer") String stelnummer,
                          @RequestParam("mærke") String mærke,
                          @RequestParam("model") String model,
                          @RequestParam("status") String status,
                          @RequestParam("fornavn") String fornavn,
                          @RequestParam("efternavn") String efternavn,
                          @RequestParam("kørekortnummer") String kørekortnummer,
                          @RequestParam("aargang") String aargang,
                          @RequestParam("tid") String tid,
                          @RequestParam("unlimitedLeasing") int unlimitedLeasing,
                          Model modelAttr) {

        Bil bil = new Bil();
        bil.setStelnummer(stelnummer);
        bil.setMærke(mærke);
        bil.setModel(model);
        bil.setStatus(status);
        bil.setÅrgang(aargang);
        bil.setTid(tid);
        bil.setUnlimitedLeasing(unlimitedLeasing);

        bilService.saveBil(bil);

        Kunde kunde = new Kunde();
        kunde.setFornavn(fornavn);
        kunde.setEfternavn(efternavn);
        kunde.setKørekortnummer(kørekortnummer);

        kundeService.saveKunde(kunde);

        modelAttr.addAttribute("message", "Bil og kunde data er gemt!");

        return "dataregistrering";
    }
}
