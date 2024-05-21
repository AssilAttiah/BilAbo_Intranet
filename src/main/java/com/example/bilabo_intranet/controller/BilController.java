package com.example.bilabo_intranet.controller;

import com.example.bilabo_intranet.model.Bil;
import com.example.bilabo_intranet.service.BilService;
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
        bil.setFornavn(fornavn);
        bil.setEfternavn(efternavn);
        bil.setKørekortnummer(kørekortnummer);
        bil.setÅrgang(aargang);
        bil.setTid(tid);
        bil.setUnlimitedLeasing(unlimitedLeasing);

        bilService.saveBil(bil);
        modelAttr.addAttribute("message", "Bil data er gemt!");

        return "dataregistrering";
    }
}