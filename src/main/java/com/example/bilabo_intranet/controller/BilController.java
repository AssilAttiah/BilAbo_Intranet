package com.example.bilabo_intranet.controller;

import com.example.bilabo_intranet.model.Bil;
import com.example.bilabo_intranet.model.Kunde;
import com.example.bilabo_intranet.model.Leasingaftale;
import com.example.bilabo_intranet.service.BilService;
import com.example.bilabo_intranet.service.KundeService;
import com.example.bilabo_intranet.service.LeasingService;
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

    @Autowired
    private LeasingService leasingService;

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
                          @RequestParam(value="unlimitedLeasing", required=false) Integer unlimitedLeasing,
                          Model modelAttr) {

        if ("Unlimited (3 mdr - 36 mdr)".equals(tid) && (unlimitedLeasing == null || unlimitedLeasing < 3 || unlimitedLeasing > 36)) {
            modelAttr.addAttribute("message", "For 'Unlimited' leasing, skal leasingperioden være mellem 3 og 36 måneder.");
            return "dataregistrering";
        }

        Bil bil = new Bil();
        bil.setStelnummer(stelnummer);
        bil.setMærke(mærke);
        bil.setModel(model);
        bil.setStatus(status);
        bil.setÅrgang(aargang);

        bilService.saveBil(bil);

        Kunde kunde = new Kunde();
        kunde.setFornavn(fornavn);
        kunde.setEfternavn(efternavn);
        kunde.setKørekortnummer(kørekortnummer);

        kundeService.saveKunde(kunde);

        Leasingaftale leasingaftale = new Leasingaftale();
        leasingaftale.setLeasingType(tid);
        leasingaftale.setLeasingPeriode(Integer.parseInt(String.valueOf("Limited (5 mdr)".equals(tid) ? 5 : unlimitedLeasing)));

        leasingService.saveLeasingaftale(leasingaftale);

        modelAttr.addAttribute("message", "Bil og kunde data er gemt!");

        return "dataregistrering";
    }
}
